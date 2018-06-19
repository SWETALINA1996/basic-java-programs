package com.bridgelabz.jdbcprograms;
/******************************************************************************
 *  
 *  Purpose:  insertion of records into database using Prepared Statement
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

public class PreparedDemo
{
	public static String driver = PropertyUtility.getProperty("driver");
	static String url = PropertyUtility.getProperty("URL");
	static String username = PropertyUtility.getProperty("UserName");
	static String password = PropertyUtility.getProperty("Password");
	
		public static void main(String[] args) {
			//final String URL="jdbc:mysql://localhost:3306?user=root&password=root";
			

			String qry="insert into Emp_Records.EMPLOYEE(Emp_Name,Emp_id,Emp_Salary,Emp_Designation,DOB,email_id) values(?,?,?,?,?,?)";
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url+"user="+username+"&password="+password);
				PreparedStatement pstmt=con.prepareStatement(qry);
				
				/*set and execute*/
				pstmt.setString(1, "Saurav");
				pstmt.setInt(2, 129);
				pstmt.setDouble(3, 40000);
				pstmt.setString(4, "Software Engineer");
				pstmt.setDate(5, java.sql.Date.valueOf("1995-10-05"));
				pstmt.setString(6, "saurav.manchanda@gmail.com");
				pstmt.execute();
				
				pstmt.close();
				con.close();
				System.out.println("data insertion success");
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}		


		}

}
