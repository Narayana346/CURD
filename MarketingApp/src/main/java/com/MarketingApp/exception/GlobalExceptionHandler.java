package com.MarketingApp.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.MarketingApp.dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoubdException(ResourceNotFoundException exception, WebRequest webRequest){
	
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalException(
			Exception e,
			WebRequest webRequest
		){
		
		ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.OK);
			}
	
	

}