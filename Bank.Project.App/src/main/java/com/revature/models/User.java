package com.revature.models;


public class User {
	
	private String userName;
	private String userPswd;
	private int userID;

	public User() {
		super();
	}
	
	public User(int userID) {
		this.userID = userID;
	}
	
	public User(String userName, String userPswd) {
		this.userName = userName;
		this.userPswd = userPswd;
	}

	public String getUserName() {
		return userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPswd() {
		return userPswd;
	}

	public void setUserPswd(String userPswd) {
		this.userPswd = userPswd;
	}
	

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPswd=" + userPswd + ", userID=" + userID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPswd == null) ? 0 : userPswd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPswd == null) {
			if (other.userPswd != null)
				return false;
		} else if (!userPswd.equals(other.userPswd))
			return false;
		return true;
	}
	
	
	
}
