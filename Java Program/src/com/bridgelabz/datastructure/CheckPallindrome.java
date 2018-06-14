package com.bridgelabz.datastructure;


public class CheckPallindrome {

	public static boolean isPallindrome(String string)
	{
		char ch[] =  string.toCharArray();
		
		Deque<Character> deque = new Deque<Character>();
		
		for(int i = 0; i < ch.length ; i++)
		{
			deque.addFront(ch[i]);
			//deque.display();
			System.out.println(ch[i]);
		}   
		
		int size = deque.size();
		
		for(int i = 0 ; i < size/2 ; i++)
		{
		if(deque.removeFront().equals(deque.removeRear()))
		{
			return true;
		}
		
		}
		return false;
	}
}
