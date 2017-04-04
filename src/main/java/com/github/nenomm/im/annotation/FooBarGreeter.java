package com.github.nenomm.im.annotation;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FooBarGreeter {
	static Logger logger = LoggerFactory.getLogger(FooBarGreeter.class);

	@PostConstruct
	private void initMethod() {
		logger.info("Annotation based post contruct for component");
	}

	// when invoked from @Component, @Beans do not get proxied by CGLIB
	@Bean
	public FooGreeter makeFromComponent(@Value("${another.property}") int i) {
		// if you want to use autowiring, use #{} syntax instead
		FooGreeter fooGreeter = new FooGreeter(i);
		return fooGreeter;
	}

	@Bean
	public FooGreeter anotherFooGreeter(@Value("${another.property}") int i) {
		FooGreeter fooGreeter = new FooGreeter(i);
		return fooGreeter;
	}
}
