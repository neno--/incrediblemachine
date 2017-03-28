package com.github.nenomm.im;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Talker implements ApplicationContextAware, InitializingBean, BeanNameAware {
	static Logger logger = LoggerFactory.getLogger(Greeter.class);

	private ApplicationContext applicationContext;
	private Greeter greeterByStaticFactory;
	private String myNameIs;

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

	@Override
	public void afterPropertiesSet() throws Exception {
		// this one should not be used - introduces unnecessary coupling with spring.
		logger.info("Hi, I am {}.", myNameIs);
	}

	@PostConstruct
	public void initMethod() {
		// do some init work
	}

	@PreDestroy
	public void dispose() {
		// cleanup work
	}

	@Override
	public void setBeanName(String name) {
		myNameIs = name;
	}
}
