package com.grey.smartCampus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grey.smartCampus.Model.LoginDetails;
import com.grey.smartCampus.Service.LoginDetailsService;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*")
public class LoginDetailsController 
{
	  @Autowired
	    private LoginDetailsService loginDetailsService;

	    @GetMapping("/check")
	    public ResponseEntity<Boolean> checkLogin(@RequestParam String username, @RequestParam String password) {
	        boolean exists = loginDetailsService.checkLogin(username, password);
	        return ResponseEntity.ok(exists);
	    }
	    
	    @PostMapping("addDetails")
	    public String addDeatils(@RequestBody LoginDetails d)
	    {
	    	return loginDetailsService.addDetails(d);
	    }
}
