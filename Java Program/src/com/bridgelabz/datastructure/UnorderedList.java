/******************************************************************************
 *  
 *  Purpose:  UnOrdered List
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   25-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.bridgelabz.utility.Utility;


public class UnorderedList {

	public static String[] fileReader() throws IOException {
		
		FileReader fileReader = new FileReader("/home/bridgelabz/message" );
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String str = bufferedReader.readLine();
		
		String []array=str.split(" ");
		
		return array;
	} 
	
	public static void main(String[] args) throws IOException {
		
		String[] stringArray = UnorderedList.fileReader();
		SingleLinkedList<String> singleList = new SingleLinkedList<String>();
		
		for(int i=0;i < stringArray.length; i++)
		{
			singleList.add(stringArray[i]);
		}
		singleList.toString();
		
		//prints the words of file
		System.out.println(singleList);
		System.out.println("Enter a word");
		String word = Utility.readNext();
	
		if(!singleList.search(word))
		{
			singleList.append(word);
			System.out.println(singleList);
		}
		
		else
		{
		singleList.removeElement(word);;
		System.out.println(singleList);
		}
	}
}
