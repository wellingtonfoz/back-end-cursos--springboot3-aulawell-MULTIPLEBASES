package app.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


@Configuration
@EnableJpaRepositories(
		basePackages = "app.repository", //colocar aqui o caminho do package dos REPOSITORIES desta configuração
		entityManagerFactoryRef = "base1EntityManager")
public class Base1Config {

	@Bean
	@Primary //SOMENTE A CLASSE BASEXCONFIG DA BASE PRINCIPAL DO SISTEMA DEVE TER ESSA ANNOTATION. SE FOR SECUNDÁRIA, RETIRE. 
	@ConfigurationProperties(prefix = "base1.datasource")
	public DataSource base1DataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean 
	@Primary //SOMENTE A CLASSE BASEXCONFIG DA BASE PRINCIPAL DO SISTEMA DEVE TER ESSA ANNOTATION. SE FOR SECUNDÁRIA, RETIRE.
	public LocalContainerEntityManagerFactoryBean base1EntityManager(
			EntityManagerFactoryBuilder builder,
			@Qualifier("base1DataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("app.entity") //colocar aqui o caminho do package das ENTITIES desta configuração
				.properties(hibernateProperties())
				.build();
	}


	//SOMENTE A CLASSE BASEXCONFIG DA BASE PRINCIPAL DO SISTEMA DEVE TER O MÉTODO ABAIXO.
	//SE ESTA FOR UMA BASE SECUNDÁRIA, RETIRE O MÉTODO ABAIXO E COMENTE A LINHA DE ERRO NO MÉTODO ACIMA
	private Map<String, Object> hibernateProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		return properties;
	}

}