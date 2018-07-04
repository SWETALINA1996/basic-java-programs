package com.bridgelabz.service;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCountListener implements HttpSessionListener 
{
	 private static int totalActiveSessions;
	    public SessionCountListener() {
	    }
	    public static int getTotalActiveSession(){
	    	return totalActiveSessions;
	      }
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

		 totalActiveSessions++;
	        System.out.println("sessionCreated - add one session into counter");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

		totalActiveSessions--;
    	System.out.println("sessionDestroyed - deduct one session from counter");
	}

}
