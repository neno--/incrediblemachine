package com.github.nenomm.im.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoorLittleObject {
	static Logger logger = LoggerFactory.getLogger(PoorLittleObject.class);

	public void helpMe() {
		logger.info("Executing helpMe()");
	}
}
