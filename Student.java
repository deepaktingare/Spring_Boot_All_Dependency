package com.example.spring_boot_student_data.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name Can't Blank")
	@NotNull(message = "name not null")
	private String name;
	
	@Column(unique = true)
	@NotBlank(message = "Email Can't blank")
	@NotNull(message = "name not null")
	@Email(regexp="[a-z0-9+-$.-]+@[a-z0-9]+\\.[a-z]{2,3}", message="Invalid Email id")
	private String email;
	
	@Column(unique = true)
	@NotBlank(message = "Phone Can't Blank")
	@Min(value = 6000000000l)
	@Max(value = 9999999999l) //last is L
	private long phone;

	@Max(value = 100)
	private double perct;
	
	private char grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public double getPerct() {
		return perct;
	}

	public void setPerct(double perct) {
		this.perct = perct;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", perct=" + perct
				+ ", grade=" + grade + "]";
	}
	
}
