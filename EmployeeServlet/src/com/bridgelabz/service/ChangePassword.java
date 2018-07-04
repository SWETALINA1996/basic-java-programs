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

import com.bridgelabz.repository.EmployeeDao;



@SuppressWarnings("serial")
public class ChangePassword extends HttpServlet
{
RequestDispatcher dispatcher = null;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	// Get form data
	String id = req.getParameter("id");
	String currPassVal = req.getParameter("currPass");
	String newPassVal = req.getParameter("newPass");
	String reNewPassVal = req.getParameter("reNewPass");

	// Check New Password & Retype New Password is Same
	if (newPassVal.equals(reNewPassVal)) {
		// New Password = Retype New Password; Hence Update
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = EmployeeDao.getConnection();
			// Issue SQL queries via connection
			String query = "update Servlet.user_servlet set password=?"+" where id=?";
		
			System.out.println("Query=" + query);
			pstmt = con.prepareStatement(query);
		
			pstmt.setString(1, newPassVal);
		
			pstmt.setString(2,id);
		
		
			int count = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. Close All JDBC Objects
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	dispatcher = req.getRequestDispatcher("changePassword.jsp");
	dispatcher.include(req, resp);

	

}
}
}
