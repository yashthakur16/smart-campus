package com.grey.smartCampus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grey.smartCampus.Model.Student;
import com.grey.smartCampus.Service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController 
{
	@Autowired
	StudentService ss;
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student S)
	{
		return ss.addStudent(S); 
	}
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getStudent()
	{
		return ss.getStudent();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudentByid(@PathVariable int id)
	{
		return ss.getStudentByid(id);
	}
}
