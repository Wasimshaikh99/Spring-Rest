package com.wasim.customerdemo.config.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	public ResponseEntity<CustomerError> exceptionHandler(Exception exc){
		
		CustomerError error= new CustomerError(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
}
