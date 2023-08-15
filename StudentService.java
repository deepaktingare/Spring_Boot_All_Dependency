package com.example.spring_boot_student_data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.spring_boot_student_data.dao.StudentDao;
import com.example.spring_boot_student_data.dto.Student;
import com.example.spring_boot_student_data.exception.EmailNotFoundException;
import com.example.spring_boot_student_data.exception.FindAllNotFoundException;
import com.example.spring_boot_student_data.exception.IdNotFoundException;
import com.example.spring_boot_student_data.exception.PhoneNotFoundException;
import com.example.spring_boot_student_data.util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	
	ResponseStructure<Student> responseStructure = new ResponseStructure<>();
	ResponseStructure<List<Student>> responseStructure_list = new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) { /*-------------------------------------------- SAVE ---------------------------------------*/
		double perct = student.getPerct();
		  
		if (perct < 35 ) 
		{
			student.setGrade('F');
		} 
	 else if(perct >=35 && perct <= 45)
	     {
		    student.setGrade('P');
		 }
	 else if(perct > 45 && perct <= 60)
	    {
		    student.setGrade('C');
	    }
	 else if(perct > 60 && perct <= 85)
	    {
		    student.setGrade('B');
     	}
	 else 
	    {
		   student.setGrade('A');
	    }
		responseStructure.setMessage("Save Succsesfuly");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveStudent(student));
		
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> findById(int id) { /*-------------------------------------------------- FIND BY ID -------------------------------------------*/
		Student dbstudent = dao.findById(id);
	
		if (dbstudent != null) {
			
			responseStructure.setMessage("Found Succsesfuly");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.findById(id));
			
			return new ResponseEntity<>(responseStructure,HttpStatus.FOUND);
		} 
		else {
			throw new IdNotFoundException("Invalid Id");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findByPhone(long phone) { /*---------------------------------------------- FIND BY PHONE -----------------------------------------*/
		
        Student dbstudent = dao.findByPhone(phone);
		
        if (dbstudent != null) {
			
			responseStructure.setMessage("Found Succsesfuly");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.findByPhone(phone));
			
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		} 
        else {
			throw new PhoneNotFoundException("Invalide Phone Number");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findByEmail(String email) { /*--------------------------------------------- FIND BY EMAIL -----------------------------------------*/
		
		Student dbstudent = dao.findByEmail(email);
		
        if (dbstudent != null) {
			
			responseStructure.setMessage("Found Succsesfuly");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.findByEmail(email));
			
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		} 
        else {
        	throw new EmailNotFoundException("Email Invalid");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findAll(Student student) //----------------------------------------------- FIND ALL -------------------------------------
	{
		List<Student> student_list = dao.findAll();
		
		if (student_list.isEmpty()) {
			responseStructure_list.setMessage("NOT FOUNd ");
			responseStructure_list.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure_list.setData(null);
			
			return new ResponseEntity<>(responseStructure_list, HttpStatus.FOUND);
		} 
		else {
			 throw new FindAllNotFoundException("No Data Available");
		}
				
	}
	public ResponseEntity<ResponseStructure<Student>> update(int id, Student student) { /*------------------------------------- UPDATE ----------------------------------------*/
		
		Student dbstudent = dao.findById(id);
		
		if (dbstudent != null) {
			
			responseStructure.setMessage("Found Succsesfuly");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.update(id, student));
			
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		} 
		else {
			throw new IdNotFoundException("Id Invalide");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updatePhone(int id, long phone) { /*------------------------------------------------ UPDATE PHONE ---------------------------------------------*/
        Student dbstudent = dao.findById(id);
        
        if (dbstudent != null) {
			responseStructure.setMessage("Found Succsesful");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.updatePhone(id, dbstudent));
			
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		} 
        else {
			throw new IdNotFoundException("Invalid Id");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updateEmail(int id ,String email) { /*-------------------------------------------------- UPDATE EMAIL -------------------------------------------*/
		
		Student student = dao.findById(id);
		if (student != null) {
			responseStructure.setMessage("Found Succsesfuly");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.updateEmail(id, student));
			
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		} 
		else {
			throw new IdNotFoundException("Invalid Id");
		}
		
	}

	public ResponseEntity<ResponseStructure<Student>> updateName(int id, String name) { /*----------------------------------------------------------- UPDATE NAME ---------------------------------------*/

        Student student = dao.findById(id);
		if (student != null) {
			responseStructure.setMessage("Found Succsesfuly");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.updateName(id, student));
			
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Invalid Id");
		}
	}

    public ResponseEntity<ResponseStructure<Student>> delete(int id) { //------------------------------------------------- DELETE -----------------------------------------
       Student dbstudent = dao.findById(id);
        
        if (dbstudent != null) {
			responseStructure.setMessage("Found Succsesful");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.delete(id));
			
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		} 
        else {
			throw new IdNotFoundException("Invalid Id");
		}
	}
}
