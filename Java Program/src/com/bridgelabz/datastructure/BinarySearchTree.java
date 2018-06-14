package com.bridgelabz.datastructure;
import com.bridgelabz.utility.*;

public class BinarySearchTree {
	public static void main(String[] args) {
		
	   System.out.println("Number of test cases  ");
	   
       int testCase=Utility.readInteger();
       int[] result=new int [testCase];
       for(int i=0;i<testCase;i++)
       {
           System.out.println("Enter number of nodes");
           int nodes=Utility.readInteger();
           result[i]=Utility.countTree(nodes);            
       }
       for(int i=0;i<result.length;i++)
       {
           System.out.println("number of binary search tree : "+result[i]);
       } 
}

}
