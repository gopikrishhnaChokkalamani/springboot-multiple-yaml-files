package com.gi.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gi.springboot.model.Address;
import com.gi.springboot.model.Student;

@Service
public class StudentService {

	private static List<Student> studentList = new ArrayList<Student>();

	static {
		Address addr = new Address("address of student", "FL", "12345");
		Student jack = new Student("100", "Jack", "Sam", "IV", "Chemistry", addr);
		// Student john = new Student(101, "John", "Red", "V", "Physics");
		// Student mary = new Student(102, "Mary", "Dan", "VI", "Maths");
		// Student mark = new Student(104, "Mark", "Bro", "VII", "Biology");

		studentList.add(jack);
		// studentList.add(john);
		// studentList.add(mary);
		// studentList.add(mark);
	}

	public List<Student> getStudentDetails() {
		// TODO Auto-generated method stub
		return new ArrayList<Student>(studentList);
	}

	public Student insertStudent(Student stdReqObj) {
		// TODO Auto-generated method stub
		studentList.add(stdReqObj);
		return stdReqObj;
	}

}
