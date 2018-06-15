package com.bridgelabz.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Utility 
{
	static Scanner scanner = new Scanner(System.in);

	public static Integer readInteger()
	{
		Integer number = scanner.nextInt();
		return number;
	}

	public static String readString()
	{
		String string = scanner.next();
		return string;
	}

	public static long readLong()
	{
		long number = scanner.nextLong();
		return number;
	}
	/**
	 * @param object
	 * @param path
	 */
	public static <T> void toJSON(T object , String path) 
	{
		ObjectMapper map = new ObjectMapper();
		
		ObjectWriter write = map.writer(new DefaultPrettyPrinter());
		try
		{
			write.writeValue(new File(path), object);
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		System.out.println("Done...");
	}

	public static ArrayList<Object> jsonToJavaList(String fileName) {
		JSONParser parser = new JSONParser();
		ArrayList<Object> addressBookList = new ArrayList<>();
		try {
			
			Object obj = parser.parse(new FileReader(fileName));
			JSONArray personList = (JSONArray) obj;
			for(Object object : personList) {
				String addressBookName = object.toString();
				addressBookList.add(addressBookName);
			}
		}
		catch(Exception e) {
			System.out.println("Hello");
		}
		return addressBookList;
	}
	/**
	 * @param min
	 * @param max
	 * @return
	 */
	public static long getRandomRange(double min, double max) {

	    long number = (long) ((Math.random() * ((max - min) + 1)) + min);

	    return number;

	}

	public static String getTimeStamp() {
	    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
	    return formater.format(date);
	}



public static <T> ArrayList<T> convertJsonToList(String FILEPATH,ArrayList<T>list) {
	ObjectMapper mapper = new ObjectMapper();
	//ArrayList<String> bookList = new ArrayList<>();
	try {
		list = mapper.readValue(new File(FILEPATH), new TypeReference<ArrayList<T>>() {});
	return list;
	} catch (Exception e) {
	//	System.err.println(" List is empty..!");
	
	}
	return new ArrayList<T>();
}
public static <T> void convertJavaToJson(List<T> list , String file ) {
	ObjectMapper mapper = new ObjectMapper();
	ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
	try {
		writer.writeValue(new File(file), list);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public static <T> LinkedList<T> convertJsonToList(String FILEPATH, Class<T> list) {
	ObjectMapper mapper = new ObjectMapper();
	try {
		JavaType type = mapper.getTypeFactory().constructParametricType(LinkedList.class, list);
		return mapper.readValue(new File(FILEPATH), type);
	} catch (IOException e) {
		System.err.println(" List is empty..");
		return new LinkedList<>();
	}
}

}
