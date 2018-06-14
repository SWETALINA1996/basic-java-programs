/****************************************************************************
 *  
 *  Purpose:  Calculate monthly payment
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   22-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class Payment {

	public static void main(String[] args) {
		Utility utility = new Utility();
		double principal = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		double year = Double.parseDouble(args[2]);
		double pay = utility.monthlyPayment(principal, rate, year);
		System.out.println("Monthly Payment =" +pay);
	}

}
