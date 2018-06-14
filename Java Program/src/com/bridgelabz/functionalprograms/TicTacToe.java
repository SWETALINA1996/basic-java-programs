/******************************************************************************
 *  
 *  Purpose:  Tic-Tac-Toe Game
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class TicTacToe {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Game Starts");
		
		char[] board = new char[9];
        Utility.showGame(board);
        Utility.drawBox(board);
        if(Math.random()<0.5)
        {
        	Utility.userPlay(board);
        }
        else
        {
        	Utility.computerPlay(board);
        }
		
	}

}
