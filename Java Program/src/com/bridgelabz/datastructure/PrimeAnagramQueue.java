/******************************************************************************
 *  
 *  Purpose:  Prime Anagram using queue
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   31-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramQueue {

	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		  String temp = "";
	        for (int number = 0; number <= 1000; number++) {
	            if (Utility.findPrime(number)) {
	                temp += number + " ";
	            }
	        }
	        String[] array = temp.split(" ");
	        for (int i = 0; i < array.length - 1; i++) {
	            for (int j = i + 1; j < array.length; j++) {
	                if (Utility.checkAnagramString(array[i], array[j])) {
	                    queue.enqueue(array[i]);
	                    queue.enqueue(array[j]);
	                }
	            }
	        }
	        System.out.println("Prime Anagram :");
	        System.out.println(queue.display());
	}

}
