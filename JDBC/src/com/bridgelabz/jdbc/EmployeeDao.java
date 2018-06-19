package com.bridgelabz.jdbc;
/******************************************************************************
 *  
 *  Purpose:  Employee DataAccessObject estabishes the connection with database
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   19-06-2018
 *
 ******************************************************************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bridgelabz.utility.PropertyUtility;
import com.mysql.jdbc.ResultSet;


public class EmployeeDao
{

public static String driver = PropertyUtility.getProperty("driver");
static String url = PropertyUtility.getProperty("URL");
static String username = PropertyUtility.getProperty("UserName");
static String password = PropertyUtility.getProperty("Password");
public static Connection connection = null;

public static void getConnection() 
{
	
try {
	Class.forName(EmployeeDao.driver);
	
	connection = DriverManager.getConnection(url+"user="+username+"&password="+password);
	
}
catch(Exception e)
{
	e.printStackTrace();
}

}

}
