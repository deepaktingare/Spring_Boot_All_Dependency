package com.example.spring_boot_student_data.exception;

public class IdNotFoundException extends RuntimeException{

	String message;
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
	public IdNotFoundException(String message)
	{
		super();
		this.message = message;   //this keyword call the global variable in local variable
	}
}
