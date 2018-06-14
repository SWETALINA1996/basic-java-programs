package com.bridgelabz.objectoriented;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookController
{
	static List<String> listOfAddressBook = new LinkedList<>();
	AddressBook addressBook = new AddressBook();
	
	String addressBookPath = "/home/bridgelabz/Documents/sweta/BasicPrograms/Java Program/src/listOfAddressBook.json";
	
public AddressBookController() {

}
public AddressBookController(String fileName)
{
	if(listOfAddressBook == null) 
	{
		try 
		{
			listOfAddressBook =  Utility.jsonToJavaAddressBookList(fileName);
		}
		catch(Exception e) 
		{
			System.out.println("No address book available");
			listOfAddressBook = new ArrayList<>();
		}
	}
}
	
	
	java.util.List<Person> listOfPerson;
	
/**
 * @param fileName
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public void doAdd(String fileName) throws FileNotFoundException, IOException, ParseException
{
	JSONParser parser = new JSONParser();
	Person person = new Person();
	List<JSONObject> obj = (List<JSONObject>)parser.parse(new FileReader(fileName));
	
	System.out.println("Enter the number of entries");
	int entry = Utility.readInteger();
	for(int i = 0 ; i < entry ; i++)
	{
		
	System.out.println("Enter First Name");
	String firstName = Utility.readNext();
	person.setFirstName(firstName);
	
	System.out.println("Enter Last Name ");
	String lastName = Utility.readNext();
	person.setLastName(lastName);
	
	System.out.println("Enter City");
	String city = Utility.readNext();
	person.setCity(city);
	
	System.out.println("Enter State");
	String state = Utility.readNext();
	person.setState(state);
	
	System.out.println("Enter Address");
	String address = Utility.readNext();
	person.setAddress(address);
	
	System.out.println("Enter ZipCode");
	String zipCode= Utility.readNext();
	person.setZip(zipCode);
	
	System.out.println("Enter PhoneNumber");
	String phoneNumber= Utility.readNext();
	person.setPhoneNumber(phoneNumber);
	
	listOfPerson = addressBook.addPerson(firstName, lastName, address, city, state, phoneNumber, zipCode);

	JSONObject personObject = new JSONObject();
	personObject.put("firstName", person.getFirstName());
	personObject.put("lastName", person.getLastName());
	personObject.put("city", person.getCity());
	personObject.put("state", person.getState());
	personObject.put("address", person.getAddress());
	personObject.put("zip", person.getZip());
	personObject.put("phoneNumber", person.getPhoneNumber());
	obj.add(personObject);
	}
	
	JSONArray personArray = new JSONArray();
	for(int i = 0 ; i< obj.size();i++)
	{
		personArray.add(obj.get(i));
	}
	
	
	Utility.toJSON(personArray, fileName);
	AddressBookController.doPrint(fileName);
	System.out.println("Successfully Added...");
}
/**
 * @throws JsonGenerationException
 * @throws JsonMappingException
 * @throws IOException
 * @throws ParseException 
 */
public void doRemove(String fileName) throws JsonGenerationException, JsonMappingException, IOException, ParseException
{
	
	System.out.println("Enter the index number to be deleted");
	int index = Utility.readInteger();
	listOfPerson = addressBook.removePerson(index);
	
	Utility.toJSON(listOfPerson, fileName);
	AddressBookController.doPrint(fileName);
	System.err.println("Removed Successfully...");
	
}
/**
 * 
 */
public void doEdit(String fileName)
{
	
	System.out.println("Enter the index of person to edit");
	int index = Utility.readInteger();
	System.out.println("Enter 1 to edit phone number");
	System.out.println("Enter 2 to edit address ");
	System.out.println("Enter 3 to edit city");
	System.out.println("Enter 4 to edit state");
	System.out.println("Enter 5 to edit zip code");
	
	int choice = Utility.readInteger();
	switch(choice)
	{
	case 1:
		System.out.println("Enter new Phone Number");
		String phoneNumber = Utility.readNext();
		listOfPerson.get(index).setPhoneNumber(phoneNumber);
		Utility.toJSON(listOfPerson, fileName);
		break;
		
	case 2:
		System.out.println("Enter new Address");
		String address = Utility.readNext();
		listOfPerson.get(index).setAddress(address);
		Utility.toJSON(listOfPerson, fileName);
		break;
		
	case 3:
		System.out.println("Enter new city");
		String city = Utility.readNext();
		listOfPerson.get(index).setCity(city);
		Utility.toJSON(listOfPerson, fileName);
		break;
		
	case 4 :
		System.out.println("Enter new State");
		String state = Utility.readNext();
		listOfPerson.get(index).setState(state);
		Utility.toJSON(listOfPerson, fileName);
		break;
		
	case 5:
		System.out.println("Enter new ZipCode");
		String zipCode = Utility.readNext();
		listOfPerson.get(index).setZip(zipCode);
		Utility.toJSON(listOfPerson, fileName);
		break;
	}
	
}

/**
 * @throws ParseException 
 * @throws IOException 
 * @throws FileNotFoundException 
 * 
 */
public static void operationOnBook(String fileName) throws FileNotFoundException, IOException, ParseException
{
	System.out.println("Enter 1 to add new person");
	System.out.println("Enter 2 to edit data");
	System.out.println("Enter 3 to delete a person data");
	System.out.println("Enter 4 to close recently opened book");
	System.out.println("Which operation you want to perform?");
	int choice = Utility.readInteger();
	
	AddressBookController.selectOperation(choice , fileName);
}

/**
 * @param choice
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static void selectOperation(int choice , String fileName) throws FileNotFoundException, IOException, ParseException
{
	AddressBookController aBController = new AddressBookController();
	switch(choice)
	{
	case 1: aBController.doAdd(fileName);
	operationOnBook(fileName);
	break;
	case 2: aBController.doEdit(fileName);
	operationOnBook(fileName);
	break;
	case 3: aBController.doRemove(fileName);
	operationOnBook(fileName);
	break;
	case 4:AddressBookApplication.showOptions();
	default : System.out.println("No operation performed");
	}
}




/**
 * @throws ParseException 
 * @throws IOException 
 * @throws FileNotFoundException 
 * 
 */
public void doOpen() throws FileNotFoundException, IOException, ParseException
{
	viewBookList();
	JSONParser parser = new JSONParser();
	
	
	System.out.println("Enter the book number you want to open");
	int number = Utility.readInteger();
	
	
	
	String bookName=listOfAddressBook.get(number);
	String fileLocation = "/home/bridgelabz/Documents/sweta/BasicPrograms"
			+ "/Java Program/src/com/bridgelabz/objectoriented/"+bookName+".json";
	List<JSONObject> obj = (List<JSONObject>)parser.parse(new FileReader(fileLocation));
	Object object = null;
	try {
		object = parser.parse(new FileReader(fileLocation));
	}
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	catch (ParseException e)
	{
		e.printStackTrace();
	}
		JSONArray addressBookArray = (JSONArray)object; 
		for (Object obj1 : addressBookArray)
		{
			addressBookArray.add(obj1.toString());
		}
		
		AddressBookController.operationOnBook(bookName);
	
}




/**
 * 
 */
public void doDelete()
{
	System.out.println("Enter the Address Book you want to delete");
	int index = Utility.readInteger();
	listOfAddressBook.remove(index);
	Utility.toJSON(listOfAddressBook, "/home/bridgelabz/Documents/sweta/BasicPrograms/Java Program/src/listOfAddressBook.json");
	
	
}




/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public void doSave() throws FileNotFoundException, IOException, ParseException
{
	JSONParser parser = new JSONParser();
	Object object = parser.parse(new FileReader("/home/bridgelabz/Documents/sweta/BasicPrograms/Java Program/src/com/bridgelabz/objectoriented/AddressBook1.json"));
	JSONObject obj = (JSONObject)object;
	
}




/**
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
public static void doPrint(String fileName) throws FileNotFoundException, IOException, ParseException
{
	JSONParser parser = new JSONParser();
	Object object = parser.parse(new FileReader(fileName));
		JSONArray addressBookArray = (JSONArray)object; 
		System.err.println("      Name       Address     City     State     Zipcode    PhoneNumber");
		for(int i = 0 ; i < addressBookArray.size(); i++)
		{
			Person person=new Person();
			JSONObject objDetails = (JSONObject) (addressBookArray.get(i));
			person.setFirstName(objDetails.get("firstName").toString());
			person.setLastName(objDetails.get("lastName").toString());
			person.setAddress(objDetails.get("address").toString());
			person.setCity(objDetails.get("city").toString());
			person.setState(objDetails.get("state").toString());
			person.setZip(objDetails.get("zip").toString());
			person.setPhoneNumber(objDetails.get("phoneNumber").toString());
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Sl.No."+i);
			
			System.out.println(person.getFirstName()+" "+person.getLastName()+"  |  "+person.getAddress()+"  |  "+person.getCity()+
					"  |  "+person.getState()+"  |  "+person.getZip()+" | "+person.getPhoneNumber());
		}
		
		
}



/**
 * @throws ParseException 
 * @throws IOException 
 * @throws FileNotFoundException 
 * 
 */
public void createNew() throws FileNotFoundException, IOException, ParseException 
{
	//AddressBookController aBController = new AddressBookController();

	System.out.println("Enter the name of new address book");
	String book = Utility.readNext();
	String filePath = "/home/bridgelabz/Documents/sweta/BasicPrograms"
			+ "/Java Program/src/com/bridgelabz/objectoriented/"+book+".json";
	
	File file = new File(filePath);
	try
	{
		boolean fileCreated = file.createNewFile();
	if(fileCreated)
	{
		FileWriter fileWriter = new FileWriter(file);	
		fileWriter.write(filePath);
		fileWriter.close();
	System.out.println("New Address book created");
	listOfAddressBook.add(filePath);
	//System.out.println(listOfAddressBook);
	for (int i = 0; i < listOfAddressBook.size(); i++) 
	{
		System.out.println(listOfAddressBook.get(i));
		
	}

	
	Utility.toJSON(listOfAddressBook, "/home/bridgelabz/Documents/sweta/BasicPrograms"
			+ "/Java Program/src/listOfAddressBook.json");
	AddressBookController addressBook1 = new AddressBookController(filePath);
	System.out.println(listOfAddressBook);
	
	}
	}
	catch(IOException io)
	{
		io.printStackTrace();
	}
	//aBController.doAdd(filePath);
}


/**
 * @throws ParseException 
 * @throws IOException 
 * @throws FileNotFoundException 
 * 
 */
public void viewBookList() throws FileNotFoundException, IOException, ParseException
{
	listOfAddressBook = Utility.jsonToJavaAddressBookList("/home/bridgelabz/Documents/sweta/BasicPrograms"
			+ "/Java Program/src/listOfAddressBook.json");
	for (int i = 0; i < listOfAddressBook.size(); i++) 
	{
	System.out.println(i+"."+listOfAddressBook.get(i));	
	}
	//AddressBookApplication.showOptions();
	
}




/**
 * @return
 */
public int getAddressBooksize()
{
	return listOfAddressBook.size();
}
public void sortByName() 
{
	
	
}
public void sortByZip() {
	// TODO Auto-generated method stub
	
}
/**
 * to close multiple files
 * 
 */
public void quit() {
	System.out.println("Have A Nice Day");
	System.exit(0);
}
	

}









/*
	public void doSave(JSONArray jsonArray,String fileName) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("You want to Save this File!!!");
		System.out.println("1 - Enter to Save the Data");
		System.out.println("2 - Enter to Exit without saving");
		int key = Utility.readInteger();
		switch (key) {
		case 1:
		Utility.toJSON(object,"/home/bridgelabz/Documents/sweta/BasicPrograms/Java Program/src/com/bridgelabz/objectoriented/AddressBook1.json");
		System.out.println("Data hasbeen written");
		break;
		case 2:
		(fileName);
		break;
		default:
		System.err.println("Invalid Input");
		break;
		}
		}
*/
