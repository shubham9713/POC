package com.shubham.service;

import java.util.Map;

import com.shubham.dto.UserAccount;

public interface UserService {

	public String loginCheck(String email, String pwd);

	public Map<Integer, String> loadCountries();

	public Map<Integer, String> loadStatesByCountryId(Integer countryId);

	public Map<Integer, String> loadCitiesByStateId(Integer stateId);

	public boolean isUniqueEmail(String userEmail);

	public String generateTempPwd();

	public boolean saveUserAccount(UserAccount userAcc);
	
	public String getRegSuccMailBody(UserAccount userAcc); 

	public boolean sendRegSuccEmail(String to,String subject,String body);
	
	public boolean isTempPwdValid(String email,String tempPwd);
	
	public boolean unlockAccount(String userEmail,String userpwd);
	
	public String recoverPassword(String email);
	
	public String getRecoverPwdEmailBody(UserAccount userAcc);
	
	public String sendPwdToEmail(String email,String subject,String body);
	
	
	

}
