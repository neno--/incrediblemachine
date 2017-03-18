package com.github.nenomm.im;

import org.joda.time.LocalTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);

		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "test.xml" });
	}
}