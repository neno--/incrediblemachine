package com.github.nenomm.im;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Talker implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	public void doSomething() {
		Greeter greeter = (Greeter) applicationContext.getBean("greeter");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}


}
