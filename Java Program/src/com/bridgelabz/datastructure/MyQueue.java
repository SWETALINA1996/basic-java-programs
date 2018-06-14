/******************************************************************************
 *  
 *  Purpose:  Queue
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   25-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

public class MyQueue<T> {

	SingleLinkedList<T> singlelist = new SingleLinkedList<>();
	
	Node<T> rear = null;
	Node<T> front = null;
	int size = 0;
	
	public MyQueue()
	{
		
	}
	
	public void queue()
	{
		front = rear = null;
	}
	
	public int size()
	{
		return size;
	}
	
	public void enqueue(T item)
	{
		singlelist.addFront(item);
		size++;
	}
	
	
	 public T dequeue()
	    {
	        if(singlelist.isEmpty())
	        {
	            System.out.println("Queue is already empty");
	        }
	        T elementToBeDeleted=singlelist.get(0);
	        singlelist.remove(0);
	        return elementToBeDeleted;
	    }
/*	public void dequeue()
	{
		 
		singlelist.remove();
		size--;
	}
	*/
	public boolean isEmpty()
	{
		if(front == null )
			return true;
		else 
			return false;
	}

	public boolean search(T integer) {
		if(singlelist.search(integer)== true)
				{
			return true;
				}
		return false;
	}
	
	public String display()
	{
		return singlelist.toString();
	}
	
	public static void main(String[] args) {
	MyQueue queue = new MyQueue();
	queue.enqueue(8);
	queue.enqueue(3);
	queue.enqueue(6);
	queue.dequeue();
	
	System.out.println(queue.display());
	}

	
}
