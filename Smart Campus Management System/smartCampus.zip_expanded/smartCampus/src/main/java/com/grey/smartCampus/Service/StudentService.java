package com.grey.smartCampus.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.grey.smartCampus.Model.Student;
import com.grey.smartCampus.Repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	StudentRepository sr;

	public ResponseEntity<String> addStudent(Student S) {
		
		sr.save(S);
		
		return new ResponseEntity<>("added Successfuly",HttpStatus.OK);
	}

	public ResponseEntity<List<Student>> getStudent() 
	{
		return new ResponseEntity<>(sr.findAll(),HttpStatus.OK);
		
	}

	public Student getStudentByid(int id) {
		return sr.getById(id);
	}
	
}
