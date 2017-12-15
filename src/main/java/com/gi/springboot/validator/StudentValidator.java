package com.gi.springboot.validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gi.springboot.model.Student;
import com.gi.springboot.properties.StudentProperty;
import com.gi.springboot.properties.StudentProperty.Request;

@Component
public class StudentValidator implements Validator {

	@Autowired
	private StudentProperty studentProperty;
	
	@Autowired
	private AddressValidator addressValidator;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		Student studentObject = (Student) obj;

		List<Request> property = studentProperty.getRequest();

		for (Request prop : property) {
			try {
				Object[] commandArg = new Object[] { studentObject, errors, prop };
				Class[] argTypes = new Class[] { Student.class, Errors.class,Request.class };
				Method callMethod = this.getClass().getMethod(prop.getValidateMethod(), argTypes);
				callMethod.invoke(this, commandArg);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void validateStudentId(Student studentObject, Errors errors, Request prop) {
		if (prop.getMandatory()) {
			if (checkNullAndEmpty(studentObject.getStudentId())) {
				errors.rejectValue("studentId", "100", "studentId cannot be null or empty");
			}
		}
		if (!checkMaxLength(studentObject.getStudentId(), prop.getMax())) {
			errors.rejectValue("studentId", "101", "studentId cannot be more than 10");
		}
	}
	
	public void validateStudentAddress(Student studentObject, Errors errors, Request prop){
		ValidationUtils.invokeValidator(addressValidator, studentObject, errors);
	}
	

	public void validateStudentFirstName(Student studentObject, Errors errors, Request prop) {

	}

	public void validateStudentLastName(Student studentObject, Errors errors, Request prop) {

	}

	public void validateSection(Student studentObject, Errors errors, Request prop) {

	}

	public void validateMajor(Student studentObject, Errors errors, Request prop) {

	}

	public boolean checkNullAndEmpty(String inputValue) {
		if (null == inputValue || "".equalsIgnoreCase(inputValue)) {
			return true;
		}
		return false;
	}

	public boolean checkMaxLength(String field, int maxLength) {
		int fieldLength = field.length();
		if (fieldLength > maxLength) {
			return false;
		}
		return true;
	}
}
