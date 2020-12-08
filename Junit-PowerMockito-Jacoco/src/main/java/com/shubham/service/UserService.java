package com.shubham.service;

import com.shubham.dao.UserDao;

public class UserService  {

	private UserDao userDao=null;

	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

	public String getName(Integer id)
	{
		String name="";
		if(id>0)
		{
		 name=userDao.findNameById(id);
		}
		
		return name;
	}
	
	public String getEmail(Integer id)
	{
		String email="";
		if(id>0)
		{
		 email=userDao.findEmailById(id);
		}
		return email;
	}
}
