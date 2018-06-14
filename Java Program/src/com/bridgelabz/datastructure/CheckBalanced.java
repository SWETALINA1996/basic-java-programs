package com.bridgelabz.datastructure;

public class CheckBalanced {
	
	public static boolean isBalanced(String str)
	{
	    char ch[] = str.toCharArray();
		
		MyStack<Character> stack = new MyStack<Character>();
		for(int i = 0; i < ch.length ; i++)
		{
			if(ch[i] == '{' || ch[i] == '[' || ch[i] == '(')
			{
				stack.push(ch[i]);
				System.out.println(stack);
			}
			else 
			
				if(stack.isEmpty())
					return false;
				else
				{
			switch(ch[i])
			{
			case '}' : if(stack.pop()!= '{')
				     return false;
			         break;
			         
			case ']' : if(stack.pop()!= '[')
			          return false;
		               break;
		               
			case ')' : if(stack.pop()!= '(')
			           return false;
		               break;
		               
		    default : return false;
				}
				}
			}
		
		return stack.isEmpty();
		
	}
}
