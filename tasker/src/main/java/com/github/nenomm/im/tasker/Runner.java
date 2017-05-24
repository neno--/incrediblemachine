package com.github.nenomm.im.tasker;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.nenomm.im.tasker.onetime.SimpleTaskManager;

public class Runner {
	public static void main(String[] args) {
		ConfigurableApplicationContext simpleTaskTesting = new ClassPathXmlApplicationContext(
				new String[] { "classpath:task.xml" });

		SimpleTaskManager manager = (SimpleTaskManager) simpleTaskTesting.getBean("simpleTaskManager");
		manager.printMessages();

	}
}
