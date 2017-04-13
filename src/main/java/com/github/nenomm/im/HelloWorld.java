package com.github.nenomm.im;

import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.nenomm.im.another.AppConfig;
import com.github.nenomm.im.validation.Person;
import com.github.nenomm.im.validation.PersonValidator;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.ValidationUtils;

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

		ConfigurableApplicationContext validationContext = new ClassPathXmlApplicationContext(new String[] { "validation.xml" });
		validationTesting(validationContext);
		conversionTesting(validationContext);
	}

	private static void validationTesting(ConfigurableApplicationContext context) {


		Person person = (Person) context.getBean("person");
		PersonValidator personValidator = (PersonValidator) context.getBean("validator");

		BeanWrapper wrapped = new BeanWrapperImpl(person);
		wrapped.setPropertyValue(new PropertyValue("age", 22));

		person.getAge();

		Person another = (Person) context.getBean("anotherPerson");
		another.getFriend().getName();
	}

	private static void conversionTesting(ConfigurableApplicationContext context) {
		ConversionService service = (ConversionService) context.getBean("conversionService");
		Person mrMbar = service.convert("Mr.Bar/22", Person.class);
		mrMbar.getName();
	}

}