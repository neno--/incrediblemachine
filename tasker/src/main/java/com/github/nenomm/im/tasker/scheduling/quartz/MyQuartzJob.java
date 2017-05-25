package com.github.nenomm.im.tasker.scheduling.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyQuartzJob implements Job {
	static Logger logger = LoggerFactory.getLogger(MyQuartzJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Executing MyQuartzJob...");
	}
}
