package com.bridgelabz.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class RegistrationFilter implements Filter
{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException 
	{
		//System.out.println("Inside Filter*************************");
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");

		  String id=req.getParameter("id");
		  String name=req.getParameter("name");
		  String gmail=req.getParameter("email");
		  String mobile=req.getParameter("mobile");
		  String password=req.getParameter("password");
		
		  if(id.equals("")||name.equals("")||gmail.equals("")||mobile.equals("")||password.equals(""))
		  {
			 out.print("fields cannot be empty.Please enter details");
		  }
		  
		  else
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
}
