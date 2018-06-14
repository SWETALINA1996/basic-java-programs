
/******************************************************************************
 *  
 *  Purpose:  To find roots for Quadratic equation
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   18-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Quadratic {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter three values for a, b and c");
		int a = utility.readInteger();
		int b = utility.readInteger();
		int c = utility.readInteger();
		utility.findQuadraticRoots(a,b,c);
	}

}
