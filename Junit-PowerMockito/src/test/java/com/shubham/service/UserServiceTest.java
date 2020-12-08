package com.shubham.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.shubham.dao.UserDao;

public class UserServiceTest {

	@Test
	public void test_getName()
	{
		UserDao usermock=PowerMockito.mock(UserDao.class);
		when(usermock.findNameById(101)).thenReturn("shubham");
		UserService service=new UserService();
		service.setUserDao(usermock);
		String name=service.getName(101);
		assertNotNull(name);
		
	}
}
