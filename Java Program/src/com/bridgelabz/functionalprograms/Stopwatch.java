/******************************************************************************
 *  
 *  Purpose:  To find elapsed time between start and stop time of Stopwatch
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class Stopwatch {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Press 1 to start the stopwath");
		int choice = utility.readInteger();
		utility.findElapsedTime(choice);

	}

}
