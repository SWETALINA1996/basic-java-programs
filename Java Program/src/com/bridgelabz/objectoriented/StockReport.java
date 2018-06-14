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

public class StockReport 
{
public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
	StockPojo stock = new StockPojo();
	
	StockManagement management = new StockManagement();
	ObjectMapper map = new ObjectMapper();
	long valueOfStock = 0;
	long totalStockValue = 0;
	
	System.out.println("Enter the number of Stocks");
	int totalStock = Utility.readInteger();
	StockManagement stock1 = new StockManagement();
	for (int i = 0; i < totalStock ; i++) 
	{
		stock1 = stockDetails();
		stock.getStockList().add(stock1);
	}
	
	Utility.toJSON(stock , "/home/bridgelabz/Documents/sweta/BasicPrograms/Java Program/src/com/bridgelabz/objectoriented/Stock.json");
	
	JSONParser parser = new JSONParser();
	Object object = parser.parse(new FileReader("/home/bridgelabz/Documents/sweta/BasicPrograms/Java Program/src/com/bridgelabz/objectoriented/Stock.json"));
	JSONObject obj = (JSONObject)object;
	//System.out.println(stock.getStockList());
	
	JSONArray stockArray = (JSONArray)obj.get("stockList"); 
	
	//System.out.println(stockArray.size());
	for(int i = 0 ; i < stockArray.size(); i++)
	{
		JSONObject objStock = (JSONObject)stockArray.get(i);
		
		valueOfStock += (long)objStock.get("numberOfShare") * (long)objStock.get("sharePrice");
		System.out.println("Value of "+i+" stock: " +valueOfStock);
		totalStockValue += valueOfStock;
		valueOfStock = 0;
	}
	
	System.out.println("Total Stock value: " +totalStockValue);
	
}

public static StockManagement stockDetails()
{
	StockManagement stockManage = new StockManagement();
	
	System.out.println("Enter Stock name");
	String stockName = Utility.readNext();
	stockManage.setStockName(stockName);
	
	System.out.println("Enter number of shares");
	long numberOfShares = Utility.readLong();
	stockManage.setNumberOfShare(numberOfShares);
	
	System.out.println("Enter share price");
	long stockPrice = Utility.readLong();
	stockManage.setSharePrice(stockPrice);
	
	return stockManage;
}
	
}
