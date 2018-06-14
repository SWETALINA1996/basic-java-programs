/******************************************************************************
 *  
 *  Purpose:  Anagram
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   21-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class Anagram {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("enter two strings");
		
		String str1 = utility.readNextLine();
		String s1=utility.removeSpace(str1);
		String st1=utility.toLower(s1);
		char char1[]=utility.sort(st1);	
		
		String str2 = utility.readNextLine();
		String s2=utility.removeSpace(str2);
		String st2=utility.toLower(s2);
		char char2[]=utility.sort(st2);
		
		if(utility.checkAnagram(char1, char2))
		{
			System.out.println("The Strings are Anagram");
		}
		else
			System.out.println("Not Anagram");
	}

}
