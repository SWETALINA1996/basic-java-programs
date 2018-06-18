/******************************************************************************
 *  
 *  Purpose: Eager Initialization
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   16-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.creationaldesignpatterns;

public class EagerInitialization {

	  private static final EagerInitialization instance = new EagerInitialization();
	    
	    //private constructor to avoid client applications to use constructor
	    private EagerInitialization(){}

	    public static EagerInitialization getInstance(){
	        return instance;
	    }
	    
	    public static void main(String[] args) {
			System.out.println(EagerInitialization.getInstance() instanceof EagerInitialization);
		}
}
