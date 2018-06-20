package com.bridgelabz.serviceimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.jdbc.EmployeeDao;
import com.bridgelabz.service.UserService;
import com.bridgelabz.utility.Utility;

public class UserServiceImplementation implements UserService {
	static String query = "insert into Emp_Records.EMPLOYEE values(?,?,?,?,?,?)";
	static String queryToLogin = "select * from Emp_Records.EMPLOYEE where email_id=? and DOB=?";
	
	@Override
	public void login(String emailId, String password) throws SQLException 
	{

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
		EmployeeDao.getConnection();
		System.out.println(java.sql.Date.valueOf(password));
		pstmt = EmployeeDao.connection.prepareStatement(queryToLogin);
		pstmt.setString(1, emailId);
		pstmt.setDate(2,java.sql.Date.valueOf(password) );
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			String user = rs.getString(1);
			System.out.println("Hello "+user);
		}
		else
		{
			System.out.println("invalid user.."); 
			System.out.println("Enter emailid");
			String mailid = Utility.readString();
			register(mailid);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(rs!= null)
			{
				try
				{
				rs.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			if(pstmt!= null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				
			}
			EmployeeDao.connection.close();
		}
	}

	@Override
	public void register(String emailId) throws SQLException 
	{
		System.out.println("Enter your name");
		String name = Utility.readString();
		System.out.println("Enter your employee id");
		int id = Utility.readInteger();
		System.out.println("Enter your Salary");
		float salary = Utility.readFloat();
		System.out.println("Enter your designation");
		String desgn = Utility.readString();
		System.out.println("Enter your dateOfBirth as password");
		String password = Utility.readString();
		PreparedStatement pstmt = null;
		try {
		EmployeeDao.getConnection();
		 pstmt = EmployeeDao.connection.prepareStatement(query);
		
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		pstmt.setDouble(3, salary);
		pstmt.setString(4, desgn);
		pstmt.setDate(5, java.sql.Date.valueOf(password));
		pstmt.setString(6, emailId);
		pstmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
			if(pstmt!= null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				
			}
			EmployeeDao.connection.close();
		}
		
	}

}
