package com.bridgelabz.utility;

import java.util.Scanner;

public class Utility
{
	static Scanner scanner = new Scanner(System.in);

	/**
	 * readInteger method takes integer as user input
	 * @return integer value
	 */
	public static Integer readInteger()
	{
		Integer number = scanner.nextInt();
		return number;
	}

	/**
	 * readString method takes string as user input
	 * @return String value
	 */
	public static String readString()
	{
		String string = scanner.next();
		return string;
	}

	/**
	 * readLong method takes long value as user input
	 * @return long value
	 */
	public static long readLong()
	{
		long number = scanner.nextLong();
		return number;
	}
	
	/**
	 * @return
	 */
	public static float readFloat()
	{
		float number = scanner.nextFloat();
		return number;
	}
	
}
