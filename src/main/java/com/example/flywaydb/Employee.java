package com.example.flywaydb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@Column(name = "emp_Id")
    private int emp_Id;

	@Column(name = "emp_Name")
    private String emp_Name;

	@Column(name = "designation")
    private String designation;

	@Column(name = "contact_Number")
    private String contact_Number;

	@Column(name = "email")
    private String email;
    
	public Employee(int emp_Id, String emp_Name, String designation, String contact_Number, String email) {
		super();
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
		this.designation = designation;
		this.contact_Number = contact_Number;
		this.email = email;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getContact_Number() {
		return contact_Number;
	}
	public void setContact_Number(String contact_Number) {
		this.contact_Number = contact_Number;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
