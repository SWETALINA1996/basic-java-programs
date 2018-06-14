package com.bridgelabz.objectoriented;

import java.util.Comparator;

public class Person
{
private String firstName;
private String lastName;
private String address;
private String city;
private String state;
private String zip;
private String phoneNumber;


public String getFirstName() 
{
	return firstName;
}
public void setFirstName(String firstName)
{
	this.firstName = firstName;
}
public String getLastName()
{
	return lastName;
}
public void setLastName(String lastName)
{
	this.lastName = lastName;
}
public String getAddress()
{
	return address;
}
public void setAddress(String address)
{
	this.address = address;
}
public String getCity()
{
	return city;
}
public void setCity(String city) 
{
	this.city = city;
}
public String getState()
{
	return state;
}
public void setState(String state)
{
	this.state = state;
}
public String getZip()
{
	return zip;
}
public void setZip(String zip)
{
	this.zip = zip;
}
public String getPhoneNumber() 
{
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber)
{
	this.phoneNumber = phoneNumber;
}

Person()
{
	
}
/**
 * @param firstName
 * @param lastName
 * @param address
 * @param city
 * @param state
 * @param phoneNumber
 * @param zip
 */
Person(String firstName, String lastName , String address , String city , String state, String phoneNumber , String zip)
{
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.city = city;
	this.state = state;
	this.phoneNumber = phoneNumber;
	this.zip = zip;
	
}

/**
 * @param address
 * @param city
 * @param state
 * @param zip
 * @param phoneNumber
 */
public void update(String address ,String city ,String state ,String zip ,String phoneNumber)
{
	this.address = address;
	this.city = city;
	this.state = state;
	this.zip = zip;
	this.phoneNumber = phoneNumber;
}


/**
 * @author bridgelabz
 *
 */
public static class CompareByName implements Comparator<Person>
{

	@Override
	public int compare(Person person1, Person person2)
	{
			int compareByLastName = ((Person) person1).getLastName().compareTo(((Person) person2).getLastName());
			if (compareByLastName != 0)
				return compareByLastName;
			else
				return ((Person) person1).getFirstName().compareTo(((Person) person2).getFirstName());
		}
	
}

	

/**
 * @author bridgelabz
 *
 */
public static class CompareByZip implements Comparator<Person>
{

	@Override
	public int compare(Person person1, Person person2)
	{
		int compareByZip = ((Person) person1).getZip().compareTo(((Person) person2).getZip());
		if(compareByZip != 0)
			return compareByZip;
		else 
			return ((Person) person1).getFirstName().compareTo(((Person) person2).getFirstName());	
	}
	
}


}
