package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

class WeekDaysForStack
{
    String[] days= {"S ","M ","T ","W ","TH","F ","S   "};
    Integer[] dates= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
}
public class CalendarStack
{

    public static void main(String[] args) 
    {
        String[] months= {" ","January","February","March","April","May","June","July","August","September","October","November","December"};
        int[] daysInMonth = {0 , 31, 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 ,31};
        MyStack<String> queueDays=new MyStack<>();
      
        MyStack<Integer> queueDates=new MyStack<>();
       
        MyStack<String> calender=new MyStack<>();
        WeekDays weekdays=new WeekDays();
        for(int i=0;i<weekdays.days.length;i++)
        {
            queueDays.push(weekdays.days[i]);
        }
        for(int i=0;i<weekdays.dates.length;i++)
        {
            queueDates.push(weekdays.dates[i]);
        }
        int date=1;
        int month=Integer.parseInt(args[0]);
        int year=Integer.parseInt(args[1]);
        Integer[] daysInMonths= {0,31,28,31,30,31,30,31,31,30,31,30,31};
       

        if(month == 2 && Utility.leapYear(year))
			daysInMonth[month] = 29 ;
		
        if(Utility.isValidDate(date, month, year)==true)
        {
            int day=Utility.dayOfWeek(date, month, year);
            int tillDate=daysInMonths[month];
            int count=1;
            int j=0;
            System.out.println("    "+months[month]+" "+year);
            queueDays.toString();
            System.out.println();
            System.out.println();
            for(int i=0;i<6;i++)
            {
                if(i==0 )
                {
                    for(int k=0;k<day;k++)
                    {
                        ///System.out.print("   ");
                        calender.push("   ");
                        j++;
                    }
                }
                for(j=day;j<7;j++)
                {    
                    
                    if(count<=tillDate)
                    {
                        if(count<=9)
                        {
                            ///System.out.print(weekdays.dates[count]+"  ");
                            calender.push(count+"  ");
                            count++;
                        }
                        else
                        {
                            ///System.out.print(weekdays.dates[count]+" ");
                            calender.push(count+" ");
                            count++;
                        }
                    }
                    
                }
                day=0;
                ///System.out.println();
            }
        }
        else
        {
            System.out.println("Invalid month or year given");
            return;
        }
        while(calender.size()!=0)
        {
            for(int i=0;i<7;i++)
            {
                System.out.print(calender.pop());
            }
            System.out.println();
        }
    }

}


