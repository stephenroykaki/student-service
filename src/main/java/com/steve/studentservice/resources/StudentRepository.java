package com.steve.studentservice.resources;

import org.springframework.data.repository.CrudRepository;

import com.steve.studentservice.models.Student;

public interface StudentRepository extends CrudRepository<Student, String>{

}
