package com.shubham.ies.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.ies.admin.entity.AccountRegEntity;

public interface AccountRegRepo extends JpaRepository<AccountRegEntity, Serializable> {
	
	

}
