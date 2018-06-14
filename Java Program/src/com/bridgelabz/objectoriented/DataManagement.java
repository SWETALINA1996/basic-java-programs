package com.bridgelabz.objectoriented;

/******************************************************************************
 *  
 *  Purpose:
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   31-05-2018
 *
 ******************************************************************************/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataManagement
{

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader("/home/bridgelabz/Documents/Inventory.json"));
		JSONObject obj = (JSONObject)object;
		JSONArray jArray = null;
		String jArrayName = ""; 
		int weight = 0;
		int price = 0;
		for (int i = 0; i < 3; i++) 
		{
			if(i==0)
			{
				jArray = (JSONArray)obj.get("Rice");
				jArrayName =jArrayName+"Rice";
			}
			else if(i==1)
			{
				jArray = (JSONArray)obj.get("Pulses");
				jArrayName = jArrayName+"Pulses";
			}
			else if(i==2)
			{
				jArray = (JSONArray)obj.get("Wheat");
				jArrayName = jArrayName+"Wheat";
			}
			
			for (int j = 0; j < jArray.size(); j++)
			{
				JSONObject item = (JSONObject) jArray.get(j);
				weight = weight + Integer.parseInt(item.get("weight in kg").toString());
				price = price + (Integer.parseInt(item.get("weight in kg").toString())) * (Integer.parseInt(item.get("price").toString()));
			}
			
			System.out.println("Name : "+jArrayName+"\nweight: "+weight+"\nTotal price: "+price);
			
		}
		
		
	}
}
