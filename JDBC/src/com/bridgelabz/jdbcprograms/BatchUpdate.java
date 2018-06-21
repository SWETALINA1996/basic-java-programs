package com.bridgelabz.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.bridgelabz.utility.PropertyUtility;


public class BatchUpdate
{
	public static String driver = PropertyUtility.getProperty("driver");
	static String url = PropertyUtility.getProperty("URL");
	static String username = PropertyUtility.getProperty("UserName");
	static String password = PropertyUtility.getProperty("Password");
	
	public static void main(String[] args) 
	{
		final String URL=url+"user="+username+"&password="+password;
		String query1 ="delete from Account_Records.SBI where Account_No =  159123";
		String query2 = "insert into Account_Records.SBI11 values('Sameer' , 852369 , 200000)";
		String query3 = " delete from Account_Records.SBI where Amount > ?";
		//String query4 = "create table Emp_Records.studentpract(name varchar(30) , age int(2) , std_id int(3))";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL);
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement(query3);
			
			
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			//stmt.addBatch(query4);
			pstmt.setInt(1, 100000);
			pstmt.addBatch();
			
			int[] records1=stmt.executeBatch();
			int[] records = pstmt.executeBatch();
			System.out.println(records1[0] +"deleted");
			System.out.println(records1[1]+ "inserted");
			//System.out.println(records1[2]+"created");
			System.out.println(records[0]+ " deleted by amount");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
