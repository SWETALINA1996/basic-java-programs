package com.bridgelabz.datastructure;

import java.util.Queue;
import java.util.Random;

import com.bridgelabz.utility.Utility;

public class BankingCashCounter {
	
	public static void transaction(MyQueue queue)
	{
		System.out.println("Enter initial amount");
		Double amount = Utility.readDouble();
		
		System.out.println("Enter the maximum number of person in queue");
		Integer maxPerson = Utility.readInteger();
		Random rn = new Random();
		Integer noOfPerson = rn.nextInt(maxPerson);
		System.out.println(noOfPerson+ " person are added to queue");
		
		for(int i = 0 ;i < noOfPerson ; i++)
		{
			queue.enqueue(i);
		}
		 
		for(int i = 0 ;i < noOfPerson ; i++)
		{
			System.out.println("Enter 1 to deposit");
			System.out.println("Enter 2 to withdraw");
			int choice = Utility.readInteger();
			 switch(choice)
			 {
			 case 1 : System.out.println("Enter amount to be deposited");
			 double moneyDeposit = Utility.readDouble();
			 amount = amount + moneyDeposit;
			 queue.dequeue();
			 break;
			 
			 case 2 : System.out.println("Enter the amount to be withdrawn");
			 double moneyWithdraw = Utility.readDouble();
			 if(amount < moneyWithdraw)
			 {
				 System.out.println("Insufficient balance");
				 queue.dequeue();
			 }
			 else
			 {
				 amount = amount - moneyWithdraw;
				 queue.dequeue();
			 }
			 break;
			 
			 default : System.out.println("Wrong input");
			 break;
			 }
			 
			 System.out.println("Total money in account :" +amount);
		}
		
		
		
	}
}
