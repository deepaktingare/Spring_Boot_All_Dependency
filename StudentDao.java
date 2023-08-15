package com.example.spring_boot_student_data.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_student_data.Repo.StudentRepo;
import com.example.spring_boot_student_data.dto.Student;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;
	
	public Student saveStudent(Student student) /*-------------------------------------------- SAVE ----------------------------------------*/
	{
		return repo.save(student);
	}

	public Student findById(int id) /*-------------------------------------------- FIND BY ID ----------------------------------------*/
	{	
		Optional<Student> optional = repo.findById(id);
		
		try {
			return optional.get();
		} catch (Exception e) {
			System.out.println("Invalid Id");
			return null;
		}	
	}
	
    public Student findByPhone(long phone) /*-------------------------------------------- FIND BY PHONE ----------------------------------------*/
    {
		return repo.findByPhone(phone);
	}

	public Student findByEmail(String email) { /*-------------------------------------------- FIND BY EMAIL ----------------------------------------*/
		return repo.findByEmail(email);
	}

	public List<Student> findAll() { /*-------------------------------------------- FIND ALL ----------------------------------------*/
		return repo.findAll();
	}

	public Student delete(int id) /*-------------------------------------------- DELETE ----------------------------------------*/ 
	{
		Optional<Student> optional = repo.findById(id);

		if (optional.isEmpty()) {
			return null;
		}
		else {
			Student student = optional.get();
			repo.deleteById(id);
			
			return student;
		}
	}

    public Student update(int id, Student student) { /*-------------------------------------------- UPDATE ----------------------------------------*/
		
		Optional<Student> optional = repo.findById(id);
		
		if (optional.isPresent()) {
			student.setId(id);
			return repo.save(student);
		} 
	  else {
		  return null;
		}
	}

	public Student updatePhone(int id, Student student) /*-------------------------------------------- UPDATE PHONE NUMBER ----------------------------------------*/
	{
		return repo.save(student);
	}
	
	public Student updateEmail(int id, Student student) /*-------------------------------------------- UPDATE EMAIL ID ----------------------------------------*/
	{
		return repo.save(student);
	}
	
	public Student updateName(int id, Student student) /*-------------------------------------------- UPDATE NAME ----------------------------------------*/
	{
		return repo.save(student);
	}

}
