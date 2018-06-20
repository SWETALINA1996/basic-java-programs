package com.bridgelabz.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.bridgelabz.utility.PropertyUtility;
import com.bridgelabz.utility.Utility;

public class StatementDemo {

	public static String driver = PropertyUtility.getProperty("driver");
	static String url = PropertyUtility.getProperty("URL");
	static String username = PropertyUtility.getProperty("UserName");
	static String password = PropertyUtility.getProperty("Password");
	

	public static void main(String[] args) {
	/*	final String URL="jdbc:mysql://localhost:3306?user=root&password=sweta";
		Scanner sc=new Scanner(System.in);*/
		final String URL=url+"user="+username+"&password="+password;
		
		System.out.println("enter account number");
		int account=Utility.readInteger();
		
		System.out.println("enter amount");
		int amount=Utility.readInteger();
		
		String qry="UPDATE Account_Records.SBI set Amount="+amount+" WHERE Account_No="+account;
		
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(URL);
			
			Statement stmt=con.createStatement();
			int n=stmt.executeUpdate(qry);
			System.out.println(n+"record inserted");
			stmt.close();
			con.close();
			System.out.println("data operation success");
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}



		
		



	}

}