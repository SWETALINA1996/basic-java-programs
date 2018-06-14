/******************************************************************************
 *  
 *  Purpose:  Balanced Parentheses
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   25-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class BalancedParenthesis {

	public static void main(String[] args) {
		System.out.println("Enter an expression with parenthesis");
		String expression = Utility.readNext();
		
		if(CheckBalanced.isBalanced(expression))
			System.out.println("Your expression is balanced");
				
		else
			System.out.println("Not balanced");

	}
	

}
