package com.qsp.springboot_hospital.managment.project.exception;

public class IdNotFoundException extends RuntimeException {

	String message;

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

}
