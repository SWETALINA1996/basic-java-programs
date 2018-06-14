package com.bridgelabz.objectoriented;

import java.util.ArrayList;

public class StockPojo {

	ArrayList<StockManagement> stockList = new ArrayList<StockManagement>();

	public ArrayList<StockManagement> getStockList() 
	{
		return stockList;
	}

	public void setStockList(ArrayList<StockManagement> stockList) {
		this.stockList = stockList;
	}	
		
}
