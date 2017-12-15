package com.gi.springboot.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gi.springboot.model.Student;
import com.gi.springboot.service.StudentService;
import com.gi.springboot.validator.StudentValidator;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentValidator studentValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(studentValidator);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Student insertStudent(@Validated @RequestBody Student stdReqObj) {
		System.out.println(stdReqObj.getStudentFirstName());
		return studentService.insertStudent(stdReqObj);
	}
}
