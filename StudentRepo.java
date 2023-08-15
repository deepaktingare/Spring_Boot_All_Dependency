package com.example.spring_boot_student_data.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.spring_boot_student_data.dto.Student;
import com.example.spring_boot_student_data.util.ResponseStructure;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	@Query("SELECT s FROM Student s WHERE s.phone=?1")
	Student findByPhone(long phone);
//	
	@Query("SELECT s FROM Student s WHERE s.email=?1")
	Student findByEmail(String email);
//	
	@Query("SELECT s FROM Student s WHERE s.name=?1")
	Student findByName(String name);
//	
	@Query("SELECT s FROM Student s WHERE s.perct>=?1")
	List<Student> findStudentByPerctGreaterThan(double perct);
//	
	@Query("SELECT s FROM Student s WHERE s.perct<=?4")
	List<Student> findStudentByPerctLessThan(double perct);
}
