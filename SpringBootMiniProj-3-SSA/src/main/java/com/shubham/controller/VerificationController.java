package com.shubham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.dto.EnrollmentResponseDTO;
import com.shubham.exception.DataNotFoundException;
import com.shubham.service.EnrollmentService;

import io.swagger.annotations.ApiOperation;

@RestController
public class VerificationController {

	@Autowired
	private EnrollmentService service;
	
	
	@ApiOperation("SSN Verification")
	@GetMapping("/verify/{ssn}")
	public ResponseEntity<?> getCitizenSSN(@PathVariable String ssn)
	{
		ResponseEntity<?> resp=null;
		try {
			EnrollmentResponseDTO citizenByssn = service.getCitizenByssn(ssn);
			
					new ResponseEntity<EnrollmentResponseDTO>(
							citizenByssn, 
							HttpStatus.OK);
			}
			catch (DataNotFoundException dne) {
				throw dne;   // re throw exception
			}
			catch (Exception e) {
				e.printStackTrace();
				resp=new ResponseEntity<String>(
						"Unable to find SSN",
						HttpStatus.INTERNAL_SERVER_ERROR);//500 -ISE
			}
		
		return resp;
	}
	
}
