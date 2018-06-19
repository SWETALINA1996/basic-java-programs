package com.bridgelabz.controller;
/******************************************************************************
 *  
 *  Purpose:  User Service Implementation provides access to login and register
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   19-06-2018
 *
 ******************************************************************************/

import java.sql.SQLException;
import java.text.ParseException;


import com.bridgelabz.serviceimplementation.UserServiceImplementation;
import com.bridgelabz.utility.Utility;

public class Manager
{
	static UserServiceImplementation userimplementation = new UserServiceImplementation();
public static void main(String[] args) throws ParseException, SQLException
{
	System.out.println("WELCOME");
	System.out.println("Press 1 to Login and 2 to Register");
	int choice = Utility.readInteger();
	switch(choice)
	{
	case 1:
		System.out.println("Enter your emailid");
		String emailId = Utility.readString();
		System.out.println("Enter your dateOfBirth(yyyy-mm-dd) for password");
		String password = Utility.readString();
		userimplementation.login(emailId, password);
		System.out.println("Successfully LoggedIn....");
		break;
	case 2 : 
		System.out.println("Enter your emailid");
		String email = Utility.readString();
		userimplementation.register(email);
		System.out.println("Registered....");
		break;
	}
}
}
