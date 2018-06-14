package com.bridgelabz.objectoriented;

/******************************************************************************
 *  
 *  Purpose: Use Regex to replace name, full name, Mobile#, and Date with proper value and Print 
 *  		the modified message
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   31-05-2018
 *
 ******************************************************************************/

import com.bridgelabz.utility.Utility;


public class RegularExpression {
	
	 static String MESSAGE = " Hello <<name>>, We have your full" + 
				"name as <<full name>> in our system.\n"
				+ "Your contact number is 91­-xxxxxxxxxx.\n" + 
				"Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016";
	
	public static void main(String[] args) 
	{
		
		System.out.println("Enter your first name");
		String firstName = Utility.readNext();
		
		System.out.println("Enter your last name ");
		String lastName = Utility.readNext();
		
		System.out.println("Enter your mobile number");
		String number = Utility.readNext();
		
	System.out.println(Utility.getMessage(MESSAGE, firstName, lastName, number));
	
		
	}
	
}
