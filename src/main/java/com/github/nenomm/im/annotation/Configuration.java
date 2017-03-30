package com.github.nenomm.im.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
// @ComponentScan(basePackages = "com.github.nenomm")
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
