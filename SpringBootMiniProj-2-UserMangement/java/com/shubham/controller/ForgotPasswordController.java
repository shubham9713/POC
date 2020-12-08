package com.shubham.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shubham.service.UserService;

@Controller
public class ForgotPasswordController {

	@Autowired
	private UserService service;
	
	/**
	 * This method is used to load forgot password form
	 * @return String
	 */
	@GetMapping("/forgotPwd")
	public String loadForm()
	{
		return "forgotPwd";
	}
	/**
	 * This method is used to handle forgot password screen submit btn
	 * @param email
	 * @param model
	 * @return String
	 */
	@PostMapping("/forgotPwd")
	public String handleForgotPwdSubmitBtn(HttpServletRequest req,Model model)
	{
		String email = req.getParameter("email");
		String status = service.recoverPassword(email);
		if(status.equals("SUCCESS"))
		{
			model.addAttribute("succ", "password sent to your mail");
		}
		else
		{
			model.addAttribute("fail", "please enter valid Email");	
		}
		
		return "forgotPwd";
	}
}
