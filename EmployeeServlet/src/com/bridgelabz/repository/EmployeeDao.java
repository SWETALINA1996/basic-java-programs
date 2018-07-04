package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgelabz.utility.PropertyUtility;

public class EmployeeDao 
{
	public static String driver = PropertyUtility.getProperty("driver");
	static String url = PropertyUtility.getProperty("URL");
	static String username = PropertyUtility.getProperty("UserName");
	static String password = PropertyUtility.getProperty("Password");
	public static Connection connection = null;
	//UserServiceImplementation user = new UserServiceImplementation();

	public static Connection getConnection() 
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
	return connection;

	}
	
	public static boolean validate(String name,String pass)
	{  
		boolean status=false;  
		try
		{  
		Connection con = EmployeeDao.getConnection();
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from Servlet.user_servlet where emailid=? and password=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
		System.out.println(status);
		return status;  
		}  
	
	
}
