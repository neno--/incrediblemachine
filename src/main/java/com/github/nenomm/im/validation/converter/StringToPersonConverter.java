package com.github.nenomm.im.validation.converter;

import org.springframework.core.convert.converter.Converter;
import com.github.nenomm.im.validation.Person;

public class StringToPersonConverter implements Converter<String, Person> {
	@Override
	public Person convert(String source) {
		Person result = new Person();

		String name = source.split("/")[0];
		int age = Integer.parseInt(source.split("/")[1]);

		result.setName(name);
		result.setAge(age);

		return result;
	}
}
