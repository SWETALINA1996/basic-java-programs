

package com.bridgelabz.datastructure;
import com.bridgelabz.utility.*;


public class PallindromeChecker {
	
		public static void main(String[] args) {
			
			System.out.println("Enter a String");
			String word = Utility.readNext();
			
			if(CheckPallindrome.isPallindrome(word))
				System.out.println("The String is Pallindrome");
			else
				System.out.println("The String is not Pallindrome");
			
		}
}
 