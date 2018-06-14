package com.bridgelabz.objectoriented;

import java.util.Random;

import com.bridgelabz.datastructure.SingleLinkedList;
import com.bridgelabz.utility.Utility;

public class DeckOfCardss {
	
		static String[][]players= new String[4][9];
		public static void main(String[] args) {
		String[] suit= {"Clubs","Diamonds","Hearts","Spades"};
		String[] rank= {"2","3","4","5","6","7","8","9","10","Jack", "Queen", "King", "Ace" };
		int index=0;
		SingleLinkedList[] cards=new SingleLinkedList[52];
		SingleLinkedList[] arrangedCards=new SingleLinkedList[4];
		for(int i=0;i<cards.length;i++)
		{
		cards[i]=new SingleLinkedList();
		}
		for(int i=0;i<suit.length;i++)
		{
		for(int j=0;j<rank.length;j++)
		{
		cards[index++].add((rank[j]+" "+suit[i]));
		}
		}
		
		/*players=Utility.shuffle(cards);*/
		displayCards();
		System.out.println("*****************************************"
		+ "****************************************************");
		placingCards(players,arrangedCards);
		displayArrangedCards(arrangedCards);
		}
		/**This method is written add to the cards to in the list.
		* @param players
		* @param arrangedCards
		*/
		static void placingCards(String[][] players,SingleLinkedList[] arrangedCards) {
		for(int i=0;i<4;i++)
		{
		arrangedCards[i]=new SingleLinkedList();
		for(int j=0;j<9;j++)
		{
		/*arrangedCards[i].sort(players[i][j]);*/
		}
		}
		}
		/**
		* This method is written to display cards after arrangement of cards according to the Ranks.
		* @param cardsArrangement
		*/
		static void displayArrangedCards(SingleLinkedList[] cardsArrangement){
		for(int i=0;i<4;i++)
		{
		System.out.print("Player "+(i+1)+" cards----> ");
		for(int j=0;j<9;j++)
		{
	/*	System.out.print(cardsArrangement[i].pop(0)+" ");*/
		}
		System.out.println();
		System.out.println();
		}
		}
		/**
		* This method is written to suffle the cards.
		* @param cards
		* @returntype players is a string 2-D Array after suffling the cards.
		*/
		static String[][] sufflingCards(SingleLinkedList[] cards) {
		Random rand=new Random();
		for(int i=0;i<4;i++)
		{
		for(int j=0;j<9;j++)
		{
		int pos=rand.nextInt(51);
		if(!(cards[pos].isEmpty()))
		{
		/*players[i][j]=(String)cards[pos].pop();*/
		}
		else
		{
		j--;
		}
		}
		}
		return players;
		}
		/**
		* This method is written to display the cards placed to the players.
		*/
		static void displayCards() {
		for(int i=0;i<4;i++)
		{
		System.out.print("Player "+(i+1)+" cards----> ");
		for(int j=0;j<9;j++)
		{
		System.out.print(players[i][j]+" ");
		}
		System.out.println();
		System.out.println();
		}
		}
		

}
