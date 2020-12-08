package com.shubham.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.dto.UserAccount;
import com.shubham.entity.City;
import com.shubham.entity.Country;
import com.shubham.entity.State;
import com.shubham.entity.UserAccountEntity;
import com.shubham.repository.CityRepository;
import com.shubham.repository.CountryRepository;
import com.shubham.repository.StateRepository;
import com.shubham.repository.UserRepository;
import com.shubham.util.Emailutils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private Emailutils emailUtils;
	
	@Override
	public String loginCheck(String email, String pwd) {
		
		UserAccountEntity entity = userRepo.findByUserEmailAndUserpwd(email, pwd);
		if(entity==null)
		{
			return "Invalid Credential";
		}
		else if(entity.getAccountStatus().equals("LOCKED"))
		{
			return "Your Account is Locked";
		}
		else
		{
			return "Valid";
		}
	}

	@Override
	public Map<Integer, String> loadCountries() {
		Map<Integer,String> countryMap=new HashMap<>();
		List<Country> entityList = countryRepo.findAll();
		entityList.forEach(entity->{
		countryMap.put(entity.getCountryId(), entity.getCountryName());
		});
		
		return countryMap;
		
		
	}

	@Override
	public Map<Integer, String> loadStatesByCountryId(Integer countryId) {
		Map<Integer,String> stateMap=new HashMap<>();
		List<State> entityList = stateRepo.findByCountryId(countryId);
		entityList.forEach(entity->{
			stateMap.put(entity.getStateId(), entity.getStateName());
			
		});
		return stateMap;
	}

	@Override
	public Map<Integer, String> loadCitiesByStateId(Integer stateId) {
		Map<Integer,String> cityMap=new HashMap<>();
	List<City> entityList = cityRepo.findByStateId(stateId);
	entityList.forEach(entity->{
		cityMap.put(entity.getCityId(), entity.getCityName());
		
	});
		return cityMap;
	}

	@Override
	public boolean isUniqueEmail(String userEmail) {
		
		UserAccountEntity useraccEntity=userRepo.findByUserEmail(userEmail);
		
		return useraccEntity!=null?true:false;
	}

	@Override
	public String generateTempPwd() {
		 // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(8); 
  
        for (int i = 0; i < 8; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
  
  


	@Override
	public boolean saveUserAccount(UserAccount userAcc) {
		
		userAcc.setAccountStatus("LOCKED");
		userAcc.setUserpwd(generateTempPwd());
		
		UserAccountEntity entity=new UserAccountEntity();
		BeanUtils.copyProperties(userAcc, entity);
		
		UserAccountEntity savedEntity = userRepo.save(entity);
		if(savedEntity.getUserId()!=null)
		{
			String to=userAcc.getUserEmail();
			String subject="Registration successfull | IES ";
			String body=getRegSuccMailBody(userAcc);
			
			sendRegSuccEmail(to, subject, body);
			return true;
		}
		return false;
	}

	@Override
	public String getRegSuccMailBody(UserAccount userAcc) {
		String fileName="UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt";
		List<String> replacedLines=null;
		String mailBody=null;
		try {
			
			Path path=Paths.get(fileName,"");
			Stream<String> lines=Files.lines(path);
			replacedLines=lines.map(
					line-> line.replace("{FNAME}", userAcc.getFirstName())
					.replace("{LNAME}", userAcc.getLastName())
					.replace("{TEMP-PWD}", userAcc.getUserpwd())
					.replace("{EMAIL}", userAcc.getUserEmail()))
					.collect(Collectors.toList());
			
		 mailBody = String.join("", replacedLines);
					
		} catch (Exception e) {
			
		}
		return mailBody;
	}

	@Override
	public boolean sendRegSuccEmail(String to, String subject, String body) {
	
		return  emailUtils.sendEmail(to, subject, body);
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		
		return userRepo.findByUserEmailAndUserpwd(email,tempPwd)!=null?true:false;
	}

	@Override
	public boolean unlockAccount(String userEmail, String userpwd) {
		UserAccountEntity entity = userRepo.findByUserEmail(userEmail);
		entity.setAccountStatus("UNLOCKED");
		entity.setUserpwd(userpwd);
		
		return userRepo.save(entity).getUserId()!=null?true:false;
	}

	@Override
	public String recoverPassword(String email) {
		UserAccountEntity entity = userRepo.findByUserEmail(email);
		if(entity!=null)
		{
			UserAccount acc=new UserAccount();
			BeanUtils.copyProperties(entity, acc);
			String body = getRecoverPwdEmailBody(acc);
			String to=acc.getUserEmail();
			String subject="Password Recovery | Ashok IT";
			return sendPwdToEmail(to, subject, body);
			
		}else {
			return "FAIL";
		}
		
	}

	@Override
	public String getRecoverPwdEmailBody(UserAccount userAcc) {
		String fileName="RECOVER-PASSWORD-EMAIL-BODY-TEMPLATE.txt";
		List<String> replacedLines=null;
		String mailBody=null;
		try {
			
			Path path=Paths.get(fileName,"");
			Stream<String> lines=Files.lines(path);
			replacedLines=lines.map(
					line-> line.replace("{FNAME}", userAcc.getFirstName())
					.replace("{LNAME}", userAcc.getLastName())
					.replace("{PWD}", userAcc.getUserpwd()))
					.collect(Collectors.toList());
			
		 mailBody = String.join("", replacedLines);
					
		} catch (Exception e) {
			
		}
		return mailBody;
	}

	@Override
	public String sendPwdToEmail(String to, String subject, String body) {
		boolean isSent = emailUtils.sendEmail(to, subject, body);
		if(isSent)
		{
			return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}
		
	}

}
