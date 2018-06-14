package com.bridgelabz.algorithms;

import java.io.IOException;
import java.util.Arrays;

import com.bridgelabz.utility.Utility;

public class SearchWordlist {

	public static void main(String[] args) throws IOException {
		
        String[] stringArray=Utility.fileReader();
        System.out.println("Sorting the String first");
        Arrays.sort(stringArray);
        for(int i=0;i<stringArray.length;i++)
        {
            System.out.println(stringArray[i]);
        }
        System.out.println("Enter the word you want to search");
        String element= Utility.readNextLine();
      int index = Utility.binarySearch(stringArray, element,0,stringArray.length-1);
      System.out.println("present in index" +index);
        

	}

}

