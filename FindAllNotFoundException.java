package com.example.spring_boot_student_data.exception;

public class FindAllNotFoundException extends RuntimeException {
	String message;
	
	public String getMessage()
	{
		return message;
	}
	
	public FindAllNotFoundException(String message)
	{
		super();
		this.message = message;
	}
}
