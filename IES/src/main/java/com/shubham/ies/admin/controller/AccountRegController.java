package com.shubham.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shubham.ies.admin.domain.AccountReg;
import com.shubham.ies.admin.service.AccountService;

@Controller
public class AccountRegController {

	@Autowired
	private AccountService service;
	
	@GetMapping("/accReg")
	private String showAccountRegForm(Model model,AccountReg ar)
	{
		model.addAttribute("accReg",new AccountReg());
		
		return "AccRegForm";
	}
}
