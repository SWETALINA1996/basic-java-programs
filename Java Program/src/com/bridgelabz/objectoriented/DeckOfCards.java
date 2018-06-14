package com.bridgelabz.objectoriented;

import java.util.Random;

import com.bridgelabz.datastructure.SingleLinkedList;
import com.bridgelabz.utility.Utility;

public class DeckOfCards {

	public static void main(String[] args) {
		
		
		int[] deck = new int[52];
		String[] suits = {"Spades" , "Clubs" , "Diamonds" , "Hearts"};
		String[] ranks = {"Ace" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "Jack" , "Queen" ,"King"};
		
		SingleLinkedList[] cards = new SingleLinkedList[52];
		
		for(int i = 0 ; i < 52; i++)
		{
			cards[i] = new SingleLinkedList();
		}
		
		int k =0;
		
		for(int i = 0 ; i < suits.length ;i++)
		{
			for(int j = 0 ; j < ranks.length; j++)
			{
				cards[k].add(suits[i]+" "+ranks[j]);
				k++;
			}
		}
		
	for (int i = 0; i < cards.length; i++) {
		System.out.println(cards[i].toString());
	}
		
		
	Utility.shuffle(cards);
	System.out.println("Shuffled cards:");
	for (int i = 0; i < cards.length; i++) {
		System.out.println(cards[i].toString());
	}
	
	Random rn = new Random();
	String[][] player = new String[4][9];
	
	for(int i = 0 ; i < 4 ; i++)
	{
		for(int j = 0 ; j < 9 ; j++)
		{
			int index = rn.nextInt(51);
			if(cards[index].isEmpty() == false)
			{
			player[i][j] = (String) cards[index].removeReturn();
			}
		}
	
	}
	System.out.println("Cards distributed:");
	Utility.displayArray(player);
	
	
	}
	/**This method is written add to the cards to in the list.
	* @param players
	* @param arrangedCards
	*//*
	static void placingCards(String[][] players,SingleLinkedList[] arrangedCards) {
	for(int i=0;i<4;i++)
	{
	arrangedCards[i]=new SingleLinkedList();
	for(int j=0;j<9;j++)
	{
	arrangedCards[i].sort(players[i][j]);
	}
	}
	}*/
}



	
	
	
	

