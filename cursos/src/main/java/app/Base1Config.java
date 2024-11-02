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
		basePackages = "app.repository", //caminho dos repositories desta base
		entityManagerFactoryRef = "base1EntityManagerFactory", //atualizar o nome "baseX"
		transactionManagerRef = "base1TransactionManager" //atualizar o nome "baseX"
		)
public class Base1Config {
	
		
	@Bean
	@ConfigurationProperties(prefix = "base1.datasource") //caminho da baseX no properties
	public DataSource base1DataSource() {
	    DataSource dataSource = DataSourceBuilder.create().build();
	    System.out.println("Conexão com a Base 1: " + dataSource); //atualizar o nome "baseX"
	    return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean base1EntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(base1DataSource())
				.packages("app.model") //caminho dos entities desta base
				.persistenceUnit("base1") //atualizar o nome "baseX"
				.build();
	}

	@Bean
	public PlatformTransactionManager base1TransactionManager(  //atualizar o nome "baseX"
			@Qualifier("base1EntityManagerFactory") EntityManagerFactory base1EntityManagerFactory) { //atualizar o nome "baseX" nos 2
		return new JpaTransactionManager(base1EntityManagerFactory); 
	}
}
