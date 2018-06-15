package com.bridgelabz.serviceimplementation;
import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.controller.StockManager;
import com.bridgelabz.lists.MyQueue;
import com.bridgelabz.lists.MyStack;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;
import com.bridgelabz.service.CustomerService;
import com.bridgelabz.service.TransactionService;
import com.bridgelabz.utility.Utility;

public class TransactionImplementation implements TransactionService {
	static List<Transaction> transactionList = new LinkedList<>();
	static MyQueue<String> timeStampList = new MyQueue<>();
	static MyStack<String> companySymbol = new MyStack<>();

	public TransactionImplementation(String transaction) 
	{
		transactionList = Utility.convertJsonToList(transaction, Transaction.class);
		// System.out.println(transactionList);
	}

	CustomerImplementation customerImpl = new CustomerImplementation();
	StockImplementation stockImpl = new StockImplementation();
	static Customer customer = null;
	Stock stock = null;
	Transaction transaction = null;

	@Override
	public void buy() 
	{
		transaction = new Transaction();
		System.out.println("Enter your mobile Number : ");
		long mobileNumber = Utility.retLong();
		customer = validateCustomer(mobileNumber);
		System.out.println("Enter company Name from which you want to buy share :");
		String companyName = Utility.retNext();
		System.out.println("How many share you want to buy ?");
		System.out.println("Enter number");
		long shares = Utility.retLong();
		boolean condition = checkShare(shares, companyName);
		if (condition == true)
		{
			transaction.setCompanyName(companyName);
			transaction.setNumberOfShares(shares);
			transaction.setCustomerName(customer.getCustomerName());
			String timeStamp = Utility.getTimeStamp();
			transaction.setTimeStamp(timeStamp);
			// adding timeStamp into queue
			timeStampList.enqueue(timeStamp);
			// adding company name in stack
			companySymbol.push(companyName);
			transactionList.add(transaction);
			Utility.convertJavaToJson(StockManager.TRANSACTION, transactionList);
			//System.out.println("Do you want to buy more shares yes[0]/no[1]");
			//condition();
			StockManager.showOptions();
		} 
		else if (condition == false) 
		{
			System.err.println("Entered company/stock name not exist in stock market");
			System.out.println("Re-Enter");
			buy();
		}
	}

	private boolean checkShare(long shares, String companyName) 
	{
		for (int i = 0; i < stockImpl.stockList.size(); i++) 
		{
			if (companyName.equalsIgnoreCase(stockImpl.stockList.get(i).getCompanyName())) 
			{
				Stock tempStock = stockImpl.stockList.get(i);
				if (shares <= tempStock.getNumberOfShares()
						&& customer.getAmount() >= (tempStock.getSharePrice() * shares)) 
				{
					int customerPresentAtIndex=searchFromCustomer(customer,CustomerImplementation.customerList);

					//System.out.println(customerPresentAtIndex);
					if(customerPresentAtIndex!=-1)
					{
					customerImpl.customerList.remove(customerPresentAtIndex);
					}
				//	System.out.println("Deleted");
					long newShares = tempStock.getNumberOfShares() - shares;
					long newAmount = customer.getAmount() - (tempStock.getSharePrice() * shares);
					tempStock.setNumberOfShares(newShares);
					Utility.convertJavaToJson(StockManager.STOCK_FILE, stockImpl.stockList);
					
					customer.setAmount(newAmount);
					customer.setNumberOfShares(customer.getNumberOfShares() + shares);
					
					customerImpl.customerList.add(customer);
					Utility.convertJavaToJson(StockManager.CUSTOMER_FILE, customerImpl.customerList);
					System.out.println("Stocks added successfully");
				} 
				else 
				{
					System.err.println(" Not enough shares in " + companyName+" stock");
					System.out.println("Do you want to buy share from another company ? yes[0]/no[1]");
					condition();
				}
				return true;
			}
		}
		return false;
	}

	private int searchFromCustomer(Customer customer2, List<Customer> customerList)
	{
		for(int i=0;i<customerList.size();i++)
		{
			if(customerList.get(i)==customer2)
			{
				return i;
			}
		}
		return -1;
	}

	private Customer validateCustomer(long mobileNumber) 
	{
		if (CustomerImplementation.customerList.size()==0) 
		{
			customer = customerImpl.add(mobileNumber);
		} 
		else 
		{
			for (int i = 0; i < CustomerImplementation.customerList.size(); i++) 
			{
				if (CustomerImplementation.customerList.get(i).getMobileNumber() == mobileNumber) 
				{
					customer = CustomerImplementation.customerList.get(i);
					break;
				}
			}
		}
		if (customer == null) {
			customer = customerImpl.add(mobileNumber);
		}
		return customer;
	}

	@Override
	public void showRecentCompanyTransactions()
	{
		System.out.println("The companies whose transaction done recently:");
		MyStack.displayStack();
	}

	@Override
	public void showRecentCompanyTransactionTime() {
		System.out.println("Recent transaction times are:");
		MyQueue.display();

	}

	public void condition() 
	{
		int option = Utility.retInt();
		switch (option) 
		{
		case 0:
			buy();
			break;
		case 1:
			StockManager.showOptions();
			break;
		}
	}

	public void close() 
	{
		System.out.println("Are you sure you want to leave? yes[0]/no[1]");
		int option = Utility.retInt();
		if (option == 0) {
			System.out.println("Thanks! Visit again");
			System.exit(0);
		}
		else if(option==1)
		{
			StockManager.showOptions();
		}
	}
	
	public void showCustomerDetails()
	{
		System.out.println("Enter the customer name whose transactions you want to know");
		String customerName=Utility.retNext();
		System.out.println(customerName+" bought shares from the following companies");
		for(int i=0;i<transactionList.size();i++)
		{
			if(transactionList.get(i).getCustomerName().equals(customerName))
			{
				System.out.println(transactionList.get(i).getCompanyName());
				System.out.println(transactionList.get(i).getNumberOfShares());
				System.out.println(transactionList.get(i).getTimeStamp());
				System.out.println();
				System.out.println();
			}
		}
		StockManager.showOptions();
	}
	
	public void showStockDetails()
	{
		System.out.println("Enter the company name whose transactions you want to know");
		String companyName=Utility.retNext();
		System.out.println("From "+companyName+" following customers bought shares");
		for(int i=0;i<transactionList.size();i++)
		{
			if(transactionList.get(i).getCompanyName().equals(companyName))
			{
				System.out.println(transactionList.get(i).getCustomerName());
				System.out.println(transactionList.get(i).getNumberOfShares());
				System.out.println(transactionList.get(i).getTimeStamp());
				System.out.println();
				System.out.println();
			}
		}
		StockManager.showOptions();
	}

}
