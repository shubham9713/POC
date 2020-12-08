package com.shubham.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.dto.EnrollmentRequestDTO;
import com.shubham.dto.EnrollmentResponseDTO;
import com.shubham.entity.EnrollmentEntity;
import com.shubham.exception.DataNotFoundException;
import com.shubham.repository.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	private EnrollmentRepository repo;
	
	@Override
	public String ssnEnrollment(EnrollmentRequestDTO dto) {
		EnrollmentEntity entity = new EnrollmentEntity();
		
		BeanUtils.copyProperties(dto, entity);
		
		return repo.save(entity).getSsn();
	}

	@Override
	public EnrollmentResponseDTO getCitizenByssn(String ssn) {
		EnrollmentEntity entity=new EnrollmentEntity();
		
		EnrollmentResponseDTO dto=null;
		entity = repo.findById(ssn)
				 .orElseThrow(()-> new DataNotFoundException(
							new StringBuffer()
							.append("Citizen '")
							.append(ssn)
							.append("' not exist")
							.toString())
							);
		dto=new EnrollmentResponseDTO();
		 BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}

	
}
