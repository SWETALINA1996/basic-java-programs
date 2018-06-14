package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class CalendarUsingQueue {
	public static void main(String[] args) {
	    int month=Integer.parseInt(args[0]);
	    int year=Integer.parseInt(args[1]);
	  MyQueue[][] a=new MyQueue[6][];
	    for(int i=0;i<6;i++)
	    {
	        a[i]=new MyQueue[7];
	        for(int j=0;j<7;j++)
	        {
	            a[i][j]=new MyQueue();
	        }
	    }
	    int day=1;
	    String[] months = {"","January", "February", "March","April", "May", "June",
	        "July", "August", "September","October", "November", "December"};

	    String[] days = {" S"," M"," T"," W","Th"," F"," Sa"};
	    for(int i=0;i<6;i++) {
	        for(int j=0;j<7;j++)
	        {
	            a[i][j].enqueue("  ");
	        }
	    }
	    for(int i=0;i<6;i++) {
	        for(int j=0;j<7;j++)
	        {
	            if(Utility.isValidDate(month, 1, year))
	            {
	                j=Utility.dayOfWeek(month, day, year);
	                if(day<10)
	                {
	                    a[i][j].dequeue();
	                    a[i][j].enqueue(" "+day);
	                    day++;
	                }
	                else
	                {
	                    a[i][j].dequeue();
	                    a[i][j].enqueue(""+day);
	                    day++;
	                }
	                
	            }
	        }
	    }
	    System.out.println(months[month]+" "+year);
	    System.out.println("");
	    for(int i=0;i<7;i++)
	    {
	        System.out.print(days[i]+" ");
	    }
	    System.out.println();
	    for(int i=0;i<6;i++)
	    {
	        for(int j=0;j<7;j++)
	        {
	            System.out.print(a[i][j].dequeue()+" ");
	        }
	        System.out.println();
	    }
	}
}
