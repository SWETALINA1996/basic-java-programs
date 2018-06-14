package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class PrimeArray {
	public static void main(String[] args) {
		 
		int noOfRows = 10;
		int noOfColumns = 1000;
	SingleLinkedList primeArray[][] = new SingleLinkedList[noOfRows][noOfColumns];
	    
	//creating object for each block
	for(int i = 0 ; i < noOfRows ; i++)
	{
	//	primeArray[i] = new SingleLinkedList[100];
		for(int j = 0 ; j < noOfColumns ; j++)
		{
			primeArray[i][j] = new SingleLinkedList();
		}
	}
	
	int Rows = 0;
	int columns =100;
	
	//to check for prime
	for(int i = 0; i < noOfRows ; i++)
	{
		for(int j = Rows ; j< columns ; j++)
		{
			int k =0;
			if(Utility.findPrime(j))
				primeArray[i][k].add(j);
			k++;
			Rows = Rows + 100;
			columns = columns +100;
		}
	}
	 
	//display
	for(int i = 0; i < primeArray.length ; i++)
	{
		System.out.println(i+" ");
		for(int j = 0 ; j< 1000 ; j++)
		{
			if(!primeArray[i][j].isEmpty()) {
			primeArray[i][j].display();
			
		}
		System.out.println();
	}
	}
	}

}
