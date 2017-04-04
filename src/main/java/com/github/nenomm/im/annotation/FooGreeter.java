package com.github.nenomm.im.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FooGreeter {
	static Logger logger = LoggerFactory.getLogger(FooGreeter.class);

	public FooGreeter() {
	}

	public FooGreeter(int i) {
		logger.info("Initialized with custom constructor. Value is {}", i);
	}

}
