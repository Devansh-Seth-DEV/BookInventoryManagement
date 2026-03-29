package com.bookinventory.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionResponse {
	private int status;
    private String message;

    @JsonFormat(
    	shape = JsonFormat.Shape.STRING,
    	pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime timestamp;
    
    public ExceptionResponse() {
    	this.timestamp = LocalDateTime.now();
    }
    
	public ExceptionResponse(int status, String message) {
		this();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
