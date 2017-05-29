package com.github.nenomm.im.cacher;

import javax.sql.DataSource;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.github.nenomm.im.jdbc.simplejdbc.SomeDao;

@Configuration
@EnableCaching
public class CacherConfig {
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

	@Bean
	public SomeDao someDao() {
		return new SomeDao();
	}

/*	@Bean
	public CacheManager cacheManager() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));

		EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
		ehCacheCacheManager.setCacheManager(ehCacheManagerFactoryBean.getObject());

		return ehCacheCacheManager;
	}*/
}
