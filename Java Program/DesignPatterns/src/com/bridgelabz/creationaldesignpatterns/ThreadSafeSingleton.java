package com.bridgelabz.creationaldesignpatterns;

public class ThreadSafeSingleton 
{
	private static ThreadSafeSingleton object = new ThreadSafeSingleton();
	
 private ThreadSafeSingleton() {
	
}
 public static synchronized ThreadSafeSingleton returnInstance()
 {
	 if(object == null)
	 {
		 object = new ThreadSafeSingleton();
	 }
	 return object;
 }
 public static void main(String[] args) {
	System.out.println(ThreadSafeSingleton.returnInstance() instanceof ThreadSafeSingleton);
}
}
