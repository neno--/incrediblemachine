package com.github.nenomm.im.tasker.scheduling;

import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

public class TriggerHappy implements Trigger {
	static Logger logger = LoggerFactory.getLogger(TriggerHappy.class);

	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {
		logger.info("Invoking next execution time...");
		logger.info(
				"Trigger context - lastActualExecutionTime: {}, lastCompletionTime: {}, lastScheduledExecutionTime: {}",
				triggerContext.lastActualExecutionTime(), triggerContext.lastCompletionTime(),
				triggerContext.lastScheduledExecutionTime());

		return new DateTime().plusSeconds(10).toDate();
	}
}
