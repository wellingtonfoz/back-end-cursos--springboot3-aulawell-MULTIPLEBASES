package app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


@Configuration
@EnableJpaRepositories(
		basePackages = "app.uniamerica.repository", //colocar aqui o caminho do package dos REPOSITORIES desta configuração
		entityManagerFactoryRef = "base2EntityManager")
public class Base2Config {
	
	@Bean
	@ConfigurationProperties(prefix = "base2.datasource") //atualizar o numero da base dessa config
	public DataSource base2DataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean base2EntityManager(
			EntityManagerFactoryBuilder builder,
			@Qualifier("base2DataSource") DataSource dataSource) { //atualizar o numero da base dessa config
		return builder
				.dataSource(dataSource)
				.packages("app.uniamerica.entity") //colocar aqui o caminho do package das ENTITIES desta configuração
				.build();
	}
	
}