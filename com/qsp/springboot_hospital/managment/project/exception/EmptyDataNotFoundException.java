package com.qsp.springboot_hospital.managment.project.exception;

public class EmptyDataNotFoundException extends RuntimeException {
	String message;

	@Override
	public String getMessage() {

		return message;
	}

	public EmptyDataNotFoundException(String message) {
		super();
		this.message = message;
	}

}
