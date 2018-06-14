/****************************************************************************
 *  
 *  Purpose:  Merge Sort
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class MergeSort {
		public static void main(String[] args) {
			Utility utility = new Utility();
			
			System.out.println("enter length of array");
			int length= utility.readInteger();
			
			String[] array = utility.readStringArray(length);
			utility.mergeSort(array, 0, array.length-1);
			
			System.out.println("The sorted array is :");
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
	}
	
		

	

}
