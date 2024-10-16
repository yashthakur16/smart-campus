package com.grey.smartCampus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grey.smartCampus.Model.Teacher;
import com.grey.smartCampus.Service.TeacherService;

@RestController
@RequestMapping("teacher")
@CrossOrigin(origins = "*")
public class TeacherController 
{
	
	@Autowired
	TeacherService ts;
	
	@PostMapping("/addTeacher")
	public String addAttendance(@RequestBody Teacher T)
	{
		return ts.addTeacher(T);
		
	}
	
	@GetMapping("/getTeacher/{id}")
	public Teacher getTeacher(@PathVariable int id)
	{
		return ts.getTeacher(id);
	}
}
