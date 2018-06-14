/****************************************************************************
 *  
 *  Purpose:  Conversion of Temperature from Fahrenheit to Celcius nd vice- versa
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   22-05-2018
 *
 ******************************************************************************/package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

public class TemperatureConvertion {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter temperature in Celcius ");
		double tempCelcius = utility.readDouble();
		System.out.println(tempCelcius+"C = "+ ((tempCelcius * 9/5) + 32) +"F");
		
		
		System.out.println("Enter temperature in Fahrenheit ");
		double tempFahrenheit = utility.readDouble();
		System.out.println(tempFahrenheit+"F = "+ ((tempFahrenheit -32) * 5/9) +"C");

	}

}
