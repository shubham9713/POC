package com.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

	@GetMapping("/show")
	public String showMsg()
	{
		return "WELCOME TO NARESH IT HYD";
	}
	
}

