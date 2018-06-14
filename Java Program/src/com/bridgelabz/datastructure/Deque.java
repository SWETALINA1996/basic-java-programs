/******************************************************************************
 *  
 *  Purpose:  Deque
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   26-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;


public class Deque<T> {
	
	SingleLinkedList<T> singleLinkedList = new SingleLinkedList<>();
	
	Node<T> rear;
	Node<T> front;

	
	public boolean isEmpty()
	{
		return singleLinkedList.isEmpty();
	}
	
	public int size() 
	{
		return singleLinkedList.listSize();
	}
	public void addFront(T item)
	{
		singleLinkedList.addFront(item);
		
	}
	
	public void addRear(T item)
	{
		singleLinkedList.add(item);
		
	}
	
	public T removeFront()
	{	T data = null;
		if(isEmpty())
		{
			System.out.println("Underflow");
		}
			
		else {
			data = singleLinkedList.get(0);
			singleLinkedList.remove(0);
		}
	return data;
		
	}

	public T removeRear()
	{
		 //singleLinkedList.remove();
		T data = null;
		if(singleLinkedList.isEmpty())
		{
			System.out.println("");
		}
		else {
			int index = singleLinkedList.listSize()-1;
			data = singleLinkedList.get(index);
			singleLinkedList.remove(index);
		}
		return data;
		
	}
	public String display()
	{
		return singleLinkedList.toString();
	}
	
	public static void main(String[] args) {
		Deque deque = new Deque();
		deque.addFront(3);
		deque.addFront(6);
		deque.addRear(8);
		deque.addRear(9);
		deque.removeFront();
		deque.removeRear();
		deque.addFront("world");
		
		
		
		System.out.println(deque.display());
		System.out.println(deque.size());
	}
}


