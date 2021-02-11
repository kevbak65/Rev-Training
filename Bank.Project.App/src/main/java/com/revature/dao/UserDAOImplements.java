package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.revature.models.User;
import com.revature.utils.ConnUtil;
import com.revature.exceptions.DBConnException;

public class UserDAOImplements implements UserDAO {
	
	public UserDAOImplements() {
		super();
	}

	@Override
	public int createUser(User user, Connection conn) throws SQLException {

		int count = 0;
		
		//String sql = "INSERT INTO project_banking.customer_tbl (username, user_password) VALUES (?, ?)";
		String sql = "INSERT INTO project_banking.customer_tbl (acct_num, user_id, app_id, username, user_password) VALUES (DEFAULT, DEFAULT, DEFAULT, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPswd());
		
		count = pstmt.executeUpdate();
		return count;
		
	}
	
	@Override
	public User getUser(String userName, String userPswd){
		User user = null;
		try (Connection conn = ConnUtil.getConnection()){
			String sql = "SELECT username, user_password FROM project_banking.customer_tbl WHERE customer_tbl.username = ? AND customer_tbl.user_password  = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPswd);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user = new User(userName, userPswd);
			}		
					
		} catch (DBConnException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	@Override
	public int getUpdateCust(String userName, String userPswd) throws SQLException {
		int count = 0;
		User user = null;
		try (Connection conn = ConnUtil.getConnection()){
			String getUserIDsql = "INSERT INTO customer_tbl (user_id) SELECT user_id FROM user_tbl WHERE user_tbl.username = ? AND user_password = ?";
			PreparedStatement pstmt = conn.prepareStatement(getUserIDsql);
			pstmt.setInt(1, user.getUserID());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPswd());
			count = pstmt.executeUpdate();
		} catch (DBConnException | SQLException e){
			System.out.println(e.getMessage());
		}
			
		return count;

//@Override
//public int createReqRec(int userID) throws SQLException {
	// TODO Auto-generated method stub
//	return 0;
//};
	}

	@Override
	public int createReqRec(int userID) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createReqRec(String userName, String userPswd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
	
	
