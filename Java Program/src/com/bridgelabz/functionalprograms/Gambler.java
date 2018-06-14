/******************************************************************************
 *  
 *  Purpose: Simulates a gambler who start with $stake and place fair $1 bets until
	he/she goes broke (i.e. has no money) or reach $goal.
	Print Number of Wins and Percentage of Win and Loss. 
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Gambler {
	/*
	  * The main function is written to print number of wins and percentage of win or loss
	  */
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the number of times game runs");
		utility.gamblerGame();

	}

}
