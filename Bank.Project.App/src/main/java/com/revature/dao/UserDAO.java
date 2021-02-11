package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.revature.models.User;

public interface UserDAO {
	
	public int createUser(User user, Connection conn) throws SQLException;
	public User getUser(String userName, String userPswd);
	public int createReqRec(int userID) throws SQLException;
	public int createReqRec(String userName, String userPswd) throws SQLException;
	public int getUpdateCust(String userName, String userPswd) throws SQLException;


		
}
