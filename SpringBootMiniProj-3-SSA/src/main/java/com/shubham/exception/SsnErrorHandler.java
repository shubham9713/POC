package com.shubham.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shubham.dto.ErrorType;

@RestControllerAdvice
public class SsnErrorHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorType> notFound(DataNotFoundException dne)
	{
		return new ResponseEntity<ErrorType>(
				new ErrorType(
						new Date(System.currentTimeMillis()).toString(),
						"404", 
						dne.getMessage()),
				HttpStatus.NOT_FOUND);
	}
}
