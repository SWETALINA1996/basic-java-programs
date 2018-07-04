package com.bridgelabz.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.repository.EmployeeDao;


public class Registration extends HttpServlet
{

	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String mobileNumber = req.getParameter("mobile");
		String userName = req.getParameter("email");
		String password = req.getParameter("password");
		
		Connection con = EmployeeDao.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into Servlet.user_servlet values(?,?,?,?,?)");
		
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, mobileNumber);
			pstmt.setString(4, userName);
			pstmt.setString(5, password);
			
			
			int i = pstmt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Successfully Registered");
				 HttpSession session=req.getSession(true);
					session.setAttribute("passID",id);
	            RequestDispatcher dispatch=req.getRequestDispatcher("PreSuccess");
				dispatch.forward(req, resp);
			}
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
