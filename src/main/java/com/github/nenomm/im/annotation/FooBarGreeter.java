package com.github.nenomm.im.annotation;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FooBarGreeter {
	static Logger logger = LoggerFactory.getLogger(FooBarGreeter.class);

	@PostConstruct
	private void initMethod() {
		logger.info("Annotation based post contruct for component");
	}
}
