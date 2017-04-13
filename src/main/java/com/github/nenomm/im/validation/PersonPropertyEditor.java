package com.github.nenomm.im.validation;

import java.beans.PropertyEditorSupport;

public class PersonPropertyEditor extends PropertyEditorSupport {
	public void setAsText(String text) {
		Person result = new Person();

		String name = text.split("/")[0];
		int age = Integer.parseInt(text.split("/")[1]);

		result.setName(name);
		result.setAge(age);

		setValue(result);
	}
}
