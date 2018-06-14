/******************************************************************************
 *  
 *  Purpose: Print Euclidean Distance
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/*
 * The main function is written to calculate Euclidean Distance
 */
public class Distance {

	public static void main(String[] args) {
		Utility utility=new Utility();
		int firstInteger=Integer.parseInt(args[0]);
		int secondInteger=Integer.parseInt(args[1]);
		utility.calculateDistance(firstInteger,secondInteger);
		
	}

}
