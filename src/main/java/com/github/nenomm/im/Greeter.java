package com.github.nenomm.im;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Greeter {
	static Logger logger = LoggerFactory.getLogger(Greeter.class);
	private Greeter greeter;
	private int number;
	private Map<Integer, Integer> aMap = new HashMap<>();


	public String sayHello() {
		return "Hello world!";
	}

	public static Greeter createInstance() {
		logger.info("Creating Greeter by static factory method.");
		return new Greeter();
	}

	public void setFriend(Greeter greeter) {
		this.greeter = greeter;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setaMap(Map<Integer, Integer> aMap) {
		this.aMap = aMap;
	}
}
