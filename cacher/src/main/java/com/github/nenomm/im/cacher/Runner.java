package com.github.nenomm.im.cacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.nenomm.im.cacher.service.UserService;

public class Runner {
	static Logger logger = LoggerFactory.getLogger(Runner.class);
	private UserService userService;

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.doRun();

	}

	private void doRun() {
		ConfigurableApplicationContext simpleCacheTesting = new ClassPathXmlApplicationContext(
				new String[] { "classpath:cacher.xml" });

		userService = (UserService) simpleCacheTesting.getBean("userService");

		testNonCachedMethod();
		testCachedMethod();
	}

	private void testNonCachedMethod() {
		for (int i = 0; i < 10; i++) {
			logger.info("Got user: {}", userService.findUser(1).getName());
		}
	}

	private void testCachedMethod() {
		for (int i = 0; i < 10; i++) {
			logger.info("[cached] Got user: {}", userService.findCachedUser((i % 4) + 1).getName());
		}
	}
}
