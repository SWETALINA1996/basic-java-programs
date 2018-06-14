/******************************************************************************
 *  
 *  Purpose:  Stack
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   25-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

public class MyStack<T> {

	 Node<T> top=null;
	static Integer capacity=0;
	
	
	/**
	 * @param obj
	 * @return
	 */
	public <T>void push(T obj)
	{
		Node node = new Node(obj);
		node.next = top;
		top = node;
	
		
	}
	/**
	 * @return
	 */
	public  T pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack underflow");
		}
		T temp = (T) top.data;
		top = top.next;
		capacity--;
		return temp;
	}
	
	
	/**
	 * @return
	 */
	public int size()
	{
		return capacity;
	}
	
	/**
	 * @return
	 */
	public boolean isEmpty()
	{
		return top == null;
	}
	/**
	 * @return
	 */
	public T peek()
	{
		T temp = (T) top.data;
		if(isEmpty())
		{
			System.out.println("Stack overflow");
		}
		return temp;
	}
	
	public  String toString()
	{
		String str = "[";
		Node temp = top;
		while(temp != null)
		{
			str = str + temp.data +",";
			temp = temp.next;
		}
		return str + "]";
	}
	
	
public static void main(String[] args) {
	MyStack stack = new MyStack();
	stack.push(5);
	stack.push("abc");
	stack.push(7);
	System.out.println(stack);
	stack.pop();
	System.out.println(stack);
}
}
