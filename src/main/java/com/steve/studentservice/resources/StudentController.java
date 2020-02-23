package com.steve.studentservice.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.steve.studentservice.models.Student;

@RestController
public class StudentController {
	
	//@Autowired
	//private StudentService service;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/students")
	public List<Student> getStudentDetails(){
		List<Student> list = new ArrayList<>();
		studentRepository.findAll().forEach(list::add);
		return list;
		//return service.getAll();
	}
	
	@RequestMapping("/students/{id}")
	public Optional<Student> getStudentById(@PathVariable String id) {
		return studentRepository.findById(id);
		//return service.getStudentById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public void delStudentById(@PathVariable("id") String id) {
		studentRepository.deleteById(id);
		//service.delStudent(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/students")
	public void editStudent(@RequestBody Student student) {
		studentRepository.save(student);
		//service.editStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public void addStudent(@RequestBody Student student) {
		studentRepository.save(student);
		//service.addStudent(student);
	}
}
