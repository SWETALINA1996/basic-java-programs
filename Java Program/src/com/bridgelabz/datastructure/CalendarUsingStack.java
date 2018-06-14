package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class CalendarUsingStack {
	 public static void main(String[] args) {
	        int month = Integer.parseInt(args[0]);
	        int year = Integer.parseInt(args[1]);
	        MyStack first[][] = new MyStack[6][];
	        for (int i = 0; i < 6; i++) {
	            first[i] = new MyStack[7];
	            for (int j = 0; j < 7; j++) {
	                first[i][j] = new MyStack();
	            }
	        }
	        MyStack a[][] = new MyStack[6][];
	        for (int i = 0; i < 6; i++) {
	            a[i] = new MyStack[7];
	            for (int j = 0; j < 7; j++) {
	                a[i][j] = new MyStack();
	            }
	        }
	        int day = 1;
	        String[] months = { " ", "January", "February", "March", "April", "May", "June", "July", "August", "September",
	                "October", "November", "December" };
	        String[] days = { " S", " M", " T", " W", "Th", " F", " S" };
	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 7; j++) {
	                first[i][j].push("  ");
	            }
	        }

	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 7; j++) {
	                if (Utility.isValidDate(month, 1, year)) {
	                    j = Utility.dayOfWeek(month, day, year);
	                    if (day < 10) {
	                        first[i][j].push(" " + day);
	                        day++;
	                    } else {
	                        first[i][j].push("" + day);
	                        day++;
	                    }
	                }
	            }
	        }

	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 7; j++) {
	                a[i][j].push(first[i][j].pop());
	            }
	        }
	        System.out.println(months[month] + " " + year);
	        System.out.println();
	        for (int i = 0; i < 7; i++) {
	            System.out.print(days[i] + "  ");
	        }
	        System.out.println();
	        for (int x1 = 0; x1 < 6; x1++) {
	            for (int y1 = 0; y1 < 7; y1++) {
	                System.out.print(a[x1][y1].pop() + "  ");
	            }
	            System.out.println();
	        }

	    }

}
