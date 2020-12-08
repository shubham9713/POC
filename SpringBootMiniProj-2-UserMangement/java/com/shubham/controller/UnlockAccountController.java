package com.shubham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shubham.dto.UnlockAccount;
import com.shubham.service.UserService;

@Controller
public class UnlockAccountController {

	@Autowired
	private UserService service;
	
	/**
	 * This method is used to load unlock-account form
	 * @param email
	 * @param model
	 * @return String 
	 */
	@GetMapping("/unlockAcc")
	public String loadUnlockAccForm(@RequestParam String email,Model model)
	{
		UnlockAccount account=new UnlockAccount();
		account.setEmail(email);
		model.addAttribute("userAcc", account);
		
		return "unlockAcc";
	}
	/**
	 * This method is used to handle unlock-account form submission
	 * @param unlockAcc
	 * @param model
	 * @return String
	 */
	@PostMapping("/unlockAcc")
	public String handleSubmitBtn(@ModelAttribute("userAcc") UnlockAccount unlockAcc ,Model model)
	{
		boolean isValid = service.isTempPwdValid( unlockAcc.getEmail(),  unlockAcc.getTempPwd());
		if(isValid)
		{
			service.unlockAccount( unlockAcc.getEmail(),  unlockAcc.getNewPwd());
			model.addAttribute("succ", "your Account Unlocked Successfully");
		}
		else
		{
			model.addAttribute("fail", "Please Enter Correct temp pwd");
		}
		return "unlockAcc";
	}
}
