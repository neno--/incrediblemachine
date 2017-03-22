package com.github.nenomm.im;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreeterFactory {
	static Logger logger = LoggerFactory.getLogger(GreeterFactory.class);

	public Greeter createInstance() {
		logger.info("Creating Greeter by instance factory method.");
		return new Greeter();
	}
}
