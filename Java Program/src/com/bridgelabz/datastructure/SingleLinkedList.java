/******************************************************************************
 *  
 *  Purpose:  SingleLinkedList
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   25-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

public class SingleLinkedList<T> {

	private Node<T> head = null;
	private int size = 0;
	Node<T> tail;

	// creates String representation of nodes
	
	 public String toString() 
	 { String str = ""; 
	 Node<T> t = head;
	 while(t != null)  
	 {
	 str= str + t.data+ "--->"; t = t.next; 
	 }
	 return str;
	  
	 }
	 
/*
	// adds item to linked list
	public void add(T obj) {
		Node<T> newNode = new Node<T>(obj);
		if (head == null) {
			head = newNode;
			tail = head;
			size++;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		size++;
	}
*/
	// adds item to linked list
	public  void add(T obj) {
		Node<T> newNode = new Node<T>(obj);
		if (head == null) {
			head = newNode;
			tail = head;
			size++;
			return;
		}
		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		size++;
	}

	public void addFront(T obj) {
		Node<T> newNode = new Node<T>(obj);
		Node<T> current = head;
		head = newNode;
		newNode.next = current;
	}

	// removes items from the list
	public void removeElement(T obj) {
		Node<T> temp = null;
		Node<T> current = head;

		if (current != null && current.data.equals(obj)) {
			head = current.next;
			return;
		}
		while (current != null && !current.data.equals(obj)) {
			temp = current;
			current = current.next;
		}
		if (current == null)
			return;

		temp.next = current.next;

	}
	
/*	public T removeElementReturn(T obj) {
		Node<T> temp = null;
		Node<T> current = head;

		if (current != null && current.data.equals(obj)) {
			head = current.next;
			return current.data;
		}
		while (current != null && !current.data.equals(obj)) {
			temp = current;
			current = current.next;
		}
		if (current == null)
			return null;

		temp.next = current.next;
		return (T) current.data;

	}
*/
	// to search an item
	public boolean search(T item) {
		Node<T> current = head;

		while (current.next != null) {
			if (current.data.equals(item)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	
	public int searchIndex(T data) {
        if(head.data.equals(data)) {
            return 0;
        }
        Node temp=head;
        int count=0;
        while(temp.next!=null) {
            temp=temp.next;
            count++;
            if(temp.data.equals(data)) {
                System.out.println("word is present at : "+count);
                return count;
            }
        }
       return -1; 
    }


	
	
	

	// checks whether the string is empty
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;

	}
 
	// size of the list
	public int listSize() {
		Node<T> current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	/**
	 * @param index
	 * @return
	 */
	public T get(int index)
	{
		if(index >= listSize())
		{
			throw new IndexOutOfBoundsException();
		}
		Node<T> temp = head;
		for (int i = 0; i < index ; i++) {
			temp = temp.next;
		}
		return temp.data;
		
	}

	// append

	public void append(T obj) {
		Node<T> newNode = new Node<T>(obj);
		Node<T> current = head;

		while (current.next != null) {
			current = current.next;
		}
		if (current.next == null)
			current.next = newNode;
	}

	// position of item in the list****
	public int returnIndex(T item) {
		int index = 0;
		Node<T> current = head;

		while (current.next != null) {
			index++;
			if (current.data == item) {
				return index;
			} else
				current = current.next;

		}

		return -1;
	}

	// insert item at position
	public void insertItem(T obj, int pos) {
		Node<T> newNode = new Node<T>(obj);
		Node<T> temp = head;
		int index = 0;
		while (temp != null) {
			index++;
			if (index == pos) {
				break;
			}
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	// remove and return the last item in the list
	public void  remove() {
		Node<T> current = head;
		Node<T> temp = null;
		while (current.next != null) {
			temp = current;
			current = current.next;
		}
		if (current.next == null) {
			temp.next = current.next;
			
		}

	}

	 public T removeReturn()
	 {
		 Node<T> current = head;
		 Node<T> temp = null;
		 while(current.next != null )
			{
				temp = current;
				current = current.next;
			}
	  if(current.next == null)
		{
			temp.next = current.next;
		}
		 
		return (T) current;
		 
	 }
	public void removeFirst() {
		
		Node<T> temp = head;
		head = head.next;
		
	}


	public T removeFirstElement() {
		
		Node<T> temp = head;
		head = head.next;
		return temp.data;
		
	}

	// pop item from position
	public void remove(int index) {
	
		Node<T> temp = head;
		
		if(index >= listSize())
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(index == 0)
		{
			head = head.next;
			size--;
			return;
		}
		for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;

	}
	/*
	// pop item from position
		public void remove(int index) {
		//	Node<T> temp = null;
			Node<T> temp = head;
			
			//int index = 0;

			while (current.next != null && index != pos) {
				
				temp = current;
				current = current.next;
				index++;
			}

			if (current.next != null && index == pos) 
			{
				
				temp.next = current.next;
				
			}	
			if(current.next == null && index == pos)
			{
				temp.next = current.next;
			}

		}
	
	*/
	
	
	
	
	//to sort array
	public Comparable<T>[] sort(Comparable<T>[] array){
        for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array.length; j++) {
               if(array[i].compareTo((T)array[j])>0) {
                   Comparable<T> temp = array[j];
                   array[j]=array[i];
                   array[i]=temp;
               }
           }
       }
       return array;
    }
	
	
	public void display() {
		
		Node<T> temp= head;
		for(int i=1;i<=listSize()-1;i++) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		}
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.add(89);
		list.add(23);
		list.add(96);
		list.add(12);
		list.addFront(45);
		list.removeElement(96);
		list.remove();
		list.add(54);
		list.remove(1);
		
		System.out.println(list.toString());
		//System.out.println(ar);
	}

	
}
