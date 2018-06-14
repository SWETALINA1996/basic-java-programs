/****************************************************************************
 *  
 *  Purpose:  
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   22-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class Generic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Utility utility = new Utility();
		
		System.out.println("Maximum values are");
		int max= utility.maximum(6, 3, 9);
		System.out.println(max);
		
		String str = utility.maximum("afg", "ssba", "wug");
		System.out.println(str);
		
		double number = utility.maximum(5.2, 8.6, 4.1);
		System.out.println(number);
		
/**************************************************************************************************/
		
		System.out.println("Enter the length of array");
		int length = utility.readInteger();
		
		System.out.println("Enter numbers");
		Integer array[] = utility.readIntArray(length);
		Integer res[]= utility.genericinsertionSort(array);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
		System.out.println("Enter String");
		String strArr[] = utility.readStringArray(length);
		String resStr[] = utility.genericinsertionSort(strArr);
		for (int i = 0; i < resStr.length; i++) {
			System.out.println(resStr[i]);
		}
		
		System.out.println("Enter numbers");
		Integer arrayValue[] =  utility.readIntArray(length);
		System.out.println("BubbleSort of integer");
		Integer result[]= utility.genericBubbleSort(arrayValue);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		System.out.println("Enter String");
		String strSort[] = utility.readStringArray(length);
		System.out.println("Bubble sort of string");
		String sortedString[]= utility.genericBubbleSort(strSort);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		

	}

}
