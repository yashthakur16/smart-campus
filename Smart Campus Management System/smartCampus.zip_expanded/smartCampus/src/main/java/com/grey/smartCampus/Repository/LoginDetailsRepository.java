package com.grey.smartCampus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grey.smartCampus.Model.LoginDetails;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Integer>{

	boolean existsByUsernameAndPassword(String username, String password);

}
