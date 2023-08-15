package com.example.spring_boot_student_data.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.spring_boot_student_data.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	ResponseStructure<String> responseStructure = new ResponseStructure<>();

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException exception) {
		responseStructure.setMessage("Id Not Found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFoundExceptionHandler(EmailNotFoundException exception) {
		responseStructure.setMessage("Email Not Found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PhoneNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> phoneNotFoundExceptionHandler(PhoneNotFoundException exception)
	{
		responseStructure.setMessage("Phone Number Invalid..!");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FindAllNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> FindAllNotFoundException(FindAllNotFoundException exception)
	{
		responseStructure.setMessage("No data vailable");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> error = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();
		
		for(ObjectError objectError : error)
		{
			FieldError fe = (FieldError) objectError;
			String fieldName = fe.getField();
			String message = fe.getDefaultMessage();
			map.put(fieldName, message);
		}
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
