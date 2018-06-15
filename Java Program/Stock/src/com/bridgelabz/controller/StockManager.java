package com.bridgelabz.controller;
import com.bridgelabz.serviceimplementation.CustomerImplementation;
import com.bridgelabz.serviceimplementation.StockImplementation;
import com.bridgelabz.serviceimplementation.TransactionImplementation;
import com.bridgelabz.utility.Utility;

public class StockManager {
	public static final String CUSTOMER_FILE = "/home/bridgelabz/swetalina/basic-java-programs/Stock/src/com/bridgelabz/list/Customer.json";
	public static final String STOCK_FILE = "/home/bridgelabz/swetalina/basic-java-programs/Stock/src/com/bridgelabz/list/Stock.json";
	public static final String TRANSACTION = "/home/bridgelabz/swetalina/basic-java-programs/Stock/src/com/bridgelabz/list/Transaction.json";

	static CustomerImplementation customerImplentation = new CustomerImplementation(CUSTOMER_FILE);
	static StockImplementation stockImplentation = new StockImplementation(STOCK_FILE);
	static TransactionImplementation transactionImplentation = new TransactionImplementation(TRANSACTION);

	public static void main(String[] args) {
		System.out.println("WELCOME TO STOCK MARKET");
		System.out.println("What do you want to do ?");
		showOptions();
	}

	public static void showOptions() {
		System.out.println("1.Add Stocks\n2.Remove Stock");
		System.out.println("3.Buy Shares");
		System.out.println("4.Update balance\n5.Remove Customer");
		System.out.println("6.Show Customer Details\n7.Show StockList");
		System.out.println("8.Show Recent Company Transaction Time\n9.Show Recent Transaction Company");
		System.out.println("10.show transaction of particular customer\n11.show transaction of particular stock");
		System.out.println("12.close");
		int option = Utility.retInt();
		switch (option) {
		case 1:
			stockImplentation.add();
			showOptions();
			break;
		case 2:
			System.out.println("Enter stock/company name which you want to delete from the market");
			stockImplentation.displayStockList();
			System.out.println("Enter index");
			int index = Utility.retInt();
			stockImplentation.remove(index);
			showOptions();
			break;
		case 3:
			transactionImplentation.buy();
			showOptions();
			break;
		case 4:
			System.out.println("In which customer account you want to add balance");
			customerImplentation.displayCustomerList();
			System.out.println("Enter index");
			int index2=Utility.retInt();
			customerImplentation.update(index2);
			showOptions();
			break;
		case 5:
			System.out.println("Enter index of the Customer which you want to delete from the market");
			customerImplentation.displayCustomerList();
			System.out.println("Enter index: ");
			int index1=Utility.retInt();
			customerImplentation.remove(index1);
			showOptions();
			break;
		case 6:
			customerImplentation.displayCustomerList();
			showOptions();
			break;
		case 7:
			stockImplentation.displayStockList();
			showOptions();
			break;
		case 8:
			transactionImplentation.showRecentCompanyTransactionTime();
			showOptions();
			break;
		case 9:
			transactionImplentation.showRecentCompanyTransactions();
			showOptions();
			break;
		case 10:
			transactionImplentation.showCustomerDetails();
			break;
		case 11:
			transactionImplentation.showStockDetails();
			break;
		case 12:
			transactionImplentation.close();
			break;
		}
	}

}
