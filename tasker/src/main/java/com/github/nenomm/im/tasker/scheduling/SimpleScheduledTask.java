package com.github.nenomm.im.tasker.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleScheduledTask implements Runnable {
	static Logger logger = LoggerFactory.getLogger(SimpleScheduledTask.class);

	private String taskName;

	public SimpleScheduledTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		logger.info("Executing task: {}", taskName);
	}
}
