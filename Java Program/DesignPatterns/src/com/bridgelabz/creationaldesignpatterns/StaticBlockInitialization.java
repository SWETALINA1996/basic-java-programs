/******************************************************************************
 *  
 *  Purpose:  StaticBlock Initialization
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   16-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.creationaldesignpatterns;

public class StaticBlockInitialization {
private static StaticBlockInitialization object;
    
    private StaticBlockInitialization(){}
    
    //static block initialization for exception handling
    static
    {
        try
        {
            object = new StaticBlockInitialization();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockInitialization getInstance(){
        return object;
    }
    public static void main(String[] args) {
		System.out.println(StaticBlockInitialization.getInstance() instanceof StaticBlockInitialization);
	}
}
