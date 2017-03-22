package com.github.nenomm.im;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Greeter {
	static Logger logger = LoggerFactory.getLogger(Greeter.class);

	public String sayHello() {
		return "Hello world!";
	}

	public static Greeter createInstance() {
		logger.info("Creating Greeter by static factory method.");
		return new Greeter();
	}
}
