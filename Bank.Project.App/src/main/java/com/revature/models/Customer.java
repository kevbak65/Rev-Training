package com.revature.models;

public class Customer {
	// create access modifiers:
	private int custID;
	private int acctNum;
	private String acctType;
	private int userID;
	private int appID;
	private String appDate;
	private String custInitDate;
	private String custSSN;
	private String custLName;
	private String custFName;
	private String custAddress;
	private String custCity;
	private String custState;
	private String custZip;
	private String custDOB;
	private String custPhoneNum;
	private String userName;
	private String userPswd;
	private String appStatus;
	private Double acctBal;
	private String acctDesc;
	private String lastTrxnDt;
	
	
	// No args constructor
	public Customer() {
		super();
	}
	
	public Customer(int custID) {
		this.custID = custID;
	}
	
	public Customer(int custID, int acctNum, String acctType) {
		this.custID = custID;
		this.acctNum = acctNum; 
		this.acctType = acctType;
	} 
	
	public Customer(int custID, String appStatus) {
		this.custID = custID;
		this.appStatus = appStatus;
	}
	
	public Customer(String custFName, String custLName, String acctDesc, double acctBal, String lastTrxnDt) {
		this.custFName = custFName;
		this.custLName = custLName;
		this.acctDesc = acctDesc;
		this.acctBal = acctBal;
		this.lastTrxnDt = lastTrxnDt;		
	}
	
	public Customer(int custID, String acctType, int acctNum, String custInitDate, String custLName, String custFName, String acctStatus) {
		this.custID = custID;
		this.acctType = acctType;
		this.acctNum = acctNum;
		this.custInitDate = custInitDate;
		this.custLName = custLName;
		this.custFName = custFName;
		this.appStatus = acctStatus;
	}
		
		// Parameterized constructor
		public Customer(String acctType, String appDate, String custInitDate, String custSSN, String custLName, String custFName, String custAddress, String custCity, String custState, String custZip, String custDOB, String custPhoneNum, String userName, String userPswd) {
			this.acctType = acctType;
			this.appDate = appDate;
			this.custInitDate = custInitDate;
			this.custSSN = custSSN;
			this.custLName = custLName;
			this.custFName = custFName;
			this.custAddress = custAddress;
			this.custCity = custCity;
			this.custState = custState;
			this.custDOB = custDOB;
			this.custPhoneNum = custPhoneNum;
			this.userName = userName;
			this.userPswd = userPswd;
		}
		
		public Customer(String acctType, String custSSN, String custLName, String custFName, String custAddress, String custCity, String custState, String custZip, String custDOB, String custPhoneNum, String userName, String userPswd) {
			this.acctType = acctType;
			this.custSSN = custSSN;
			this.custFName = custFName;
			this.custFName = custFName;
			this.custAddress = custAddress;
			this.custCity = custCity;
			this.custState = custState;
			this.custZip = custZip;
			this.custDOB = custDOB;
			this.custPhoneNum = custPhoneNum;
			this.userName = userName;
			this.userPswd = userPswd;
		}
	
	public Double getAcctBal() {
		return acctBal;
	}

	public void setAcctBal(Double acctBal) {
		this.acctBal = acctBal;
	}

	public String getAcctDesc() {
		return acctDesc;
	}

	public void setAcctDesc(String acctDesc) {
		this.acctDesc = acctDesc;
	}

	public String getLastTrxnDt() {
		return lastTrxnDt;
	}

	public void setLastTrxnDt(String lastTrxnDt) {
		this.lastTrxnDt = lastTrxnDt;
	}

	public int getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getCustInitDate() {
		return custInitDate;
	}

	public void setCustInitDate(String custInitDate) {
		this.custInitDate = custInitDate;
	}

	public String getCustSSN() {
		return custSSN;
	}

	public void setCustSSN(String custSSN) {
		this.custSSN = custSSN;
	}

	public String getCustLName() {
		return custLName;
	}

	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}

	public String getCustFName() {
		return custFName;
	}

	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCustZip() {
		return custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	public String getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(String custDOB) {
		this.custDOB = custDOB;
	}

	public String getCustPhoneNum() {
		return custPhoneNum;
	}

	public void setCustPhoneNum(String custPhoneNum) {
		this.custPhoneNum = custPhoneNum;
	}

	public String getUserName() {
		return userName;
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
		return "Customer [custID=" + custID + ", acctNum=" + acctNum + ", acctType=" + acctType + ", userID=" + userID
				+ ", appID=" + appID + ", appDate=" + appDate + ", custInitDate=" + custInitDate + ", custSSN="
				+ custSSN + ", custLName=" + custLName + ", custFName=" + custFName + ", custAddress=" + custAddress
				+ ", custCity=" + custCity + ", custState=" + custState + ", custZip=" + custZip + ", custDOB="
				+ custDOB + ", custPhoneNum=" + custPhoneNum + ", userName=" + userName + ", userPswd=" + userPswd
				+ ", appStatus=" + appStatus + ", acctBal=" + acctBal + ", acctDesc=" + acctDesc + ", lastTrxnDt="
				+ lastTrxnDt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctBal == null) ? 0 : acctBal.hashCode());
		result = prime * result + ((acctDesc == null) ? 0 : acctDesc.hashCode());
		result = prime * result + acctNum;
		result = prime * result + ((acctType == null) ? 0 : acctType.hashCode());
		result = prime * result + ((appDate == null) ? 0 : appDate.hashCode());
		result = prime * result + appID;
		result = prime * result + ((appStatus == null) ? 0 : appStatus.hashCode());
		result = prime * result + ((custAddress == null) ? 0 : custAddress.hashCode());
		result = prime * result + ((custCity == null) ? 0 : custCity.hashCode());
		result = prime * result + ((custDOB == null) ? 0 : custDOB.hashCode());
		result = prime * result + ((custFName == null) ? 0 : custFName.hashCode());
		result = prime * result + custID;
		result = prime * result + ((custInitDate == null) ? 0 : custInitDate.hashCode());
		result = prime * result + ((custLName == null) ? 0 : custLName.hashCode());
		result = prime * result + ((custPhoneNum == null) ? 0 : custPhoneNum.hashCode());
		result = prime * result + ((custSSN == null) ? 0 : custSSN.hashCode());
		result = prime * result + ((custState == null) ? 0 : custState.hashCode());
		result = prime * result + ((custZip == null) ? 0 : custZip.hashCode());
		result = prime * result + ((lastTrxnDt == null) ? 0 : lastTrxnDt.hashCode());
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
		Customer other = (Customer) obj;
		if (acctBal == null) {
			if (other.acctBal != null)
				return false;
		} else if (!acctBal.equals(other.acctBal))
			return false;
		if (acctDesc == null) {
			if (other.acctDesc != null)
				return false;
		} else if (!acctDesc.equals(other.acctDesc))
			return false;
		if (acctNum != other.acctNum)
			return false;
		if (acctType == null) {
			if (other.acctType != null)
				return false;
		} else if (!acctType.equals(other.acctType))
			return false;
		if (appDate == null) {
			if (other.appDate != null)
				return false;
		} else if (!appDate.equals(other.appDate))
			return false;
		if (appID != other.appID)
			return false;
		if (appStatus == null) {
			if (other.appStatus != null)
				return false;
		} else if (!appStatus.equals(other.appStatus))
			return false;
		if (custAddress == null) {
			if (other.custAddress != null)
				return false;
		} else if (!custAddress.equals(other.custAddress))
			return false;
		if (custCity == null) {
			if (other.custCity != null)
				return false;
		} else if (!custCity.equals(other.custCity))
			return false;
		if (custDOB == null) {
			if (other.custDOB != null)
				return false;
		} else if (!custDOB.equals(other.custDOB))
			return false;
		if (custFName == null) {
			if (other.custFName != null)
				return false;
		} else if (!custFName.equals(other.custFName))
			return false;
		if (custID != other.custID)
			return false;
		if (custInitDate == null) {
			if (other.custInitDate != null)
				return false;
		} else if (!custInitDate.equals(other.custInitDate))
			return false;
		if (custLName == null) {
			if (other.custLName != null)
				return false;
		} else if (!custLName.equals(other.custLName))
			return false;
		if (custPhoneNum == null) {
			if (other.custPhoneNum != null)
				return false;
		} else if (!custPhoneNum.equals(other.custPhoneNum))
			return false;
		if (custSSN == null) {
			if (other.custSSN != null)
				return false;
		} else if (!custSSN.equals(other.custSSN))
			return false;
		if (custState == null) {
			if (other.custState != null)
				return false;
		} else if (!custState.equals(other.custState))
			return false;
		if (custZip == null) {
			if (other.custZip != null)
				return false;
		} else if (!custZip.equals(other.custZip))
			return false;
		if (lastTrxnDt == null) {
			if (other.lastTrxnDt != null)
				return false;
		} else if (!lastTrxnDt.equals(other.lastTrxnDt))
			return false;
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
	
	
	
	
	

	