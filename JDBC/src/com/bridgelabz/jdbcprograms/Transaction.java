package com.bridgelabz.jdbcprograms;
import java.sql.*;
import java.util.Random;

import com.bridgelabz.utility.PropertyUtility;

public class Transaction {


	public static String driver = PropertyUtility.getProperty("driver");
	static String url = PropertyUtility.getProperty("URL");
	static String username = PropertyUtility.getProperty("UserName");
	static String password = PropertyUtility.getProperty("Password");
	
	public static void main(String[] args) {
		final String URL=url+"user="+username+"&password="+password;
		
		String qry1="update Account_Records.SBI set Amount=Amount-20000 where Account_No=12345";
		String qry2="update Account_Records.SBI set Amount=Amount+20000 where Account_No=45678";
		Connection con=null;
		
		Random rn=new Random();
		int r=rn.nextInt();
		try {
			Class.forName(driver);
			 con=DriverManager.getConnection(URL);
			Statement stmt=con.createStatement();
			con.setAutoCommit(false); //start
			
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			/*System.out.println("amount debited from virat");
			System.out.println("amount credited to dhoni");
			*/
			con.commit();//end
			
			System.out.println("transaction success");
			System.out.println("transaction id:"+r);
		}
		catch (ClassNotFoundException cnfe) {
			
			cnfe.printStackTrace();
		} catch (SQLException e) {
			try{
				con.rollback();
				System.out.println("transaction fails..");
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}		

	}

}