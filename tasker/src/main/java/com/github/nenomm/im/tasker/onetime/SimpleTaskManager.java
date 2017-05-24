package com.github.nenomm.im.tasker.onetime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.core.task.TaskRejectedException;

public class SimpleTaskManager {
	static Logger logger = LoggerFactory.getLogger(SimpleTaskManager.class);

	private class SimpleTask implements Runnable {

		private String message;

		public SimpleTask(String message) {
			this.message = message;
		}

		public void run() {
			logger.info(message);
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {

			}
		}

	}

	private TaskExecutor taskExecutor;

	public SimpleTaskManager(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void printMessages() {
		for (int i = 1; i <= 50; i++) {
			logger.info("Preparing to run task: {}", i);
			try {
				taskExecutor.execute(new SimpleTask("Message" + i));
			}
			catch (TaskRejectedException e) {
				logger.error("Cannot run task: {}", i);
			}
		}
	}
}
