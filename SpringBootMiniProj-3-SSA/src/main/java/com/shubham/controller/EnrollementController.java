package com.shubham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.dto.EnrollmentRequestDTO;
import com.shubham.service.EnrollmentService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EnrollementController {

	@Autowired
	private EnrollmentService service;
	
	
	@ApiOperation("enroll for SSN")
	@PostMapping("/enroll")
	public ResponseEntity<String> ssnEnrollment(@RequestBody EnrollmentRequestDTO dto)
	{
		ResponseEntity<String> resp=null;
		
		try {
			
			String ssn=service.ssnEnrollment(dto);
			String SSN=formatedSSN(ssn);
			resp=new ResponseEntity<String>(
					"Your '"+SSN+"' created",
					HttpStatus.CREATED);//201 -created
		}catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(
					"Unable to enroll SSN",
					HttpStatus.INTERNAL_SERVER_ERROR);//500 -ISE
		}
		
		return resp;
	}
	public String formatedSSN(String ssn)
	{
		String input=String.valueOf(ssn);
		String number = input.replaceFirst("(\\d{3})(\\d{2})(\\d{4})", "$1-$2-$3");
		 
		return number;
	}
}
