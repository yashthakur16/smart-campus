package com.grey.smartCampus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grey.smartCampus.Model.Attendance;
import com.grey.smartCampus.Service.AttendanceService;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController 
{
	@Autowired
	AttendanceService as;
	
	@GetMapping("/getById/{id}")
	public Attendance getAttendanceByid(@PathVariable int id)
	{
		return as.getById(id);
	}
	
	@PostMapping("/addAttendance")
	public String addAttendance(@RequestBody Attendance A)
	{
		return as.addAttendance(A);
		
	}
	
	       

}
