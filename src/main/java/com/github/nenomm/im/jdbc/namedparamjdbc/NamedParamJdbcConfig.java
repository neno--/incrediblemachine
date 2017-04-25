package com.github.nenomm.im.jdbc.namedparamjdbc;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class NamedParamJdbcConfig {
	@Bean
	public DataSource dataSource1() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
				.setType(EmbeddedDatabaseType.HSQL).generateUniqueName(true)
				.addScript("classpath:sql/create-db.sql")
				.addScript("classpath:sql/insert-data.sql")
				.build();
		return db;
	}

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass("org.hsqldb.jdbc.JDBCDriver");
		ds.setJdbcUrl("jdbc:hsqldb:mem:testdb");
		ds.setUser("sa");
		ds.setPassword("");

		return ds;
	}

	// it is not necessary to define a bean like this because of @Repository anotation on SomeDao class.
	/*
	 * @Bean
	 * public SomeDao someDao() {
	 * return new SomeDao();
	 * }
	 */
}
