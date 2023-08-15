package com.example.spring_boot_student_data.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_student_data.dto.Student;
import com.example.spring_boot_student_data.service.StudentService;
import com.example.spring_boot_student_data.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class Controller {
	
	@Autowired
	private StudentService service;
	
	@ApiOperation(value = "Save Student", notes = "This api used to save the student data into database")//for swagger document ad 2 dependency swagger2 springfox and swagger2 ui springfrox
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Saved Employee")})
	@PostMapping("/saveData")
	public ResponseEntity<ResponseStructure<Student>> saveStudentStudent(@Valid @RequestBody Student student)
	{
		return service.saveStudent(student);
	}
	
	@ApiOperation(value = "Find Student", notes = "This api used to find the student data into database based on primary key")
	@ApiResponses(value = {@ApiResponse(code = 302, message = "Find Student"), @ApiResponse(code = 404, message = "Not Find Student")})
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Student>> findStudentById(@RequestParam int id)
	{
		return service.findById(id);
	}
	
	@ApiOperation(value = "Find Student BY Email", notes = "This api used to find the student data into database based on Email id")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Find Student by Email")})
	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Student>> findByEmail(@RequestParam String email)
	{
		return service.findByEmail(email);
	}
	
	@ApiOperation(value = "Find Student BY Phone", notes = "This api used to find the student data into database based on Phone")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Find Student by Phone")})
	@GetMapping("/findByPhone")
	public ResponseEntity<ResponseStructure<Student>> findByPhone(@RequestParam long phone)
	{
		return service.findByPhone(phone);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Student>>> findAll(Student student)
	{
		return service.findAll(student);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id ,@RequestBody Student student)
	{
		return service.update(id, student);
	}
	
	@PatchMapping("/updatePhone")
	public ResponseEntity<ResponseStructure<Student>> updatePhone(@RequestParam int id, @RequestBody long phone)
	{
		return service.updatePhone(id, phone);
	}
	
	@PatchMapping("/updateEmail")
	public ResponseEntity<ResponseStructure<Student>> updatePhone(@RequestParam int id, @RequestBody String email)
	{
		return service.updateEmail(id, email);
	}
	
	@PatchMapping("/updateName")
	public ResponseEntity<ResponseStructure<Student>> updateName(@RequestParam int id, @RequestBody String name)
	{
		return service.updateName(id, name);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestParam int id)
	{
		return service.delete(id);
	}
}
