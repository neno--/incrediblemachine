package com.github.nenomm.im.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

	@Bean
	public LoggingAspect createAspect() {
		return new LoggingAspect();
	};

	@Bean(name = "littleOne")
	public PoorLittleObject create() {
		return new PoorLittleObject();
	}

}
