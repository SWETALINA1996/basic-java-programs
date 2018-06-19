package com.bridgelabz.service;
/******************************************************************************
 *  
 *  Purpose:  Interface 
 *
 *  @author  Swetalina
 *  @version 1.0
 *  @since   18-06-2018
 *
 ******************************************************************************/
import java.sql.SQLException;

public interface UserService 
{
	public void login(String emailId , String password) throws SQLException;
	public void register(String emailId) throws SQLException;

}
