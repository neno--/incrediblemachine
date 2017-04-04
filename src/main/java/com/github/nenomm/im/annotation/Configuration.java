package com.github.nenomm.im.annotation;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
// @ComponentScan(basePackages = "com.github.nenomm")
// Annotating a class with @Configuration indicates that its primary purpose is as a source of bean definitions.
public class Configuration {
	@Bean
	public BarGreeter barGreeter() {
		return new BarGreeter();
	}

	@Bean
	public FooGreeter something() {
		return new FooGreeter();
	}
}
