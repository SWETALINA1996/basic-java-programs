package com.bridgelabz.objectoriented;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookApplication
{
	
	public static void showOptions() throws FileNotFoundException, IOException, ParseException
{
System.out.println("Enter 1 to CREATE NEW");
System.out.println("Enter 2 to OPEN");
System.out.println("Enter 3 to DELETE");
System.out.println("Enter 4 to VIEW ");
System.out.println("Enter 5 to QUIT");


int option = Utility.readInteger();
AddressBookApplication.selectOperation(option);
}
	public static void selectOperation(int option) throws FileNotFoundException, IOException, ParseException
	{
		AddressBookController addressBook = new AddressBookController();
		
		switch(option)
		{
		case 1:
			
			addressBook.createNew();
			showOptions();
		    break;
		    
		case 2:
		
			addressBook.doOpen();
			showOptions();
			
			break;
			
		case 3:
			addressBook.doDelete();
			break;
			
		case 4:
			addressBook.viewBookList();
			break;
			
		case 5:
			addressBook.quit();
			break;
		default : 
			System.out.println("Closed");
		
		}	
	}

public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
{
	
	System.err.println("Welcome To Address Book");
	AddressBookApplication.showOptions();
	
}

}
