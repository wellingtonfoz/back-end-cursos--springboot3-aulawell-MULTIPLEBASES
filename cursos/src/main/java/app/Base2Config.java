package app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "app.uniamerica.repository", //caminho dos repositories desta base
		entityManagerFactoryRef = "base2EntityManagerFactory", //atualizar o nome "baseX"
		transactionManagerRef = "base2TransactionManager" //atualizar o nome "baseX"
		)
public class Base2Config {
	
		
	@Bean
	@ConfigurationProperties(prefix = "base2.datasource") //caminho da baseX no properties
	public DataSource base2DataSource() {
	    DataSource dataSource = DataSourceBuilder.create().build();
	    System.out.println("Conexão com a Base 2: " + dataSource); //atualizar o nome "baseX"
	    return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean base2EntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(base2DataSource())
				.packages("app.uniamerica.model") //caminho dos entities desta base
				.persistenceUnit("base2") //atualizar o nome "baseX"
				.build();
	}

	@Bean
	public PlatformTransactionManager base2TransactionManager(  //atualizar o nome "baseX"
			@Qualifier("base2EntityManagerFactory") EntityManagerFactory base2EntityManagerFactory) { //atualizar o nome "baseX" nos 2
		return new JpaTransactionManager(base2EntityManagerFactory); 
	}
}
