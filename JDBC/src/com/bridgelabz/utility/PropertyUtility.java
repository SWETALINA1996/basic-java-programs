package com.bridgelabz.utility;

import java.io.FileReader;
import java.util.Properties;

public class PropertyUtility {

	public static String getProperty(String key)
	{
		String value = null;
		Properties property = new Properties();
		try {
			FileReader readFile = new FileReader("/home/bridgelabz/swetalina/basic-java-programs/"
					+ "JDBC/src/com/bridgelabz/files/config.properties");
			property.load(readFile);
			value = property.getProperty(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	/*public static void main(String[] args) {
		System.out.println(getProperty("driver"));
	}*/
}
