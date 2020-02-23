package com.steve.studentservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.steve.studentservice.models.Student;

@Service
public class StudentService {
	private List<Student> list = new ArrayList<Student>(Arrays.asList(
			new Student("1", "rajesh", "rgukt"),
			new Student("2", "steve", "rgukt"),
			new Student("3", "nagarjuna", "rgukt")
	));
	
	public List<Student> getAll(){
		return list;
	}
	
	public Student getStudentById(String id) {
		return list.stream().filter(s -> s.getId().equals(id)).findFirst().get();
	}
	
	public void addStudent(Student student) {
		list.add(student);
	}
	
	public void editStudent(Student student) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(student.getId())) {
				list.set(i, student);
				return;
			}
		}
	}
	
	public void delStudent(String id) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				return;
			}
		}
	}
}
