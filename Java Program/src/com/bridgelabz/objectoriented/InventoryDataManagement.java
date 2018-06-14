
/******************************************************************************
 *  
 *  Purpose: inventory data management 
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   31-05-2018
 *
 ******************************************************************************/

package com.bridgelabz.objectoriented;

import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class InventoryDataManagement
{
public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
	InventoryPojoManagement management = new InventoryPojoManagement();
	
	long totalRiceSum = 0;
	long totalWheatSum = 0;
	long totalPulsesSum = 0;
	
	Product product = new Product();
	ObjectMapper map = new ObjectMapper();
	
	System.out.println("Enter varieties of rice");
	int riceVariety = Utility.readInteger();
	Product rice = new Product();
	for (int i = 0; i < riceVariety; i++) 
	{
		rice = productDetails();
		management.getRiceList().add(rice);
	}
	
	System.out.println("Enter varieties of wheat");
	int wheatVariety = Utility.readInteger();
	Product wheat = new Product();
	for (int i = 0; i < wheatVariety; i++) 
	{
		wheat = productDetails();
		management.getWheatList().add(wheat);
	}
	
	System.out.println("Enter varieties of pulses");
	int pulsesVariety = Utility.readInteger();
	Product pulses = new Product();
	for (int i = 0; i < pulsesVariety; i++) 
	{
		pulses = productDetails();
		management.getPulseList().add(pulses);
	}
	
	
	Utility.toJSON(management , "/home/bridgelabz/Documents/InventoryDetails");
	
	
	JSONParser parser = new JSONParser();
	Object object = parser.parse(new FileReader( "/home/bridgelabz/Documents/InventoryDetails"));
	JSONObject obj = (JSONObject)object;
	
	//rice
	JSONArray riceArray = (JSONArray)obj.get("riceList"); 
	for(int i = 0 ; i < riceArray.size(); i++)
	{
		JSONObject objRice = (JSONObject) (riceArray.get(i));
		
		totalRiceSum += (long)objRice.get("weight") * (long)objRice.get("price");
	}
	System.out.println("Rice(total price): "+totalRiceSum);
	
	
	//wheat
	
	JSONArray wheatArray = (JSONArray)obj.get("wheatList"); 
	for(int i = 0 ; i < wheatArray.size(); i++)
	{
		JSONObject objWheat = (JSONObject) (wheatArray.get(i));
		
		totalWheatSum += (long)objWheat.get("weight") * (long)objWheat.get("price");
	}
	System.out.println("Wheat(total price): "+totalWheatSum);

	//pulses
	JSONArray pulsesArray = (JSONArray)obj.get("pulseList"); 
	for(int i = 0 ; i < pulsesArray.size(); i++)
	{
		JSONObject objPulses = (JSONObject) (pulsesArray.get(i));
		
		totalPulsesSum += (long)objPulses.get("weight") * (long)objPulses.get("price");
	}
	System.out.println("Pulses(total price): "+totalPulsesSum);
	
}


public static Product productDetails()
{
	Product product = new Product();
	
	System.out.println("Enter the name:");
	String name =  Utility.readNext();
   product.setName(name);
   
	System.out.println("Weight:");
	long weight = Utility.readLong();
	product.setWeight(weight);
	
	System.out.println("price:");
	long price = Utility.readLong();
	product.setPrice(price);
	
	return product;
}


}
