/******************************************************************************
 *  
 *  Purpose: To print table for power of two  
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   16-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class PowerOfTwo {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the number");
		int number = utility.readInteger();
		utility.findPowerOfTwo(number);

	}

}
