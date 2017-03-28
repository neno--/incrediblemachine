package com.github.nenomm.im;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.Lifecycle;

public class ImportantObject  implements Lifecycle{
	static Logger logger = LoggerFactory.getLogger(ImportantObject.class);

	@Override
	public void start() {
		logger.info("App context is starting");
	}

	@Override
	public void stop() {
		logger.info("App context is stopping");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
