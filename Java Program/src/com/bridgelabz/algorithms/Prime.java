
/******************************************************************************
 *  
 *  Purpose:  Find Prime numbers in a range
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class Prime {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println(" Enter a range ");
		int range = utility.readInteger();
		
		System.out.println("All the prime numbers within 0 - "+range+" is:");
		for (int i = 0; i < range; i++) 
		{
			if(utility.findPrime(i))
				System.out.println(i);
		}
		
		
	}

}
