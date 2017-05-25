package com.github.nenomm.im.tasker.scheduling;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AnnotatedTask {
	static Logger logger = LoggerFactory.getLogger(AnnotatedTask.class);

	@Scheduled(fixedDelay = 2000)
	public void doSomething() {
		logger.info("There it blows...");
	}

	@Async
	Future<String> returnSomething(int i) {
		logger.info("There it blew...");
		return null;
	}
}
