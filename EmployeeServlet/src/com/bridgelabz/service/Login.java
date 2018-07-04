package com.bridgelabz.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.repository.EmployeeDao;


public class Login extends HttpServlet
{

	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try 
		{
			Connection con = EmployeeDao.getConnection();
			
			//EmployeeDao.validate(userName, repassword);
			//RequestDispatcher rd = req.getRequestDispatcher("LoginSuccess");
			boolean status = EmployeeDao.validate(email, password);
			System.out.println(status);
			if(status)
			{
				HttpSession session=req.getSession(true);
				session.setMaxInactiveInterval(1*60);
				session.setAttribute("passID",email);
				RequestDispatcher dispatch=req.getRequestDispatcher("PreSuccess");
				dispatch.forward(req, resp);
			}
			else
			{

				HttpSession session=req.getSession(true);
				session.setAttribute("passID",email);
				RequestDispatcher dispatch=req.getRequestDispatcher("PreError");
				dispatch.forward(req, resp);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
