/******************************************************************************
 *  
 *  Purpose:  Guessing a number between 0 - 2^n
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/

package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class GuessNumber {

	public static void main(String[] args) {
		Utility utility = new Utility();
		
		int N = Integer.parseInt(args[0]);
		 
	    System.out.println("Think of an integer between "+0+" "+(N-1));
	    	
	    utility.searchNumber(0, N-1);
	    

	}
 
}
