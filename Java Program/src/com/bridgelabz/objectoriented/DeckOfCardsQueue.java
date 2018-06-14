package com.bridgelabz.objectoriented;

import com.bridgelabz.datastructure.SingleLinkedList;
import com.bridgelabz.utility.Utility;

public class DeckOfCardsQueue
{
		public static void main(String[] args) {
		String[] suit= {"Clubs","Diamonds", "Hearts", "Spades"};
		String[] rank= {"2", "3", "4", "5", "6", "7", "8", "9", "10",
		"Jack", "Queen", "King", "Ace"	};
		int index=0;
		SingleLinkedList[] cards=new SingleLinkedList[52];
		for(int i=0;i<cards.length;i++)
		{
		cards[i]=new SingleLinkedList();
		}
		for(int i=0;i<suit.length;i++)
		{
		for(int j=0;j<rank.length;j++)
		{
		cards[index++].add(rank[j]+" "+suit[i]);
		}
		}
	/*	String[][]players=Utility.distributeCards(cards);
		Utility.printingcards(players);
		SingleLinkedList[] arrange=Utility.rearrange(players);
		Utility.showBySorted(arrange);*/
		}
		

}
