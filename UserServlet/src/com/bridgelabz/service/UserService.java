package com.bridgelabz.service;

import java.sql.SQLException;

public interface UserService {
	public void login(String emailId , String password) throws SQLException;
	public void register(String emailId) throws SQLException;
}
