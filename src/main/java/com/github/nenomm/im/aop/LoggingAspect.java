package com.github.nenomm.im.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
	static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	public LoggingAspect() {
		logger.info("creating logging aspect");
	}

	// @Before("com.github.nenomm.im.aop.PoorLittleObject.helpMe()")
	// @Before("execution(* com.github.nenomm.im.aop.*.*(..))")
	// @Pointcut("execution(* helpMe(..))")// the pointcut expression
	public void advice() { // the pointcut signature
		logger.info("Executing advice!");
	}

}
