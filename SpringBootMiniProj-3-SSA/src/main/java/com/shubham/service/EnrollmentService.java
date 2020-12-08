package com.shubham.service;

import com.shubham.dto.EnrollmentRequestDTO;
import com.shubham.dto.EnrollmentResponseDTO;

public interface EnrollmentService {


	
	public String ssnEnrollment(EnrollmentRequestDTO dto);
	public EnrollmentResponseDTO getCitizenByssn(String ssn);
}
