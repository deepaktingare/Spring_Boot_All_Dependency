package com.example.spring_boot_student_data.exception;

public class EmailNotFoundException extends RuntimeException{

	String message;
	
	public String getMessage()
	{
		return message;
	}
	
	public EmailNotFoundException(String message)
	{
		super();
		this.message = message;
	}
}
