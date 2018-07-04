package com.bridgelabz.service;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Listener implements ServletRequestListener
{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {

		 System.out.println("Request Destroyed"+arg0.getServletRequest().getProtocol());
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
    	System.out.println("Request intialized"+arg0.getServletRequest().getLocalAddr());
		
	}

}
