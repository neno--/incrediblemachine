package com.github.nenomm.im.orm.simplesetup;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class SimpleSetupConfiguration {
	@Value("${hibernate.dialect}")
	String hibernateDialect;

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
				.setType(EmbeddedDatabaseType.HSQL).generateUniqueName(true)
				.addScript("classpath:sql/create-db.sql")
				.addScript("classpath:sql/insert-data.sql")
				.build();

		return db;
	}

	@Bean(name = "sessionFactory")
	LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setMappingResources("hibernate/simple_setup_hbm.xml");
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());

		return localSessionFactoryBean;
	}

	Properties hibernateProperties() {

		return new Properties() {
			{
				setProperty("hibernate.dialect", hibernateDialect);
			}
		};
	}
}
