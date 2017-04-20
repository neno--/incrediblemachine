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
import org.springframework.core.convert.ConversionService;

import com.github.nenomm.im.another.AppConfig;
import com.github.nenomm.im.aop.PoorLittleObject;
import com.github.nenomm.im.scopes.NeedyObject;
import com.github.nenomm.im.scopes.TransientCollaborator;
import com.github.nenomm.im.tx.MyService;
import com.github.nenomm.im.tx.MyServiceException;
import com.github.nenomm.im.validation.Person;
import com.github.nenomm.im.validation.PersonValidator;

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

		ConfigurableApplicationContext validationContext = new ClassPathXmlApplicationContext(
				new String[] { "validation.xml" });
		validationTesting(validationContext);
		conversionTesting(validationContext);

		ConfigurableApplicationContext scopesContext = new ClassPathXmlApplicationContext(
				new String[] { "scopes.xml" });
		scopesTesting(scopesContext);

		ConfigurableApplicationContext aopContext = new ClassPathXmlApplicationContext(
				new String[] { "aop.xml" });
		aopTesting(aopContext);

		ConfigurableApplicationContext txContext = new ClassPathXmlApplicationContext(
				new String[] { "transactions.xml" });
		txTesting(txContext);
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

	private static void scopesTesting(ConfigurableApplicationContext context) {
		NeedyObject first = (NeedyObject) context.getBean("firstNeedy");
		NeedyObject second = (NeedyObject) context.getBean("secondNeedy");
		TransientCollaborator collaborator1 = first.getCollaborator();
		TransientCollaborator collaborator2 = second.getCollaborator();

		boolean theSame = first.getCollaborator() == second.getCollaborator();

		context.refresh();

		NeedyObject newFirst = (NeedyObject) context.getBean("firstNeedy");
		NeedyObject newSecond = (NeedyObject) context.getBean("secondNeedy");

		assert first != newFirst;
		assert first.getCollaborator() == collaborator1;
		assert newFirst.getCollaborator() != collaborator1;
		// on context refresh beans are reinitialized! - see
		// http://docs.spring.io/spring/docs/2.5.6/javadoc-api/org/springframework/context/ConfigurableApplicationContext.html#refresh%28%29

		first = (NeedyObject) context.getBean("first");
		second = (NeedyObject) context.getBean("second");
		NeedyObject third = (NeedyObject) context.getBean("third");

		assert first.getCollaborator() == second.getCollaborator();
		assert second.getCollaborator() != third.getCollaborator();
	}

	private static void aopTesting(ConfigurableApplicationContext context) {
		PoorLittleObject littleOne = (PoorLittleObject) context.getBean("littleOne");
		littleOne.helpMe();
	}

	private static void txTesting(ConfigurableApplicationContext context) {
		MyService myService = (MyService) context.getBean("myService");

		logger.info("Number of users is: {}", myService.getNumberOfUsers());
		try {
			myService.playAroundWithTx();
		}
		catch (MyServiceException e) {
			logger.warn("Exception caught.", e);
		}
		logger.info("Third count: {}", myService.getNumberOfUsers());
	}

}