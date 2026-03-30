package com.bookinventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNotFound(ResourceNotFoundException e) {
		ExceptionResponse exception = new ExceptionResponse(
					HttpStatus.NOT_FOUND.value(),
					e.getMessage()
				);
		
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
}
