package com.shubham.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.shubham.service.UserService;
import com.shubham.util.CaptchaResponse;
import com.shubham.validate.CaptcaValidator;

@Controller
public class LoginController {

	@Autowired
	private UserService service;
	
	@Autowired
	private CaptcaValidator validator;
	
	/**
	 * This method is used to load login page
	 * @return String
	 */
	
	@GetMapping(value={"/","index"})
	public String index()
	{
		
		return "index";
	}
	
	/**
	 * This method is used to handle login functionality
	 * @param req
	 * @param model
	 * @return String
	 */
	@PostMapping("/login")
	public String handleSignInBtn(HttpServletRequest req, Model model,
			@RequestParam("g-recaptcha-response") String captcha)
	{
		
		String viewName="";
		if(validator.isValid(captcha))
		{
		
		String email=req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		String status=service.loginCheck(email, pwd);
		if(status.equals("Valid"))
		{
			viewName="dashboard";
		}
		else {
			viewName="index";
			model.addAttribute("fail", status);
		}
		}
		else
		{
			viewName="index";
			model.addAttribute("fail", "please validate captcha");
		}
		return viewName;
	}
}
