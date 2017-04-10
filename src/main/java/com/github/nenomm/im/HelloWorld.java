package com.github.nenomm.im;

import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.nenomm.im.another.AppConfig;

public class HelloWorld {
	static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);

		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "main.xml" });

		context.getEnvironment().setActiveProfiles("dev");
		context.refresh();

		// activates lifecycle management of important object
		context.registerShutdownHook();

		Greeter fromSpring = (Greeter) context.getBean("greeter");

		MessageSource messageSource = (MessageSource) context;

		logger.info("{}", messageSource.getMessage("greeting", new String[] { "8472" }, null));

		ApplicationContext ctx1 = new AnnotationConfigApplicationContext(AppConfig.class);
		logger.info("Got strange one: {}", ctx1.getBean("strange"));

		if (ctx1.getEnvironment().containsProperty("OS")) {
			logger.info("running on windows");
		}
		else if (ctx1.getEnvironment().containsProperty("SHELL")) {
			logger.info("running on linux");
		}
	}
}