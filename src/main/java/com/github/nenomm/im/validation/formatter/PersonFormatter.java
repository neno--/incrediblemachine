package com.github.nenomm.im.validation.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.github.nenomm.im.validation.Person;

public class PersonFormatter implements Formatter<Person> {

	@Override
	public Person parse(String text, Locale locale) throws ParseException {
		return null;
	}

	@Override
	public String print(Person object, Locale locale) {
		StringBuilder sb = new StringBuilder();
		return new StringBuilder("Person{name(").append(object.getName()).append("), age(").append(object.getAge())
				.append(")}").toString();
	}
}
