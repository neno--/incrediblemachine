package com.github.nenomm.im.environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.nenomm.im.BeanProcessor;

@Configuration
public class EnvConfig {
	static Logger logger = LoggerFactory.getLogger(BeanProcessor.class);

	@Profile("dev")
	@Bean(name = "strange")
	Object generateObject1() {
		logger.info("dev profile is active");
		return 42;
	}

	@Profile("test")
	@Bean(name = "strange")
	Object generateObject2() {
		logger.info("test profile is active");
		return 42;
	}

	@Profile("!prod")
	@Bean(name = "strange")
	Object generateObject3() {
		logger.info("prod profile is not active");
		return 42;
	}
}
