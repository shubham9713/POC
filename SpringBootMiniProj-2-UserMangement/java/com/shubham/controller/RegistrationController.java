package com.shubham.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shubham.dto.UserAccount;
import com.shubham.props.AppProperties;
import com.shubham.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService service;
	
	@Autowired
	private AppProperties appProps;
	
	@GetMapping("/register")
	public String loadRegForm(Model model)
	{
		
		model.addAttribute("userAcc", new UserAccount());
		model.addAttribute("countries", service.loadCountries());
		return "Registration";
		//return "reg";
	}
	
	@GetMapping("/uniqueMailCheck")
	public @ResponseBody String isEmailUnique(@RequestParam String userEmail)
	{
		
		/*boolean isUnique = service.isUniqueEmail(userEmail);
		return isUnique?"unique":"duplicate";*/
		return service.isUniqueEmail(userEmail)?"duplicate":"unique";
	}
	
	@GetMapping("/countryChange")
	public @ResponseBody Map<Integer,String> handleCountryChangeEvent(@RequestParam Integer countryId)
	{
		return  service.loadStatesByCountryId(countryId);
	}
	
	@GetMapping("/stateChange")
	public @ResponseBody Map<Integer,String> handleStateChangeEvent(@RequestParam Integer stateId)
	{
		return  service.loadCitiesByStateId(stateId);
	}
	
	@PostMapping("/userRegistration")
	public String handleRegisterBtn(@ModelAttribute UserAccount userAcc,RedirectAttributes model)
	{
		boolean saveUserAccount = service.saveUserAccount(userAcc);
		if(saveUserAccount) {
			String regSucc= appProps.getMessage().get("succMsg");
		
			model.addFlashAttribute("succ", regSucc);
		}
		else {
			
			String regFail= appProps.getMessage().get("fail");
			model.addFlashAttribute("fail", regFail);
		}
    	return "redirect:register";
		//return "reg";
	}
}
