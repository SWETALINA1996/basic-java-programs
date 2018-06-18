package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


import com.bridgelabz.utility.PropertyUtility;
import com.mysql.jdbc.PreparedStatement;



public class EmployeeDao
{
static String query = "insert into Emp_Records.EMPLOYEE values(?,?,?,?,?,?)";
static String driver = PropertyUtility.getProperty("driver");
static String url = PropertyUtility.getProperty("URL");
static String username = PropertyUtility.getProperty("UserName");
static String password = PropertyUtility.getProperty("Password");

/*
if (driver != null) {
    Class.forName(driver) ;
}*/
public static void connection() 
{
	
try {
	Class.forName(EmployeeDao.driver);
	
	Connection connection = DriverManager.getConnection(url+"user="+username+"&passowrd="+password);
	PreparedStatement pstmt = connection.createStatement();
	pstmt.execute(query);
	System.out.println("operation succesfull");
	
	//System.out.println("Connction established");
}
catch(Exception e)
{
	e.printStackTrace();
}

}

}
