package com.shubham.ies.admin.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.ies.admin.domain.AccountReg;
import com.shubham.ies.admin.entity.AccountRegEntity;
import com.shubham.ies.admin.repository.AccountRegRepo;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRegRepo repo;
	
	
	@Override
	public Boolean saveAccountInfo(AccountReg ar) {

		AccountRegEntity entity=new AccountRegEntity();
		BeanUtils.copyProperties(ar, entity);
		
		return repo.save(entity)!=null?true:false;
	}

}
