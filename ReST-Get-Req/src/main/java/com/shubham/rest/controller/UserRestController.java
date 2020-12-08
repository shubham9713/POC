package com.shubham.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.model.User;

@RestController
public class UserRestController {

	@GetMapping(value = "/user" ,produces = {"application/xml","application/json"})
	public User userData(User user)
	{
		user.setUId(101);
		user.setUName("shubham");
		
		return user;
	}
}
