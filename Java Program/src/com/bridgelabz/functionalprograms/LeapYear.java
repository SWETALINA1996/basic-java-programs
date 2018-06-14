/******************************************************************************
 *  
 *  Purpose: Determines whether year is leap year or not. 
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class LeapYear {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter a year");
		
		int year=utility.readInteger();
		
		if(utility.leapYear(year))
			System.out.println("year is a leap year");
		else
			System.out.println("not a leap year");

	}

}
