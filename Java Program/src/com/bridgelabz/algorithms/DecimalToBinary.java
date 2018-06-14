/******************************************************************************
 *  
 *  Purpose:  Decimal to Binary Conversion
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   22-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class DecimalToBinary {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter a decimal value");
		int number = utility.readInteger();
		System.out.println("Binary value is: ");
		System.out.println(utility.toBinary(number));
	}

}
