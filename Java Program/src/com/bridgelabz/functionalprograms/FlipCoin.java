/******************************************************************************
 *  
 *  Purpose:  To find head count and tail count of number of times coin is flipped 
 *  and head percentage
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class FlipCoin {

	public static void main(String[] args) {
			Utility utility=new Utility();
			System.out.println("Enter the number of times to flip the coin");
			  int noOfFlip=utility.readInteger();
			  utility.percentOfFlip(noOfFlip);
			   

			}


}
