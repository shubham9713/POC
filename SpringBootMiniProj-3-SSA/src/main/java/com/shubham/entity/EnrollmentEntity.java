package com.shubham.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "SSN_Enrollment")
public class EnrollmentEntity {

	@Id
	@GenericGenerator(
			name="ssn_no_gen",
			strategy ="com.shubham.generator.SSNGenerator"
			)
	@GeneratedValue(generator = "ssn_no_gen")
	private String ssn;
	
	private String first_Name;
	
	private String last_Name;
	
	private String gender;
	
	/*@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String state_Name;
	
	@Lob
	private Byte[] photo;*/
}
