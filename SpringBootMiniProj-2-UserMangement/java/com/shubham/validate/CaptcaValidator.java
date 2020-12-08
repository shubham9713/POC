package com.shubham.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shubham.util.CaptchaResponse;

@Component
public class CaptcaValidator {

	@Autowired
	private RestTemplate rt;
	
	public boolean isValid(String captcha)
	{
		String url="https://www.google.com/recaptcha/api/siteverify";
		String params="?secret=6Lfr89kZAAAAAPY6apPrZ2rKXyYf0VZUAFb6OEEP"+"&response="+captcha;
		
		
		CaptchaResponse resp = rt.postForObject(url+params,null, CaptchaResponse.class);
		
		return resp.isSuccess();
	}
}
