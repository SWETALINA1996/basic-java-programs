/******************************************************************************
 *  
 *  Purpose:  To Calculate effective temperature of WindChill
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   18-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class WindChill {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter temperature and speed");
		int temperature = utility.readInteger();
		int speed = utility.readInteger();
		utility.calculateEffectiveTemp(temperature,speed);

	}

}
