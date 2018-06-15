package com.bridgelabz.serviceimplementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.controller.StockManager;
import com.bridgelabz.model.Stock;
import com.bridgelabz.service.StockService;
import com.bridgelabz.utility.Utility;

public class StockImplementation implements StockService {
	static List<Stock> stockList = new LinkedList<>();

	public StockImplementation(String stockFile) {
		stockList = Utility.convertJsonToList(stockFile, Stock.class);
		//System.out.println(stockList);
	}

	public StockImplementation() {
	}
	Stock stock = null;

	@Override
	public void add() {
		stock = new Stock();
		System.out.println("Enter Stock/Company Name");
		String companyName = Utility.retNext();
		stock.setCompanyName(companyName);
		System.out.println("Enter Number Of Shares of the company");
		long numberOfShares = Utility.retLong();
		stock.setNumberOfShares(numberOfShares);
		System.out.println("Enter price of each share");
		long sharePrice = Utility.retLong();
		stock.setSharePrice(sharePrice);
		stockList.add(stock);
		Utility.convertJavaToJson(StockManager.STOCK_FILE, stockList);
		System.out.println("Stock details added successfully");
	}

	@Override
	public void remove(int index) {
		stockList.remove(index);
		Utility.convertJavaToJson(StockManager.STOCK_FILE, stockList);
		System.out.println("specified Stock removed from the market successfully");
	}

	@Override
	public void displayStockList() {
		/*JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(StockManager.STOCK_FILE));
			JSONArray stockArray = (JSONArray) object;
			for (int i = 0; i < stockArray.size(); i++) {
				JSONObject details = (JSONObject) stockArray.get(i);
				System.out.println("index : " + i + " " + details);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}*/
		for(int i=0;i<stockList.size();i++)
		{
			System.out.println("index="+i+" "+stockList.get(i));
		}
	}

}