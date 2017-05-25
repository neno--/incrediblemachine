package com.github.nenomm.im.tasker.scheduling;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;

public class NaiveScheduler {
	static Logger logger = LoggerFactory.getLogger(NaiveScheduler.class);

	private TaskScheduler taskScheduler;

	@Autowired
	private AnnotatedTask annotatedTask;

	public void setTaskScheduler(TaskScheduler taskScheduler) {
		this.taskScheduler = taskScheduler;
	}

	public void registerForOneTime(Runnable runnable, DateTime startTime) {
		taskScheduler.schedule(runnable, startTime.toDate());
	}

	public void registerWithFixedDelay(Runnable runnable, Duration duration) {
		taskScheduler.scheduleWithFixedDelay(runnable, duration.getMillis());
	}

	public void registerCustomSchedule(Runnable runnable) {
		taskScheduler.schedule(runnable, new TriggerHappy());
	}

	public void fireUp() {
		logger.info("Registering tasks...");
		// registerForOneTime(new SimpleScheduledTask("TaskOne"), (new DateTime()).plusSeconds(10));
		// registerWithFixedDelay(new SimpleScheduledTask("TaskTwo"), Duration.standardSeconds(60));
		// registerCustomSchedule(new SimpleScheduledTask("TaskThree"));
		annotatedTask.returnSomething(34);
	}
}
