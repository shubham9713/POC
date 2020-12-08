package com.shubham.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.entity.EnrollmentEntity;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Serializable> {

	
}
