/******************************************************************************
 *  
 *  Purpose:  Prime 2D Array
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   31-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class Prime2DArray {

	public static void main(String[] args) {
	
		int noOfRows = 10;
		int noOfColumns = 100;
		String[][] primeArray = new String[noOfRows][noOfColumns];
		
		for(int i = 0 ; i < noOfRows ; i++)
		{
			for (int j = 0; j < noOfColumns ; j++)
			{
				primeArray[i][j] = "";
			}
		}
		
		int start = 0 ;
		int end = 100;
		int col = 0;
		
		for(int row = 0 ; row < 10 ; row++)
		{
			for(int i = start ; i < end ; i++)
			{
				if(Utility.findPrime(i))
				{
				primeArray[row][col] = i+" ";
				col++;
				}
				
			}
			if(start <= 900 && end <= 1000)
			{
				start = start + 100 ;
				end = end + 100 ;
				col = 0;
			}
			
		}
		Utility.displayArray(primeArray);	
		
}
}


