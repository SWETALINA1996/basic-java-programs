package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.utility.Utility;

public class Hashing {
	
	public static String[] fileReader() throws IOException {
		
		FileReader fileReader = new FileReader("/home/bridgelabz/sweta/numbers" );
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String str = bufferedReader.readLine();
		
		String []array=str.split(",");
	
		
		return array;
	} 
	
	public static void main(String[] args) throws IOException {
		
		SingleLinkedList singlelist = new SingleLinkedList();
		
		String[] stringArray = Hashing.fileReader();
		for(int i = 0; i < stringArray.length ; i++)
		{
			singlelist.add(Integer.parseInt(stringArray[i]));
		}
		
		System.out.println("List is: ");
		System.out.println(singlelist.toString());
		
		SingleLinkedList[] myArray = new SingleLinkedList[11];
		
		for(int i = 0; i < myArray.length ; i++)
		{
			myArray[i] = new SingleLinkedList();
		}
		 
		int size = singlelist.listSize();
		//System.out.println(size);
		
		for (int i = 0; i < size-1; i++) 
		{
			Integer item = (Integer)singlelist.removeFirstElement();
			//System.out.println(item);
			Integer index = item % 11;
			System.out.println(index);
			myArray[index].add(item);	
		}
		String content= "";
	
		
		for (int i = 0; i < myArray.length; i++) {
			System.out.println("Index "+ i +" : "+myArray[i]);
		}
		
		for (int i = 0; i < myArray.length; i++) 
		{
			for (int j = 0; j < myArray[i].listSize(); j++) {
				content = myArray[i].get(j)+",";
				System.out.print(myArray[i].get(j)+" ");
			}
		System.out.println();
			
		}
	//  Utility.writeFile("/home/bridgelabz/sweta/numbers" ,content );
	
	}
	
	
}
