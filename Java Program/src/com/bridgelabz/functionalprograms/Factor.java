/******************************************************************************
 *  
 *  Purpose:  To find Prime factors
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Factor {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter a number");
		int number=utility.readInteger();
		utility.findPrimeFactor(number); 
	}

}
