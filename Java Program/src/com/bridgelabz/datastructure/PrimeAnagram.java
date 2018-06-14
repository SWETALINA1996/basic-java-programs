/******************************************************************************
 *  
 *  Purpose:  Prime Anagram
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   29-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class PrimeAnagram {

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
		String temp = "";
		
		for(int row = 0 ; row < 10 ; row++)
		{
			for(int i = start ; i <= end ; i++)
			{
				if(Utility.findPrime(i))
				{
					temp = temp + i + " ";
					
					String[] array = temp.split(" ");

					for (int k = 0; k < array.length - 1; k++)
					{
					    for (int j = k + 1; j < array.length; j++)
					    {
					    	char[] ch1 = array[k].toCharArray();
					    	char[] ch2 = array[j].toCharArray();
					    	
					        if (Utility.checkAnagram(ch1, ch2))
					        {
					        	String anagram = array[j];
					        	primeArray[row][col] = anagram+" ";
					        }
					    }
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
}










/*
String temp = "";
for (int number = 2; number <= 1000; number++) {
    if (Utility.findPrime(number)) {
        temp = temp + number + " ";
    }
}
String[] array = temp.split(" ");

for (int i = 0; i < array.length - 1; i++)
{
    for (int j = i + 1; j < array.length; j++)
    {
    	char[] ch1 = array[i].toCharArray();
    	char[] ch2 = array[j].toCharArray();
    	
        if (Utility.checkAnagram(ch1, ch2))
        {
           System.out.print(array[i]+" ");
           System.out.println(array[j]);
        }
    }
}
*/
