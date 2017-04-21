package com.github.nenomm.im.jdbc.simplejdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class SimpleJdbcConfig {
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
				.setType(EmbeddedDatabaseType.HSQL)
				//.addScript("classpath:sql/create-db.sql")
				//.addScript("classpath:sql/insert-data.sql")
				.build();
		return db;
	}

/*	@Bean
	public SomeDao someDao() {
		return new SomeDao();
	}*/
}
