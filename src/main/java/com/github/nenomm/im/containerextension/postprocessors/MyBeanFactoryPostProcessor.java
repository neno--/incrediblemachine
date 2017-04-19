package com.github.nenomm.im.containerextension.postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		for (String name : beanFactory.getBeanDefinitionNames()) {
			if (name.equals("someGuy")) {
				BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
				beanDefinition.getPropertyValues();
			}
		}
	}
}
