/******************************************************************************
 *  
 *  Purpose:  Permutation Of String
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Permutation {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter a string");
		String inputString = utility.readNext();
		utility.StringPermutation(inputString);

	}

}
