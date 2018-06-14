/******************************************************************************
 *  
 *  Purpose:To compute the square root of a non-negative number c given in the input using Newton's method
 *  @author  Swetalina
 *  @version 1.0
 *  @since   22-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class SqrtNumber {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter a number");
		int number = utility.readInteger();
		System.out.println(utility.sqrt(number));

	}

}
