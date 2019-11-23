package com.payroll.microservices.employeeservice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Id
	@Column(name="emp_id")
	private Long empId;
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	
	private int port;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Employee(String firstName, String lastName, Long empId, Date dateOfJoining) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
		this.dateOfJoining = dateOfJoining;
	}
	
	public Employee(){
		
	}

}
