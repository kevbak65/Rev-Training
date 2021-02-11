package com.revature.services;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utils.ConnUtil;
import com.revature.dao.UserDAO;
import com.revature.dao.EmpDAO;
import com.revature.dao.UserDAOImplements;
import com.revature.dao.EmpDAOImplements;
import com.revature.exceptions.DBConnException;
import com.revature.exceptions.NoRecordFound;
import com.revature.models.User;
import com.revature.models.Employee;


public class UserService {
	
	public UserDAO userDAO;
	public EmpDAO empDAO;
	
	public UserService() {
		userDAO = new UserDAOImplements();
		empDAO = new EmpDAOImplements();
	}	
	
	// Method for creating a New User
	public int createUser(String userName, String userPswd) {
		int count = 0;
		User user = new User(userName, userPswd);
		
		try (Connection conn = ConnUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			count = userDAO.createUser(user, conn); // passes the conn object to the userDAO
			conn.commit();
			
		} catch (SQLException | DBConnException e) {
			System.out.println(e.getMessage());
		}
		
		return count;
	}
	
	// Method for retrieving Existing Customer User
	public User getUser(String userName, String userPswd) throws NoRecordFound {
		
		User user = userDAO.getUser(userName, userPswd);
		return user;
	}
	
	// Method for retrieving Existing EmployeeUser
	public Employee getEmpByUserName(String empUserName, String empPswd) throws NoRecordFound {
			
		Employee emp = empDAO.getEmpByUserName(empUserName, empPswd);
		return emp;
		}
	
}
