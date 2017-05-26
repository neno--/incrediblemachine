package com.github.nenomm.im.cacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.nenomm.im.cacher.service.UserService;

public class Runner {
	static Logger logger = LoggerFactory.getLogger(Runner.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext simpleCacheTesting = new ClassPathXmlApplicationContext(
				new String[] { "classpath:cacher.xml" });

		UserService userService = (UserService) simpleCacheTesting.getBean("userService");
		logger.info("Got user: {}", userService.findUser(1).getName());

	}
}
