/******************************************************************************
 *  
 *  Purpose:  Calender
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   29-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class Calendar {
	
	public static void main(String[] args) {
		
		
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		
		String[] months = {" ", "January" , "February" , "March", "April" , "May" , "June" , "July" ,
				"August" , "September" , "October" , "November" , "December"};
		
		int[] daysInMonth = {0 , 31, 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 ,31};
		
		if(month == 2 && Utility.leapYear(year))
			daysInMonth[month] = 29 ;
		
		String[] days = {"S  " , "M  " , "T  " , "W  " , "Th " , "F  " , "S  "};
		
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
	
	
	//Assigning space to each block
	for(int i = 0 ; i < 7 ; i++)
	{
		for(int j = 0 ; j < 7 ; j++)
		{
			calender[i][j] = " ";
		}
	}
	
	 int date = 1;
	 
	//to validate date and find on which day the month starts
	if(Utility.isValidDate(month, date, year)==true)
     {
         int day = Utility.dayOfWeek(month,date,year);
      
         System.out.println();
         int dateCount = 1;
         int j = 0;
         for(int i = 0 ; i < calender.length ; i++)
         {
             if(i == 0 )
             {
                 for(int k = 0 ; k < day ; k++)
                 {
                     calender[i][j] = "   ";
                     j++;
                 }
             }
             for(j = day ; j < calender[i].length ; j++)
             {    
                 
                 if(dateCount <= daysInMonth[month])
                 {
                     if(dateCount <= 9)
                     {
                         calender[i][j] = dateCount+"  ";
                         dateCount++;
                        
                     }
                     else
                     {
                         calender[i][j] = dateCount+" ";
                         dateCount++;
                       
                     }
                 }
                 
             }
             
             day = 0;
           
         }
         Utility.displayArray(calender);
     }
     else
     {
         System.out.println("Enter valid inputs");
         return;
     }
}
}
