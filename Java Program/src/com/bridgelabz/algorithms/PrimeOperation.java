/******************************************************************************
 *  
 *  Purpose:  To find the prim numbers that are Anagram and Palindrome
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.datastructure.SingleLinkedList;
import com.bridgelabz.utility.Utility;

public class PrimeOperation {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println(" Enter a range ");
		int range = utility.readInteger();
		
		System.out.println("All the prime numbers within 0 - "+range+" is:");
		
		SingleLinkedList<Integer> singlePrimeList = new SingleLinkedList<Integer>();
		
		for (int i = 0; i < range; i++) 
		{
			if(utility.findPrime(i))
			{
				singlePrimeList.add(i);
				
				if(utility.isPallindrome(i))
				{
					System.out.println(i);
				}
				
				
				
				
			}
			
		}
	}

}
