package com.github.nenomm.im;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Talker implements ApplicationContextAware {
	static Logger logger = LoggerFactory.getLogger(Greeter.class);

	private ApplicationContext applicationContext;
	private Greeter greeterByStaticFactory;

	public void doSomething() {
		Greeter greeter = (Greeter) applicationContext.getBean("greeter");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void setGreeterByStaticFactory(Greeter greeterByStaticFactory) {
		this.greeterByStaticFactory = greeterByStaticFactory;
		logger.info("Autowired.");
	}

	public Greeter createNewGreeterEveryTime() {
		// this is a lookup method
		return null;
	}
}
