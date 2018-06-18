package com.bridgelabz.creationaldesignpatterns;

public class BillPughSingleton
{
	 private BillPughSingleton(){}
	    
	    private static class SingletonHelper{
	        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	    }
	    
	    public static BillPughSingleton getInstance(){
	        return SingletonHelper.INSTANCE;
	    }
	    public static void main(String[] args) {
			System.out.println(BillPughSingleton.getInstance() instanceof BillPughSingleton);
		}
}
