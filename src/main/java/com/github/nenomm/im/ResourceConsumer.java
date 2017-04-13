package com.github.nenomm.im;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceConsumer implements ApplicationContextAware, ResourceLoaderAware {
	static Logger logger = LoggerFactory.getLogger(ResourceConsumer.class);

	ApplicationContext context;
	ResourceLoader resourceLoader;

	// automatically added by spring
	Resource resource3;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	@PostConstruct
	public void runner() {
		Resource resource1 = context.getResource("classpath:classpath_fun/first.properties");
		if (resource1.exists()) {
			logger.info("resource exists");
		}
		else {
			logger.info("close, but no cigar");
		}

		Resource resource2 = context.getResource("classpath:classpath_fun/second.properties");

		resource3.exists();
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public void setResource3(Resource resource3) {
		this.resource3 = resource3;
	}
}
