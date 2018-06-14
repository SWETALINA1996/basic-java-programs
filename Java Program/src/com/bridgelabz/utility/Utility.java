package com.bridgelabz.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.datastructure.SingleLinkedList;

public class Utility {
	static Scanner scanner = new Scanner(System.in);


	/*
	 * number variable stores the number entered by the user as the input
	 */
	public static int readInteger() {
		int number = scanner.nextInt();
		return number;
	}

	/**
	 * @return double value
	 */
	public static double readDouble() {
		double number = scanner.nextDouble();
		return number;
	}


	/**
	 * @return boolean value
	 */
	public boolean readBoolean() {
		boolean bool = scanner.nextBoolean();
		return bool;
	}

	/**
	 * @return
	 */
	public static long readLong()
	{
		long number = scanner.nextLong();
		return number;
	}

	/*
	 * String variable stores the String entered by the user as the input
	 */
	public static String readNext() {
		String str = scanner.next();
		return str;
	}

	/*
	 * String variable stores the String entered by the user as the input
	 */
	public static String readNextLine() {
		String str = scanner.nextLine();
		return str;
	}
	/**
	 * @param length
	 * @return
	 */
	public Integer[] readIntArray(int length)
	{
		Integer [] array = new Integer[length];
		for(int i=0; i<length; i++)
		{
			array[i]=Utility.readInteger();	
		}
		return array;
	}
	/**
	 * @param length
	 * @return
	 */
	public int[] readArray(int length)
	{
		int[] array = new int[length];
		for(int i=0; i<length; i++)
		{
			array[i]=Utility.readInteger();	
		}
		return array;
	}
	/**
	 * @param length
	 * @return
	 */
	public String[] readStringArray(int length)
	{
		String[] array = new String[length];
		for(int i=0; i<length; i++)
		{
			array[i]=Utility.readNext();	
		}
		return array;
	}

	
	/**
	 * @param input
	 * @return
	 */
	public String replace(String input)
	{

		String s="Hello <<username>>, How are you?";
		String str=s.replaceAll("<<username>>",input);
		return str;
	}


	/*
	 * leapYear method checks the year entered by user is leap year or not
	 */
	public static boolean leapYear(int year)
	{

		if(year >= 1000 && year <= 9999){

			//checks the condition for leap year

			if(year%400 == 0||(year % 4 == 0 && year % 100 != 0))
				return true;
			else 
				return false;
		}

		else 
			System.out.println("enter a valid year ");
		return false;
	}



	/**
	 *  gamblerGame method calculates the win and loss percent
	 */
	public static void gamblerGame()
	{
		int noOfTimes = readInteger();
		System.out.println("Enter the Stake value");
		int mStake = readInteger();
		System.out.println("Enter the Goal value");
		int mGoal = readInteger();
		int mWin = 0; int mLoss = 0;

		for(int i = 0;i < noOfTimes;i++)
		{
			//random function generates random number
			if(Math.random() < 0.5)
			{
				mLoss++;
				mStake = mStake-1;
			}
			else {
				mWin++;
				mStake = mStake+1;
			}
			if(mStake == mGoal || mStake == 0)
			{
				break;
			}

		}
		System.out.println("Number of wins"+ mWin);
		double winPercent=(double)(mWin*100)/noOfTimes;
		System.out.println("Percentage of win"+winPercent);
		double lossPercent=(double)(mLoss*100)/noOfTimes;;
		System.out.println("Percentage of loss"+lossPercent);

	}



	/**
	 *  
	 *  twoDArray method prints 2D array for integer , double or boolean  
	 */
	public static void twoDArray() {
		System.out.println("Enter the number of rows");
		int m=readInteger();
		System.out.println("Enter the number of columns");
		int n=readInteger();
		int arr[][]=new int[m][n];
		System.out.println("Enter"+(m*n)+"inputs");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				arr[i][j]=readInteger();
			}
		}
		System.out.println("The two dimensional array is:");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	public static void displayArray(String array[][])
	{
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void displayNumberArray(Integer array[][])
	{
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}



	/*
	 * addsToZero method checks the distinct integer that adds to zero
	 */

	public static void addsToZero()
	{
		int n=readInteger();
		int sum=0; 
		int count=0;
		int ar[]=new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
		{
			ar[i]=readInteger();
		}
		for(int i=0;i<ar.length;i++)
		{
			for(int j=i+1;j<ar.length;j++)
			{
				for(int k=j+1;k<ar.length;k++)
				{
					sum= ar[i]+ar[j]+ar[k];
					if(sum==0) {
						count++;
						System.out.println(ar[i]+","+ar[j]+","+ar[k]);
					}
				}
			}
		}
		System.out.println("Distinct Triplets are: "+count);
	}



	/**
	 * Calculates the elapsed time
	 * @param choice : 
	 */
	public static void findElapsedTime(int choice) {
		long startTime =0;
		long endTime=0;
		int flag=0;
		while(flag==0) {
			switch(choice) {
			case 1 : startTime = System.nanoTime(); // Get the current system time in nano second.
			System.out.println("Press 0 to stop the Stopwatch");
			choice=Utility.readInteger();
			break;

			case 0 : endTime = System.nanoTime();   // Get the current system time in nano second.
			flag=1;
			}
		}
		System.out.println("Start time is : "+startTime);
		System.out.println("End time is : "+endTime);
		System.out.println("Elapsed Time is : "+ (endTime - startTime)*Math.pow(10,-9));
		
	}


	/*
	 * calculateDistance method calculates the distance of co-ordinate from origin(0,0)
	 */

	public void calculateDistance(int firstInteger, int secondInteger) {
		double euclideanDistance = Math.sqrt((Math.pow(firstInteger,2)+
				Math.pow(secondInteger,2)));
		System.out.println("Calculated Euclidean Distance is: "+euclideanDistance);

	}



	/**
	 * this method calculates the percent of head count and tail count
	 * @param noOfFlip : number of times user wants to flip the coin
	 */
	public void percentOfFlip(int noOfFlip) {
		int head=0, tail=0;
		double headPercent, tailPercent;

		for (int i = 0; i < noOfFlip; i++) {

			if(Math.random()<0.5) {
				tail++;
			}
			else {
				head++;
			}

		}
		headPercent = (head*100)/noOfFlip;;
		tailPercent = (tail*100)/noOfFlip;;

		System.out.println("Head percentage is :"+ headPercent);
		System.out.println("Tail percentage is :"+ tailPercent);

	}

	/**
	 * @param number takes the number upto which the power of two will be calculated
	 */
	public void findPowerOfTwo(int number) {
		int mOutput=1;
		
		for (int i = 0; i <= number; i++) {
			if(i == 0)
			{  
				mOutput = 1;
				System.out.println("2 ^ 0 = "+mOutput);
			}
			else
			{
			mOutput = mOutput*2;
			System.out.println("2 ^ "+i+" = "+mOutput);
			}
		}
		
	}




	/**
	 * @param number  takes the range upto which harmonic number will be calculated
	 */
	public void findHarmonic(int number) {


		double N = 0.0;

		while(number>0) 
		{
			N = N + 1.0/number;
			number--;
		}

		System.out.println("your result is:"+ N);
	}





	/**
	 * findPrimeFactor finds all the prime factors of a number
	 * @param number takes number as user input 
	 */
	public void findPrimeFactor(int number) 
	{

		int temp;
		temp=number;

		ArrayList<Integer> factor = new ArrayList<Integer>();
		while(number % 2 == 0)
		{
			factor.add(2);
			number = number/2;
		}
		
			for (int i = 3; i*i <= number; i = i+2) 
			{
				while (number % i == 0)
				{
					factor.add(i);
					number = number/i;
				}
			}
		
		//if number is a prime number
		if (number > 1) 
		{
			factor.add(number);
		}
		System.out.println("Prime factor(s) of "+temp+":");
		for(Integer i:factor) 
		{
			System.out.print(i+" ");
		}
	}




	/**
	 * generateCoupon prints unique coupon code
	 * @param lengthOfCoupon
	 */
	public void generateCouponCode(int lengthOfCoupon)
	{

		int count = 0;
		int code;
		ArrayList<Integer> coupon= new ArrayList<Integer>();

		Random rn=new Random();
		do
		{
			code=rn.nextInt(lengthOfCoupon);
			count++;
			if(!coupon.contains(code)) 
			{
				coupon.add(code);
			}

		}
		while(coupon.size()<lengthOfCoupon);
		System.out.println("You need total "+count+" random numbers to generate this coupon");		


		for(Integer i:coupon) {
			System.out.println(i);
		}
	}



	/**
	 * findQuadraticRoots method calculates the roots of quadratic equation
	 * 
	 * @param numFirst takes first input number
	 * @param numSecond takes first input number
	 * @param numThird takes first input number
	 */
	public static void findQuadraticRoots(int numFirst, int numSecond, int numThird) {
		double delta = (numSecond * numSecond) - (4 * numFirst * numThird);
		double rootOne = 0;
		double rootTwo = 0;

		if (delta > 0) {
			rootOne = (-(numSecond) + Math.sqrt(delta)) / (2 * numFirst);
			rootTwo = (-(numSecond) - Math.sqrt(delta)) / (2 * numFirst);
			System.out.println("root1 of 'x' = " + rootOne);
			System.out.println("root2 of 'x' = " + rootTwo);
		} 
		else if (delta < 0)
		{
			double realPart = (-numSecond) / (2 * numFirst);
			double imaginaryPart = Math.sqrt((-delta) / (2 * numFirst));

			System.out.println("root1 :" + realPart + "+2" + imaginaryPart + "i");
			System.out.println("root1 :" + realPart + "-2" + imaginaryPart + "i");
		}
		else 
		{
			System.out.println("root-1 of 'x' and root-2 of 'x' = " + (-numSecond) / (2 * numFirst));
		}
	}



	/**
	 * @param t takes temperature
	 * @param v takes speed
	 */
	public void calculateEffectiveTemp(int t, int v) 
	{
		double w;

		if(t>50 || v>120 || v<3)
		{
			System.out.println("Temperature should be less than 50 and "
					+ "speed should be grater than 3 and less than 120");

		}
		else
		{
			w=35.74+0.6215*t+(0.4275*t-35.75)*Math.pow(v, 0.16);
			System.out.println("Effective temperature for wind mill: "+w );
		}
	}


	/**
	 * @param inputString takes string as user input
	 */
	public void StringPermutation(String inputString)
	{
		StringPermutation("", inputString);
	}
	/**
	 * @param permute
	 * @param inputString
	 */
	
	private static void StringPermutation(String permute, String inputString)
	{    
		
		if(inputString.length() == 0)
		{
			System.out.println(permute);
		}
		else
		{
			for (int i = 0; i < inputString.length(); i++)
			{    
				StringPermutation(permute+inputString.charAt(i), inputString.substring(0, i)+
						inputString.substring(i+1, inputString.length()));
				
			}
		}
		
	}





	/**
	 * Tic-Tac-Toe Game
	 */



	public static char[] showGame( char[] board) 
	{

		for (int i = 0; i < 9; i++)
		{ 
			board[i] = ' ';       
		}
		return board;
	}

	public static void drawBox(char[] board) {

		System.out.println();
		System.out.println();
		System.out.println("---------------------");
		for (int i = 0; i < 9; i++) 
		{  
			int count = 0;
			for (int j = i ; j < 9 ; j++) 
			{
				count++;
				i = j;
				System.out.print("|  "+board[i]+"  |");

				if(count>2)
					break;
			}
			System.out.println();
			System.out.println("---------------------");


		}
	}

	/*
	 * to check equality of characters
	 */
	private static boolean checkEqual(char c1, char c2, char c3) 
	{
		return ((c1!=' ') && (c1==c2) && (c2==c3)); 
	}

	/*
	 * to check equality of rows, columns and diagonals
	 */
	private static boolean checkWin(char[]board) {
		if((checkEqual(board[0], board[1],board[2])) || 
		   (checkEqual(board[3],board[4],board[5]))  || 
		   (checkEqual(board[6],board[7],board[8]))  || 
		   (checkEqual(board[0], board[3],board[6])) || 
		   (checkEqual(board[1],board[4],board[7]))  || 
		   (checkEqual(board[2],board[5],board[8]))  || 
		   (checkEqual(board[0], board[4],board[8])) || 
		   (checkEqual(board[2],board[4],board[6])))
		{
			return true;

		}
		return false;
	}


	/*
	 * to check whether all position is occupied
	 */ 
	public static boolean notEmpty(char[] board)
	{
		for(int i=0;i<board.length;i++)
		{
			if(board[i] == ' ') 
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * userPlay method decides users game
	 * @param board
	 */
	public static void userPlay(char[] board) 
	{
		ArrayList<Integer> place= new ArrayList<Integer>();

		for(int i=0;i<9;i++)
		{
			if(board[i] == ' ')
			{
				place.add(i);
			}
		}
		System.out.println("place you can enter: ");
		for(Integer pos:place)
		{
			System.out.print(pos+" ");
		}
		System.out.println();
		System.out.println("enter your position to add 'X' :");
		int position=Utility.readInteger();

		if(board[position]==' ' &&  board[position]!='X')
		{
			board[position]='X';
			if(checkWin(board)) 
			{  
				drawBox(board);
				System.out.println("Winner..");
				System.exit(0);

			}
			else if(notEmpty(board))
			{
				System.out.println("Match Draw....");
			}
			else
			{   
				drawBox(board);
				System.out.println("Computer will play");
				computerPlay(board);

			}

		}
		else
		{
			System.out.println("Position already occupied!!");
			userPlay(board);
		}

	}



	/**
	 * computerPlay method decides the computers game
	 * @param board
	 */
	public static void computerPlay(char[] board) 
	{

		Random rn=new Random();
		int position= rn.nextInt(8);

		if(board[position]==' ' && board[position]!='O')
		{
			board[position]='O';

			if(checkWin(board)) 
			{
				System.out.println(" Computer Win.....!!!"); 
				drawBox(board);
				return;
			}
			else if(notEmpty(board))
			{
				System.out.println("Match Draw....");
			}
			else
			{   
				drawBox(board);
				System.out.println("YOUR turn");
				userPlay(board);
			}

		}
		else
		{

			computerPlay(board);
		}

	}

	/**************************************************************************************************************************/


	/**
	 * Anagram
	 */
	/**
	 * removeSpace method removes all the spaces present in string
	 * @param str
	 * @return
	 */
	public String removeSpace(String str)
	{
		char ch[] = str.toCharArray();
		str = "";
		for(int i = 0 ; i < ch.length ; i++)
		{
			if(ch[i] != ' ')
			{
				str = str + ch[i];
			}
		}
		return str;

	}
	/**
	 * toLower method is converting all the uppercase letters to lower case
	 * @param str
	 * @return
	 */
	public String toLower(String str)
	{
		char ch[] = str.toCharArray();
		str = "";
		for (int i = 0 ; i < ch.length ; i++)
		{
			if(ch[i] >= 'A' && ch[i] <= 'Z')
			{
				str = str + (char) (ch[i]+32) ;
			}
			else
				str = str + ch[i];
		}
		return str;
	}

	public char[] sort(String str)
	{
		char ch[] = str.toCharArray();
		str = "";

		for(int i = 0 ; i < ch.length-1; i++)
		{
			for(int j = i+1 ; j < ch.length; j++)
			{
				if((int)ch[i] > (int)ch[j])
				{
					char temp;
					temp = ch[i] ;
					ch[i] = ch[j];
					ch[j] = temp;
				}
			}
		}
		return ch;
	}


	/**
	 * @param char1
	 * @param char2
	 * @return
	 */
	public static boolean checkAnagram(char char1[] , char char2[])
	{

		for(int i = 0 ; i < char1.length ; i++)
		{
			if(char1[i] != char2[i])
			{
				return false;
			}

		}
		return true;
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkAnagramString(String s1 , String s2)
	{

		char[] char1 = s1.toCharArray();
		char[] char2 = s2.toCharArray();
		
		for(int i = 0 ; i < char1.length ; i++)
		{
			if(char1[i] != char2[i])
			{
				return false;
			}

		}
		return true;
	}

	
	/**
	 * @param firstInt
	 * @param secondInt
	 * @return
	 */
	public void checkNumberAnagram(int firstInt , int secondInt)
	{
		String first = firstInt+"";
		String second = secondInt+"";
	
		char[] firstChar = Utility.bubbleSort(first);
		char[] secondChar = Utility.bubbleSort(second);
		
		if(Utility.checkAnagram(firstChar, secondChar))
		{
			System.out.println("The two numbers are anagram "+firstChar+", "+secondChar);
			
		}
		
	}
	
	/**
	 * findPrime method returns whether number is prime or not
	 * @param number is the user input 
	 */
	public static boolean findPrime(int number)
	{
		int i = 2 , count = 0;
		while(i <= number/2)
		{
			if(number % i ==0)
			{
				count++;
				break;
			}
			i++;
		}
		if(count != 0)
		{
			return false;
		}
		else
			return true;
	}
	
	
		
	
	/**
	 * @return
	 * @throws IOException
	 */
	public static String[] fileReader() throws IOException {
		
        FileReader fileReader = new FileReader("/home/bridgelabz/sweta/new.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
       
        String str = bufferedReader.readLine();
        String []array = str.split(",");
        return array;
    }
	
	/**
	 * To check whether the number is Pallindrome or not
	 * @param number
	 * @return true or false
	 */
	public boolean isPallindrome(int number)
	{
		int reverse = 0;
		int rem=0;
		int temp = number;
		while(temp != 0)
		{
			rem = temp % 10;
			reverse = reverse * 10 +rem;
			temp = temp/10;
		}

		if(reverse == number)
			return true;

		else
			return false;

	}


	public int[] sortArray(int array[])
	{
		for (int i = 0; i < array.length; i++) {
			for(int j=i+1 ; j< array.length ; j++)
			{
				int temp = array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
		return array;
	}

	/**
	 * @param array
	 * @param number
	 * @return
	 */
	public static int binarySearch(int array[] , int number , int low , int high)
	{
		long startTime = 0;
		long endTime = 0;
		
		int mid =(low+high)/2;
		startTime = System.nanoTime();
		while(low < high)
		{
			if(array[mid] == number)
			{
				endTime = System.nanoTime();
				System.out.println("Elapsed Time is : "+ (endTime - startTime));
				return mid;
			}
			else if(array[mid] < number)
			{
				return binarySearch(array , number , mid+1 ,high);
			}
			else if(array[mid] > number)
			{
				
				return binarySearch(array , number , low , mid-1);
			}
		}
		endTime = System.nanoTime();
		System.out.println("Elapsed Time is : "+ (endTime - startTime));

		return -1;

	}
	/**
	 * @param str
	 * @param key
	 */
	public static int binarySearch(String str[], String key, int low , int high)
	{
		Arrays.sort(str);
		
		int mid =(low+high)/2;
		while(low < high)
	{
		if(str[mid].equals(key))
		{
			return mid;
		}
		else if(str[mid].compareTo(key) <0)
		{
			return binarySearch(str, key , mid+1 , high);
		}
		else if(str[mid].compareTo(key) > 0)
		{
			return binarySearch(str, key , low, mid);
		}
	}
		return -1;
	}
	
	
	/**
	 * @param s
	 * @param first
	 * @param last
	 * @param key
	 */
	public static void binarySearchString(String s, int first, int last, char key)
	{
		System.out.println("Entered String is : " + s);
		
		char arr[] = s.toCharArray();
		
		Arrays.sort(arr);
		
		int mid = (first + last) / 2;
		
		while (first <= last)
		{
		if (arr[mid] < key) 
		{
		first = mid + 1;
		} else if (arr[mid] == key) 
		{
		System.out.println("element is found at index: " + mid);
		
		break;
		} 
		else
		{
		last = mid - 1;
		}
		mid = (first + last) / 2;
		}
		if (first > last)
		{
		System.out.println("Elements is not found");
		}
		}

	
	
	
	

	/**
	 * @param number
	 */
	public static int[] insertionSort(int[] number)
	{
		long startTime = 0;
		long endTime = 0;
		int size = number.length;
		int key;
		startTime = System.nanoTime();
		for (int i = 1; i < size; i++) {
			int j = i-1;
			key = number[i];
			while(j >= 0 && number[j] > key)
			{
				number[j+1] = number[j];
				j = j-1;
			}
			number[j+1]=key;
		}
		endTime = System.nanoTime();
		System.out.println("Elapsed Time is : "+ (endTime - startTime));

		return number;
	}

	/**
	 * @param str
	 * @return
	 */
	public static char[] insertionSort(String str)
	{
		long startTime = 0;
		long endTime = 0; 
		char ch[] = str.toCharArray();
		startTime = System.nanoTime();
		for (int i = 1; i < ch.length; i++) {
			int j = i-1;
			char key = ch[i];
			while(j >= 0 && ch[j] > key)
			{
				ch[j+1] = ch[j];
				j = j-1;
			}
			ch[j+1]=key;
		}
		endTime = System.nanoTime();
		System.out.println("Elapsed Time is : "+ (endTime - startTime));
		return ch;
	}

	/**
	 * @param array
	 * @return
	 */
	public static int[] bubbleSort(int[] array)
	{
		long startTime = 0;
		long endTime = 0;
		startTime = System.nanoTime();
		for(int i = 0 ; i < array.length-1; i++)
		{
			for(int j = i+1 ; j < array.length; j++)
			{
				if(array[i] > array[j])
				{
					int temp;
					temp = array[i] ;
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("Elapsed Time is : "+ (endTime - startTime));
		return array;

	}
	/**
	 * Bubble Sort for 
	 * string
	 * @param str
	 * @return
	 */
	public static char[] bubbleSort(String str)
	{
		char ch[] = str.toCharArray();
		str = "";
		//long startTime = 0;
		///long endTime = 0;
	//	startTime = System.nanoTime();

		for(int i = 0 ; i < ch.length-1; i++)
		{
			for(int j = i+1 ; j < ch.length; j++)
			{
				if((int)ch[i] > (int)ch[j])
				{
					char temp;
					temp = ch[i] ;
					ch[i] = ch[j];
					ch[j] = temp;
				}
			}
		}
	//	endTime = System.nanoTime();
		//System.out.println("Elapsed Time is : "+ (endTime - startTime));
		return ch;
	}
	
	/**
	 * Merge Sort
	 * @param array
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] array , int low , int mid ,int high)
	{
		int[] nLow = new int[mid - low +1];
		int[] nHigh = new int[high - mid];

		for(int i=0 ; i<nLow.length ; i++)
		{
			nLow[i]= array[low + i];
		}
		for(int j=0 ; j<nHigh.length ; j++)
		{
			nHigh[j]= array[j+mid+1];
		}


		int i=0, j=0;
		int k = low;

		while (i < nLow.length && j < nHigh.length)
		{
			if (nLow[i] <= nHigh[j])
			{
				array[k] = nLow[i];
				i++;
			}
			else
			{
				array[k] = nHigh[j];
				j++;
			}
			k++;
		}

		while(i < nLow.length)
		{
			array[k] = nLow[i];
			k++;
			i++;
		}
		while(j < nHigh.length)
		{
			array[k] = nHigh[j];
			j++;
			k++;

		}



	}
	
	/**
	 * mergeSort method divide the array and then sort and again merge
	 * @param array
	 * @param low
	 * @param high
	 */
	public static final void mergeSort(String[] array,int low,int high) 
	{
		if(low<high)
		{
			
		//Find the mid element
		int mid = low+(high-low)/2;
		
		//Sort first and second halves
		mergeSort(array,low,mid);
		mergeSort(array,mid+1, high);
		
		//merge the sorted halves
		merge(array,low,mid,high);
		
		}
		}
	
		/**
		 * merge method merge the array in sorted way
		 * @param array
		 * @param low
		 * @param mid
		 * @param high
		 */
		public static void merge(String array[],int low,int mid,int high)
		{
			
		int i, mid1, k=0, low1;
		
		String[] temp= new String[50];
		low1 = low;
		i = low;
		mid1 = mid + 1;
		
		while ((low1 <= mid) && (mid1 <= high))
		{
		if (array[low1].compareToIgnoreCase(array[mid1])<=0 )
		{
		temp[i] = array[low1];
		low1++;
		}
		else
		{
		temp[i] = array[mid1];
		mid1++;
		}
		i++;
		}
		if (low1 > mid)
		{
		for (k = mid1; k <= high; k++)
		{
		temp[i] = array[k];
		i++;
		}
		}
		else
		{
		for (k = low1; k <= mid; k++)
		{
		temp[i] = array[k];
		i++;
		}
		}
		for (k = low; k <= high; k++)
		{
		array[k] = temp[k];
		}
		}

	
	/**
	 * @param low
	 * @param high
	 */
	public void searchNumber(int low , int high)
	{
		int mid = low + (high-low) / 2;

		if(low < high)
		{
			System.out.println("Is your number in between " + low +" "+ (mid) +"or" +(mid+1)+" "+high );
			System.out.println("Press 0 for YES or 1 for NO");

			if(Utility.readInteger() == 0)
			{
				searchNumber(low,mid);
			}
			else
			{
				searchNumber(mid+1,high);
			}
		}
		else
		{
			System.out.println("The number is "+low);
		}
	}
	
	

	/**
	 * 
	 */
	public static void temperaturConversion()
	{
		/*Celsius to Fahrenheit: (°C × 9/5) + 32 = °F
Fahrenheit to Celsius: (°F − 32) x 5/9 = °C*/

	}
	
	
	/**
	 * @param principal
	 * @param rate
	 * @param year
	 * @return
	 */
	public static double monthlyPayment(double principal , double rate , double year)
	{
		double n = 12 * year;
		double r = rate /(12 * 100);
		double calculatePayment = (principal*r) / (1- Math.pow(1+r, -n));
		return calculatePayment;
	}

	/**
	 * @param number
	 * @return
	 */
	public static double sqrt(double number)
	{
		double t = number;
		double epsilon = 1e-15;
		while(Math.abs(t-number/t) > epsilon*t)
		{
			t = (number/t + t)/2;
		}
		return t;
	}

	/**
	 * @param number
	 * @return
	 */
	public static String toBinary(int number)
	{
		String binary = "";
		while(number != 0)
		{
			int rem = number% 2;
			binary = rem + binary;
			number = number/2;
		}

		return binary;
	}
	/**
	 * @param binary
	 * @return
	 */
	public static int toDecimal(int binary)
	{
		int dec = 0;
		int power = 0;
		while(binary != 0)
		{
			int rem = binary % 10;
			dec =(int) (dec + rem*Math.pow(2, power));
			power++;
			binary = binary/10;

		}
		return dec;
	}
	
	/**
	 * @param month
	 * @param day
	 * @param year
	 * @return
	 */
	public static int dayOfWeek(int month,int day,int year)
	{
		
		int	y0 = year - (14 - month) / 12;

		int x = y0 + y0/4 - y0/100 + y0/400;

		int	m0 = month + 12 * ((14 -month) / 12) -2;

		int d0 = (day + x + 31*m0/ 12) % 7;

		return d0;
	}
	/**
	 * @param month
	 * @param date
	 * @param year
	 * @return
	 */
	public static boolean isValidDate(int month, int date, int year)
	{
		if(month < 1 || month >12 )
			return false;
		if(date<1 || date >31)
			return false;

		if(month == 2)
		{
			if(Utility.leapYear(year))
				return (date<=29);
			else 
				return(date<=28);
		}
		if(month == 4 || month == 6 || month == 9 || month == 11)
			return(date <= 30);
		return true;
	}
	
	
	/**
	 * @param amount
	 */
	public static void generateChange(int amount)
	{
		int changes[] = {1000,500,100,50,10,5,2,1};
		int count =0;
		for (int i = 0; i < changes.length; i++) 
		{
			int value = amount / changes[i];
			amount = amount % changes[i];
			System.out.println(value +" "+ changes[i] + " rupees note" );
			if(value > 0)
				count= count + value;

		}
		System.out.println("The minimum number of notes it will generate changes: "+ count);
	}
	
	
	/*-------------------------------------------------------------------------------
Generic*/

	public static <T extends Comparable<T>> T maximum(T x, T y, T z)
	{
		if(x.compareTo(y) > 0 && x.compareTo(z) > 0)
		{
			return x;
		}
		else if(y.compareTo(x) > 0 && y.compareTo(z) > 0)
		{
			return y;
		}
		else
			return z;
	}
	public static <T extends Comparable<T>> T[] genericinsertionSort(T[] x)
	{
		long startTime = 0;
		long endTime = 0;
		int size = x.length;
		T key;
		startTime = System.nanoTime();
		for (int i = 1; i < size; i++) {
			int j = i-1;
			key = x[i];
			while(j >= 0 && x[j].compareTo(key) > 0)
			{
				x[j+1] = x[j];
				j = j-1;
			}
			x[j+1]=key;
		}
		endTime = System.nanoTime();
		System.out.println("Elapsed Time is : "+ (endTime - startTime));

		return x;
	}
	/**
	 * @param array
	 * @return
	 */
	public static <T extends Comparable<T>> T[] genericBubbleSort(T[] array)
	{
		long startTime = 0;
		long endTime = 0;
		startTime = System.nanoTime();
		for(int i = 0 ; i < array.length-1; i++)
		{
			for(int j = i+1 ; j < array.length; j++)
			{
				if(array[i].compareTo(array[j]) > 0)
				{
					T temp;
					temp = array[i] ;
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		endTime = System.nanoTime();
		System.out.println("Elapsed Time is : "+ (endTime - startTime));
		return array;

	}
	/**
	 * @param array
	 * @param number
	 * @return
	 */
	public static <T extends Comparable<T>> int genericBinarySearch(T array[] , T number , int low , int high)
	{
		long startTime = 0;
		long endTime = 0;
	
		int mid =(low+high)/2;
		startTime = System.nanoTime();
		while(low < high)
		{
			if(array[mid] == number)
			{
				endTime = System.nanoTime();
				System.out.println("Elapsed Time is : "+ (endTime - startTime));
				return mid;
			}
			else if(array[mid].compareTo(number) < 0)
			{
				
				return genericBinarySearch(array, number ,mid+1 ,high);
			}
			else if(array[mid].compareTo(number) > 0)
			{
				return genericBinarySearch(array, number ,low ,mid-1);
			}
		}
		endTime = System.nanoTime();
		System.out.println("Elapsed Time is : "+ (endTime - startTime));

		return -1;
	}

	   /**
	 * @param nodes
	 * @return
	 */
	public static int countTree(int nodes) {
	       int output=0;
	       output= factorial(2*nodes)/(factorial(nodes+1) * factorial(nodes));
	       return output;
	   }
	
	/**
	 * @param number
	 * @return
	 */
	public static int factorial(int number)
	{
	       int fact=1;
	       for(int i=0;i<number;i++)
	       {
	           fact = fact + fact*i;
	       }
	       return fact;
	   }

	public static boolean numAnagramCheck(Integer integer, Integer integer2) {
		String number1 = integer + "";
		String number2 = integer2+"";
		 
		return Utility.bubbleSort(number1).equals(Utility.bubbleSort(number2));
		
	}

	
	
/*************************************************************************************************************/
	
	//ObjectOrientedProgram

	/**
	 * @param message
	 * @param firstName
	 * @param lastName
	 * @param number
	 * @return
	 */
	public static String getMessage(String message , String firstName , String lastName , String number)
	{
		 String regName = "<<name>>";
		 String regFullName = "<<full name>>";
	     String regContact = "xxxxxxxxxx";
		 String regDate = "01/01/2016";
	    
	     message = Utility.replaceString(message, regName ,firstName);
	     message = Utility.replaceString(message, regFullName , firstName+" "+lastName);
	     message = Utility.replaceString(message, regContact , number);
	     
	     Date date = new Date();
	     DateFormat simpleDate= new SimpleDateFormat("dd/MM/yyyy");
	     String newDate = simpleDate.format(date);
	     
	     message = Utility.replaceString(message, regDate , newDate );
	     
			return message;
	}
	
	 
	/**
	 * @param message
	 * @param regEx
	 * @param details
	 * @return
	 */
	public static String replaceString(String message , String regEx , String details)
	{
		Pattern pattern = Pattern.compile(regEx);
		Matcher match = pattern.matcher(message); 
        return match.replaceAll(details);
	}
	
	
	
	/**
	 * @param cards
	 */
	public static void shuffle(SingleLinkedList[] cards) {
		Random rn = new Random();
		
		for(int i =0 ; i < 52 ; i++)
		{
			Integer r = i+ rn.nextInt(52-i);
			SingleLinkedList temp = cards[r];
			cards[r] = cards[i];
			cards[i] = temp;	
		}
			
	}
	public static String[][] cardsIntialization(String[][] deck,String[] SUIT,String[] RANK)
	{
	    for(int i=0;i<SUIT.length;i++)
	    {
	        for(int j=0;j<RANK.length;j++)
	        {
	            deck[i][j]=SUIT[i]+" - " +RANK[j];
	        }
	    }
	    return deck;
	}
	//shuffling cards
	/**
	 * @param deck
	 * @param suitsize
	 * @param ranksize
	 * @return
	 */
	public static String[][] shufflingCards(String[][] deck,int suitsize,int ranksize)
	{
	    for(int i=0;i<suitsize;i++)
	    {
	        for(int j=0;j<ranksize;j++)
	        {
	       int random=(int)(Math.random()*suitsize);
	       int random1=(int)(Math.random()*ranksize);
	       String temp=deck[random][random1];
	       deck[random][random1]=deck[i][j];
	       deck[i][j]=temp;
	        }
	    }
	    return deck;
	}
	//printing cards
	/**
	 * @param deck
	 */
	public static void  printingcards(String[][] deck)
	{
	    for(int i=0;i<4;i++)
	    {
	        System.out.println("person "+ (i+1));
	        for(int j=0;j<9;j++)
	        {
	            System.out.println(deck[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
	/**
	 * @param file
	 * @throws IOException
	 */
	public static void writeFile(File file) throws IOException 
	  {
	        FileWriter fWriter = new FileWriter(file);
	        BufferedWriter bWriter = new BufferedWriter(fWriter);
	       // System.out.println("Enter the numbers with space separated: ");
	        String input = Utility.readNextLine();
	        bWriter.write(input);
	        bWriter.flush();
	  }
	/**
	 * @param file
	 * @param content
	 * @throws IOException
	 */
	public static void writeFile(String file, String content) throws IOException 
	  {
		try {
	        FileWriter fWriter = new FileWriter(file);
	        BufferedWriter bWriter = new BufferedWriter(fWriter);
	     
	        bWriter.write(content);
	        bWriter.close();
		}
		catch(FileNotFoundException fileNotFound)
		{
			System.out.println("File not found");
		}
	  }
	
	/**
	 * @param object
	 * @param path
	 */
	public static <T> void toJSON(T object , String path) 
	{
		ObjectMapper map = new ObjectMapper();
		
		ObjectWriter write = map.writer(new DefaultPrettyPrinter());
		try
		{
			write.writeValue(new File(path), object);
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		System.out.println("Done...");
	}

	public static List<String> jsonToJavaAddressBookList(String fileName) {
		JSONParser parser = new JSONParser();
		List<String> addressBookList = new ArrayList<>();
		try {
			
			Object obj = parser.parse(new FileReader(fileName));
			JSONArray personList = (JSONArray) obj;
			for(Object object : personList) {
				String addressBookName = object.toString();
				addressBookList.add(addressBookName);
			}
		}
		catch(Exception e) {
			System.out.println("Hello");
		}
		return addressBookList;
	}

}




