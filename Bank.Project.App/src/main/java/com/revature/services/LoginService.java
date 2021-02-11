package com.revature.services;

//import java.sql.Connection;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImplements;
//import com.revature.exceptions.DBConnException;
import com.revature.exceptions.NoRecordFound;
//import com.revature.exceptions.RecordAlreadyExists;
import com.revature.models.User;
//import com.revature.utils.ConnUtil;

public class LoginService {
	
	public UserDAO userDao;
	public LoginService() {
		userDao = new UserDAOImplements();
	}
	
	public LoginService(String userName, String userPswd) throws NoRecordFound {
		
		User user = new User(userName, userPswd);
		
		if (user != null) {
			return;
		} else {
			throw new NoRecordFound("The user with the username of: '" + userName + " was not found. Please try again!" );
		}
		
	}		

}
