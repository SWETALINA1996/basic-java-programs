package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.jdbc.EmployeeDao;

public class UserServlet extends HttpServlet
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 115655547203784748L;
	RequestDispatcher requestDispatch = null;
	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException
	{
		 resp.setContentType("text/html");
	        PrintWriter out = resp.getWriter();
	        
	        out.println("<html>");
	        out.println("<body>");

	        EmployeeDao.getConnection();
	        
	        

	}

	
}
