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
import com.bridgelabz.lists.MyLinkedList;
import com.bridgelabz.model.Customer;
import com.bridgelabz.service.CustomerService;
import com.bridgelabz.utility.Utility;

public class CustomerImplementation implements CustomerService{
	static List<Customer>customerList=new LinkedList<>();
	static Customer customer=null;
	public CustomerImplementation(String customerFile) {
		customerList=Utility.convertJsonToList(customerFile, Customer.class);
		//System.out.println(customerList);
	}

	public CustomerImplementation() {
	}
	
	@Override
	public Customer add(long mobileNumber) {
		customer=new Customer();
		System.out.println("Enter customer name: ");
		String customerName=Utility.retNext();
		customer.setCustomerName(customerName);
		customer.setMobileNumber(mobileNumber);
		System.out.println("Enter Initial amount: ");
		long amount=Utility.retLong();
		customer.setAmount(amount);
		//customer.setNumberOfShares(numberOfShares);
		//customerList.add(customer);
	//	System.out.println(customerList);
		//Utility.convertJavaToJson(StockManager.CUSTOMER_FILE,customerList);
		//System.out.println("customer data saved successfully");
		return customer;
	}

	@Override
	public void remove(int index1) {
		customerList.remove(index1);
		Utility.convertJavaToJson(StockManager.CUSTOMER_FILE, customerList);
		System.out.println("Customer details remove from market successfully");
	}

	@Override
	public void update(int index) {
		System.out.println("Enter new amount : ");
		long amount=Utility.retLong();
		amount+=customerList.get(index).getAmount();
		customerList.get(index).setAmount(amount);
		Utility.convertJavaToJson(StockManager.CUSTOMER_FILE, customerList);
		System.out.println("balance updated successfully");
	}

	@Override
	public void displayCustomerList() {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(StockManager.CUSTOMER_FILE));
			JSONArray customerArray = (JSONArray) object;
			for (int i = 0; i < customerArray.size(); i++) {
				JSONObject details = (JSONObject) customerArray.get(i);
				System.out.println("index : " + i + " " + details);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		/*for(int i=0;i<customerList.size();i++)
		{
			System.out.println("index="+i+customerList.get(i));
		}*/
	}
	}