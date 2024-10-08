package com.grey.smartCampus.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates student_id
    private int student_id;

    private String Full_name;
    
    private String phone_no;
    private LocalDate birthday;
    private String blood_group;
    private String address;
    private String email;
    private String department;
    private String Division;

    
    
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFull_name() {
		return Full_name;
	}
	public void setFull_name(String full_name) {
		Full_name = full_name;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", Full_name=" + Full_name + ", phone_no=" + phone_no
				+ ", birthday=" + birthday + ", blood_group=" + blood_group + ", address=" + address + ", email="
				+ email + "]";
	}

  
    
    
}
