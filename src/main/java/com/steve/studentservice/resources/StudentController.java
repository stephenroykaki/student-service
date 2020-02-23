package com.steve.studentservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.steve.studentservice.models.Student;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping("/students")
	public List<Student> getStudentDetails(){
		return service.getAll();
	}
	
	@RequestMapping("/students/{id}")
	public Student getStudentById(@PathVariable String id) {
		return service.getStudentById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public void delStudentById(@PathVariable("id") String id) {
		service.delStudent(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/students")
	public void editStudent(@RequestBody Student student) {
		service.editStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public void addStudent(@RequestBody Student student) {
		service.addStudent(student);
	}
}
