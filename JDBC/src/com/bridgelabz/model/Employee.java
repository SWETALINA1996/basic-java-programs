package com.bridgelabz.model;

import java.util.Date;

public class Employee 
{
String emp_name;
int emp_id;
float emp_salary;
String emp_designation;
Date dateOfBirth;
String emailId;
String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getEmp_name() {
	return emp_name;
}
public void setEmp_name(String emp_name) {
	this.emp_name = emp_name;
}
public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public float getEmp_salary() {
	return emp_salary;
}
public void setEmp_salary(float emp_salary) {
	this.emp_salary = emp_salary;
}
public String getEmp_designation() {
	return emp_designation;
}
public void setEmp_designation(String emp_designation) {
	this.emp_designation = emp_designation;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

}
