package com.grey.smartCampus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grey.smartCampus.Model.LoginDetails;
import com.grey.smartCampus.Repository.LoginDetailsRepository;

@Service
public class LoginDetailsService 
{

	@Autowired
    private LoginDetailsRepository loginDetailsRepository;

    public boolean checkLogin(String username, String password) {
        return loginDetailsRepository.existsByUsernameAndPassword(username, password);
    }

	public String addDetails(LoginDetails d) {
		loginDetailsRepository.save(d);
		return "Added successfully";
	}
}
