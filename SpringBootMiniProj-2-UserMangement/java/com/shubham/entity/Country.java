package com.shubham.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Country_Master")
public class Country {	

	@Id
	@GeneratedValue

	private Integer countryId;
	
	
	private String countryCode;
	
	
	private String countryName;
}
