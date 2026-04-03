package com.bookinventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
     * Handles cases where a requested entity (Book, User, Inventory) does not exist.
     * @param e ResourceNotFoundException containing the error message.
     * @return ResponseEntity with 404 Not Found status and exception details.
     */	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNotFound(ResourceNotFoundException e) {
		ExceptionResponse exception = new ExceptionResponse(
					HttpStatus.NOT_FOUND.value(),
					e.getMessage()
				);
		
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
	/**
     * Handles data integrity violations, such as duplicate ISBNs or usernames.
     * @param e DuplicateResourceException containing the conflict details.
     * @return ResponseEntity with 409 Conflict status and exception details.
     */
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ExceptionResponse> handleConflict(DuplicateResourceException e) {
		ExceptionResponse exception = new ExceptionResponse(
					HttpStatus.CONFLICT.value(),
					e.getMessage()
				);
		
		return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
	}
	
	/**
     * Handles authentication failures and unauthorized access attempts.
     * @param e UnauthorizedException containing the security violation details.
     * @return ResponseEntity with 401 Unauthorized status and exception details.
     */
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ExceptionResponse> handleUnauthorized(UnauthorizedException e) {
		ExceptionResponse exception = new ExceptionResponse(
					HttpStatus.UNAUTHORIZED.value(),
					e.getMessage()
				);
		
		return new ResponseEntity<>(exception, HttpStatus.UNAUTHORIZED);
	}

	/**
     * Provides a generic fallback for internal logic errors and unhandled runtime issues.
     * @param e RuntimeException representing the internal system error.
     * @return ResponseEntity with 400 Bad Request status and exception details.
     */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> handleBadRequest(RuntimeException e) {
		ExceptionResponse exception = new ExceptionResponse(
					HttpStatus.BAD_REQUEST.value(),
					e.getMessage()
				);
		
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
}
