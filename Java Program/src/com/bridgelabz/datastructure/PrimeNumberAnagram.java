package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class PrimeNumberAnagram {
	   public static void main(String[] args)
	    {
	       SingleLinkedList<Integer> mylinkedlist=new SingleLinkedList<Integer>();
	        MyQueue<Integer> distinctAnagram=new MyQueue<Integer>();
	        MyQueue<Integer> distinctNonAnagram=new MyQueue<Integer>();
	        for(int i=0;i<=1000;i++)
	        {
	            if(Utility.findPrime(i))
	            {
	                mylinkedlist.add(i);
	            }
	        }

	       // int size = mylinkedlist.listSize();
	        for(int i=0;i<mylinkedlist.listSize()-1;i++)
	        {
	            for(int j=i+1;j<mylinkedlist.listSize();j++)
	            {
	                if(Utility.numAnagramCheck(mylinkedlist.get(i),mylinkedlist.get(j)))
	                {

	                    if(distinctAnagram.search(mylinkedlist.get(i))==false)
	                    {
	                        distinctAnagram.enqueue(mylinkedlist.get(i));
	                    }
	                    if(distinctAnagram.search(mylinkedlist.get(j))==false)
	                    {
	                        distinctAnagram.enqueue(mylinkedlist.get(j));
	                    }
	                }
	                else
	                {
	                    if(distinctNonAnagram.search(mylinkedlist.get(i))==false && distinctAnagram.search(mylinkedlist.get(i))==false)
	                    {
	                        distinctNonAnagram.enqueue(mylinkedlist.get(i));
	                    }
	                    if(distinctNonAnagram.search(mylinkedlist.get(j))==false && distinctAnagram.search(mylinkedlist.get(j))==false)
	                    {
	                        distinctNonAnagram.enqueue(mylinkedlist.get(j));
	                    }
	                }
	            }
	        }
	        /*System.out.println("Anagram numbers are");
	        distinctAnagram.display();
	        System.out.println();
	        System.out.println("Non anagram numbers are");
	        distinctNonAnagram.display();*/
	        Integer[][] array=new Integer[2][distinctNonAnagram.size()];
	        int anagramQueueSize=distinctAnagram.size();
	        for(int i=0;i<anagramQueueSize;i++)
	        {
	            array[0][i]=distinctAnagram.dequeue();
	        }
	        int nonAnagramQueueSize=distinctNonAnagram.size();
	        for(int j=0;j<nonAnagramQueueSize;j++)
	        {
	            array[1][j]=distinctNonAnagram.dequeue();
	        }
	        System.out.println();
	        System.out.println("Array elements are:");
	        System.out.println("first row shows anagram numbers and second row shows non anagram numbers");
	        Utility.displayNumberArray(array);
	        /*System.out.println("Anagram numbers are");
	        distinctAnagram.display();
	        System.out.println();
	        System.out.println("Non anagram numbers are");
	        distinctNonAnagram.display();*/
	    }
}
