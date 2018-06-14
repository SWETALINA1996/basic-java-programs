package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class Calender {

	public static void main(String[] args) {
		
		
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		
		String[] months = {" ", "January" , "February" , "March", "April" , "May" , "June" , "July" ,
				"August" , "September" , "October" , "November" , "December"};
		
		int[] daysInMonth = {0 , 31, 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 ,31};
		
		if(month == 2 && Utility.leapYear(year))
			daysInMonth[month] = 29 ;
		
		String[] days = {"S " , "M " , "T " , "W " , "Th" , "F " , "S "};
		
	String calender [][] = new String [7][7];
	
	System.out.println(months[month]+" " + year);
	
	
	
	//to store days
	for(int i = 0 ; i < 7 ; i++)
	{
		calender[0][i] = days[i];
		
	}
	
	//to display days
	for(int i =0 ; i< 7 ; i++)
	{
		System.out.print(calender[0][i]+" ");
	}
	System.out.println();
	
	//to validate date and find on which day the month starts
	
	Utility.isValidDate(month, 1, year);
	int day = Utility.dayOfWeek(month, 1 , year);
	
	
	//Assigning space to each block
	for(int i = 0 ; i < 7 ; i++)
	{
		for(int j = 0 ; j < 7 ; j++)
		{
			calender[i][j] = " ";
		}
	}
	
	int date;
	
	
	//System.out.println(day);
	for(int i = 0 ; i < day ; i++)
	{
		System.out.print("   ");
	}
	for(date = 1; date <= daysInMonth[month] ; date++)
	{
		if(date < 10)
		{
			System.out.print(date+"  ");
		}
		else
		{
		System.out.print(date+" ");
		}
		if((date+day)%7 == 0 || date == daysInMonth[month])
		{
			System.out.println();
		}
	
	}
	
	}

}
