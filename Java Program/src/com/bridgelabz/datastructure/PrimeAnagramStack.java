/******************************************************************************
 *  
 *  Purpose: Prime Anagram using Stack
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   31-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramStack {
    public static void main(String[] args) {
    	MyStack stack = new MyStack();
    	
        String temp = "";
        for (int number = 1; number <= 1000; number++) {
            if (Utility.findPrime(number)) {
                temp = temp + number + " ";
            }
        }
       // System.out.println(temp);
        String[] array = temp.split(" ");
        for (int i = 0; i < array.length; i++) {
			//System.out.print(array[i]);
		}
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
            	
                if (Utility.checkAnagramString(array[i], array[j]))
                {
                    stack.push(array[i]);
                    stack.push(array[j]);
                   // System.out.println(stack);
                }
            }
        }
        System.out.println("Prime anagram in Stack");
        System.out.println(stack);
    }

}