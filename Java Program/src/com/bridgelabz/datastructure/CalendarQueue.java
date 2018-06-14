/******************************************************************************
 *  
 *  Purpose:  Print Calender using queue
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   30-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class CalendarQueue {
	
	public static void main(String[] args) {
		
	MyQueue queueCalendar[][] = new MyQueue[6][7];
	for(int i = 0 ; i < 6 ; i++)
	{
		for (int j = 0; j < 7; j++) {
			queueCalendar[i][j] = new MyQueue();
		}
	}

	
	
	int month = Integer.parseInt(args[0]);
	int year = Integer.parseInt(args[1]);
	
	String[] months = {" ", "January" , "February" , "March", "April" , "May" , "June" , "July" ,
			"August" , "September" , "October" , "November" , "December"};
	
	int[] daysInMonth = {0 , 31, 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 ,31};
	
	if(month == 2 && Utility.leapYear(year))
		daysInMonth[month] = 29 ;
	
	String[] days = {"S  " , "M  " , "T  " , "W  " , "Th " , "F  " , "S  "};
	
	System.out.println(months[month]+" " + year);

String calender [][] = new String [7][7];


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
for(int i = 0 ; i < 6 ; i++)
{
	for(int j = 0 ; j < 7 ; j++)
	{
		queueCalendar[i][j].enqueue(" ");
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
     for(int i = 0 ; i < 6 ; i++)
     {
         if(i == 0 )
         {
             for(int k = 0 ; k < day ; k++)
             {
                 queueCalendar[i][j].enqueue("   ");
                 j++;
             }
         }
         for(j = day ; j < 7 ; j++)
         {    
             
             if(dateCount <= daysInMonth[month])
             {
                 if(dateCount <= 9)
                 {
                     queueCalendar[i][j].enqueue(dateCount+"  ");
                     dateCount++;
                    
                 }
                 else
                 {
                     queueCalendar[i][j].enqueue(dateCount+" ");
                     dateCount++;
                   
                 }
             }
             
         }
         
         day = 0;
       
     }
  //   Utility.displayArray(queueCalendar);
     for(int i = 0 ; i < 6 ; i++)
     {
    	 for(int m = 0 ; m < 7 ; m++)
    	 {
    		 queueCalendar[i][m].display();
    	 }
    	 System.out.println();
     }
 }
 else
 {
     System.out.println("Enter valid inputs");
     return;
 }	


}

}


/*

public class CalendarQueue {
    
    public static int leapYearCondition(Integer year,Integer dayOfMonth) {
        if(Utility.leapYear(year)==true) {
            dayOfMonth=29;
        }
        else {
            dayOfMonth=28;
        }
        return dayOfMonth;
    }
    /**
     * Function is to findout the first day of month.
     * @param month
     * @param year
     */
/*    public static void firstDayOfMonth(Integer month,Integer year) {
            MyQueue weekDay=new MyQueue();
        
            Integer []date1= {0,31,28,31,30,31,30,31,31,30,31,30,31};
            date1[2]=leapYearCondition(year, month);
            
            Integer date=1;
            String dayOfMonth=Utility.dayOfWeek(month, date, year);
            String []day= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
            for (int i = 0; i < day.length; i++) {
                weekDay.enqueue(day[i]);
            }
            
            Integer position=0;
            
            for (int i = 0; i < day.length; i++) {
                if(dayOfMonth.equals(day[i])) {
                    position=position+i;
                }
            }
            
          // Array to store the months of an year.
            String[] months= {"","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE",
                        "JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
            for (int i = 0; i < months.length; i++) {
                if(month==i) {
                    System.out.println("  "+months[i]+"   "+year);
                }
            }
            weekDay.display();
             
            MyQueue array=new MyQueue();
            int dateValue=0;
            for (int k = 0; k < date1.length; k++) {
                if(month==k) {
                dateValue=dateValue+date1[k];
                int datePrint=1;
                for (int i = 0; i < dateValue; i++) {
                    if(datePrint<=dateValue) {
                        array.enqueue(datePrint);
                    }
                    datePrint++;
                }
            }
        }
        for (int i = 0; i < position; i++) {
            System.out.println();
            System.out.print("       ");
        }
        for (int i = 1; i <= dateValue; i++) {
            if (i < 10)
                System.out.print("  0" + i);
            else
                System.out.print("  " + i);
            if (((i + position) % 7 == 0) || (i == dateValue))
                System.out.println();

        }
    }
    
    public static void main(String[] args) {
        firstDayOfMonth(2, 2000);
    }
}*/

