/******************************************************************************
 *  
 *  Purpose:  Lazy Initialization
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   16-06-2018
 *
 ******************************************************************************/
package com.bridgelabz.creationaldesignpatterns;

public class LazyInitialization
{
private static LazyInitialization object = new LazyInitialization();

private LazyInitialization() {
	
}
public static LazyInitialization returnInstance() 
{
	if(object == null)
	{
		object = new LazyInitialization();
	}
	return object;
}
public static void main(String[] args) {
	System.out.println(LazyInitialization.returnInstance() instanceof LazyInitialization);
}
}
