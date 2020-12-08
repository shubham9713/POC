package com.shubham.ies.admin.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data

public class AccountReg {

	private Integer acc_No;
	private String firstName;
	private String lastName;
	private String email;
	private String pwd;
	private Date dob;
	private String gender;
	private Long ssnNo;
	private String phoneNumber;
	private String role;
	 
}
