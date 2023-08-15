package com.example.spring_boot_student_data.exception;

public class PhoneNotFoundException extends RuntimeException {
	String message;
	
	public String getMessage()
	{
		return message;
	}
	
	public PhoneNotFoundException(String message)
	{
		super();
		this.message = message;
	}
}
