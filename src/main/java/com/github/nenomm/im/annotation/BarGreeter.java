package com.github.nenomm.im.annotation;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class BarGreeter {
	static Logger logger = LoggerFactory.getLogger(BarGreeter.class);

	private FooGreeter fooGreeter;

	@Autowired
	private FooGreeter anotherFooGreeter;

	@Required
	public void setFooGreeter(FooGreeter fooGreeter) {
		this.fooGreeter = fooGreeter;
	}

	@PostConstruct
	private void initMethod() {
		logger.info("Annotation based post contruct");
	}
}
