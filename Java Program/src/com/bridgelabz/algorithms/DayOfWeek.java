/******************************************************************************
 *  
 *  Purpose:  To find which day of the week date falls
 *  @author  Swetalina
 *  @version 1.0
 *  @since   22-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class DayOfWeek {

	public static void main(String[] args) {
		Utility utility = new Utility();
		int date = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int year = Integer.parseInt(args[2]);
		String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		if(utility.isValidDate(month, date, year))
		{
		int result = utility.dayOfWeek(month, date, year);
		System.out.println(days[result]);
		}
		else 
			System.out.println("Enter a valid date");
				

	}

}
