/******************************************************************************
 *  
 *  Purpose: Replace <<UserName>> with the proper name 
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   16-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class UserName {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter name");
		String name = utility.readNext();
		String message = utility.replace(name);
		System.out.println(message);
	}

}
