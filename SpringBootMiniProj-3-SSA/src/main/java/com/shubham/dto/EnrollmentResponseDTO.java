package com.shubham.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnrollmentResponseDTO implements Serializable {

      private String ssn;
	
	private String first_Name;
	
	private String last_Name;
	
	private String gender;
	/*
		@Temporal(TemporalType.DATE)
		private Date dob;
	
		private String state_Name;
	
		@Lob
		private Byte[] photo;*/
}
