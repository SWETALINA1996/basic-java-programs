/******************************************************************************
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

public class Binary {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter an integer");
		int number = utility.readInteger();
		System.out.println("Binary value is: ");
		String binary = utility.toBinary(number);
		System.out.println(binary);
		if(binary.length() != 8)
		{
			binary = 0 + binary;
		}
		System.out.println(binary);
		char[] ch = binary.toCharArray();
		for (int i = 0; i < ch.length/2; i++) 
		{
			char temp = ch[i+ch.length/2];
			ch[i+ch.length/2] = ch[i];
			ch[i] = temp;
		}
		
		binary = String.valueOf(ch);
		System.out.println("After sorting :" +binary);
		int num = Integer.parseInt(binary);
		int decimalValue = utility.toDecimal(num);
		System.out.println(decimalValue);
	}

}
