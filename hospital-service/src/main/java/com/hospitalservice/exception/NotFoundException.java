package com.hospitalservice.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1626763543582081387L;

	public NotFoundException(String message) {
        super(message);
    }
}
