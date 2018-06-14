/******************************************************************************
 *  
 *  Purpose:  Check using Stopwatch the Elapsed Time for Binary Search , Insertion sort
 *  and Bubble Sort
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   22-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class Sorting {
	public static void main(String[] args) {
		
		Utility utility = new Utility();

		System.out.println("enter length of array");
		int length= utility.readInteger();
		
		System.out.println("Enter integer values");
		int[] array = utility.readArray(length);
		
		System.out.println("Enter a string");
		String str = utility.readNext();
		
		
		
		/*//System.out.println("enter a string to search in array");
		//String string = utility.readNext();
		utility.binarySearchString(str,0,array.length,'a');
		//System.out.println("The number is present in index :"+index);
		*/
		
 /**********************************************************************/
		
		System.out.println("***Insertion Sort***");
		int[] sortedArray = utility.insertionSort(array);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}
		char[] insertionSortStr = utility.insertionSort(str);
		for (int i = 0; i < insertionSortStr.length; i++) {
			System.out.println(insertionSortStr[i]);
		}
		
		
/*************************************************************************/		
		
		System.out.println("***Bubble Sort***");
		int[] bubbleSortArr = utility.bubbleSort(array);
		for (int i = 0; i < bubbleSortArr.length; i++) {
			System.out.println(bubbleSortArr[i]);
		}
		char[] bubbleSortStr = utility.bubbleSort(str);
		for (int i = 0; i < bubbleSortStr.length; i++) {
			System.out.println(bubbleSortStr[i]);
		}
	}

}
