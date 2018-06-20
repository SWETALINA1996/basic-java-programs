package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.bridgelabz.serviceimplementation.UserServiceImplementation;
import com.bridgelabz.utility.PropertyUtility;

public class EmployeeDao {
	public static String driver = PropertyUtility.getProperty("driver");
	static String url = PropertyUtility.getProperty("URL");
	static String username = PropertyUtility.getProperty("UserName");
	static String password = PropertyUtility.getProperty("Password");
	public static Connection connection = null;
	UserServiceImplementation user = new UserServiceImplementation();

	public static void getConnection() 
	{
		
	try {
		Class.forName(EmployeeDao.driver);
		
		connection = DriverManager.getConnection(url+"user="+username+"&password="+password);
		//username.login()
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	}
	
}
