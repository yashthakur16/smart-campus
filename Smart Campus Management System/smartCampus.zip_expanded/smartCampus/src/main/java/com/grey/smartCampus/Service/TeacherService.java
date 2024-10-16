package com.grey.smartCampus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grey.smartCampus.Model.Teacher;
import com.grey.smartCampus.Repository.TeacherRepository;

@Service
public class TeacherService 
{
	@Autowired
	TeacherRepository tr;

	public String addTeacher(Teacher t) {
		
		tr.save(t);
		return "Added Succesfully";
	}

	public Teacher getTeacher(int id) {
		return tr.getById(id);
	}
	
	
}
