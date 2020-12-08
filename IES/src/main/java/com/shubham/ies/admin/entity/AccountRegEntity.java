package com.shubham.ies.admin.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "admin_account")
@Entity
public class AccountRegEntity {

	@Id
	@GeneratedValue
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
