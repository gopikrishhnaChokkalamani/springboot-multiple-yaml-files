package com.gi.springboot.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gi.springboot.model.Student;
import com.gi.springboot.properties.AddressProperty;

@Component
public class AddressValidator implements Validator {

	@Autowired
	private AddressProperty addressProperty;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student obj = (Student) target;
		List<com.gi.springboot.properties.AddressProperty.Request> property = addressProperty.getRequest();
		int i = 0;
	}

}
