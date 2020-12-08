package com.shubham.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.entity.UserAccountEntity;

public interface UserRepository extends JpaRepository<UserAccountEntity, Serializable> {

	//select * from User_Account where user_email=:email;
	public UserAccountEntity  findByUserEmail(String userEmail);
	
	public UserAccountEntity findByUserEmailAndUserpwd(String email,String pwd);
	
	
	
}
