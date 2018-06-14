package com.bridgelabz.objectoriented;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;


public class AddressBook
{
List<Person> personList = new ArrayList<Person>();
//PersonPojo personList = new PersonPojo();

Person.CompareByName compareByName = new Person.CompareByName();
Person.CompareByZip compareByZip = new Person.CompareByZip();

//Person p = new Person();
 /**
 * 
 */
AddressBook()
{
	
}

 /**
 * @return
 */
public int numberOfPerson()
 {
	 return personList.size();
 }
 
 /**
 * @param firstName
 * @param lastName
 * @param address
 * @param city
 * @param state
 * @param phoneNumber
 * @param zip
 * @throws ParseException 
 * @throws IOException 
 * @throws FileNotFoundException 
 */
List<Person> addPerson(String firstName,  String lastName , String address , String city , String state, String phoneNumber , String zip) throws FileNotFoundException, IOException, ParseException
 {
	
	 Person person = new Person(firstName, lastName, address, city, state, phoneNumber, zip);
	 personList.add(person);
	 return personList;
	 
 }

 /**
 * @param index
 * @return
 */
public String getFullNameOfPerson(int index)
 {
     return (personList.get(index).getFirstName()+personList.get(index).getLastName());
 }

/**
 * @param index
 */
public String[] getOtherPersonInformation(int index)
{
	String getInfo[] = new String[5];
	getInfo[0] = personList.get(index).getAddress();
	getInfo[1] = personList.get(index).getCity();
	getInfo[2] = personList.get(index).getState();
	getInfo[3] = personList.get(index).getZip();
	getInfo[4] = personList.get(index).getPhoneNumber();
	return getInfo;
}

/**
 * @param index
 * @return 
 * @throws IOException 
 * @throws JsonMappingException 
 * @throws JsonGenerationException 
 */
public List<Person> removePerson(int index) throws JsonGenerationException, JsonMappingException, IOException
{
personList.remove(index);	
return personList;
}
/**
 * @param address
 * @param city
 * @param state
 * @param zip
 * @param phoneNumber
 */
public void updatePerson(int index , String address ,String city ,String state ,String zip ,String phoneNumber)
{
	personList.get(index).setAddress(address);
	personList.get(index).setCity(city);
	personList.get(index).setState(state);
	personList.get(index).setZip(zip);
	personList.get(index).setPhoneNumber(phoneNumber);
}

/**
 * 
 */
public void printAll()
{
	for (int i = 0; i < personList.size(); i++)
	{
	System.out.println(personList.get(i).toString());	
	System.out.println();
	}
}

 /**
 * 
 */
public void sortByName()
 {
	 for (int i = 0; i < personList.size(); i++) 
	 {
	for (int j = i+1 ; j < personList.size(); j++)
	{
		if(compareByName.compare(personList.get(i), personList.get(j)) > 0)
		{
			Person temp = personList.get(i);
			personList.set(i,personList.get(j));
			personList.set(j,temp);
		}
		//  else if(personList.get(i) , )
	}	
	}
 }
 /**
 * 
 */
public void sortByZip()
 {
	 for (int i = 0; i < personList.size(); i++) 
	 {
	for (int j = i+1 ; j < personList.size(); j++)
	{
	 if(compareByZip.compare(personList.get(i), personList.get(j))>0)
	 {

			Person temp = personList.get(i);
			personList.set(i,personList.get(j));
			personList.set(j,temp);
	 }
	}	
	}
 }
/*
public String toString()
{
	String str = "";
	str = str + p.getFirstName() + " | " + p.getLastName() + " | " +p.getAddress() + " | "+ p.getCity() + " | "
			+ p.getState() + " | " +p.getZip() +" | " + p.getPhoneNumber() + " | ";
	return str;
}
 */
 
}
