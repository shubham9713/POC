package com.shubham.dto;

import java.util.Date;

import lombok.Data;

@Data

public class UserAccount {

	
	
	private Integer userId;
	private String accountStatus;
	private Integer cityId;
	private Integer countryId;

	private Date createdDate;
	private String dob;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer stateId;

	private Date updatedDate;
	private String userEmail;
	private String userpwd;
	private String userMobile;

}
