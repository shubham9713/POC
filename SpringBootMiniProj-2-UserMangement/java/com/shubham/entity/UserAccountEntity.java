package com.shubham.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="User_Account")
public class UserAccountEntity {

	@Id
	@GeneratedValue
	private Integer userId;
	private String accountStatus;
	private Integer cityId;
	private Integer countryId;
	@CreationTimestamp
	private Date createdDate;
	private String dob;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer stateId;
	@UpdateTimestamp
	private Date updatedDate;
	private String userEmail;
	private String userpwd;
	private String userMobile;

}
