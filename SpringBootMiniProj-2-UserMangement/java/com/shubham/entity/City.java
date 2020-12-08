package com.shubham.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Cities_Master")
public class City {

	
	@Id
	@GeneratedValue
	private Integer cityId;
	
	private Integer stateId;
	
	private String cityName;
}
