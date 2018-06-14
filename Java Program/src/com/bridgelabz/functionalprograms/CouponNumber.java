/******************************************************************************
 *  
 *  Purpose:  Generates unique Coupon number
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
 package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class CouponNumber {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the length of coupon code");
		int lengthOfCoupon = utility.readInteger();
		utility.generateCouponCode(lengthOfCoupon);

	}

}
