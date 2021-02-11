package com.revature.models;

//import java.util.List;

public class Account {
	
	private int acctID;
	private int acctNum;
	private String acctType;
	private String acctTypeDesc;
	private double acctBal;
	private String initDate;
	private int custID;
	
	
	public Account() {
		super();
	}
	
	public Account(double acctBal) {
		this.acctBal = (int) acctBal;
		
	}
	
	public Account(int accNum, double acctBal) {
		this.acctNum = accNum;
		this.acctBal = acctBal;
	}
	
	public Account(int custID, int acctNum, String acctType, String acctTypeDesc) {
		this.custID = custID;
		this.acctNum = acctNum;
		this.acctType = acctType;
		this.acctTypeDesc = acctTypeDesc;
	}
	
	public Account(int acctNum, String acctType, String acctTypeDesc, double acctBal, int custID) {
		this.acctNum = acctNum;
		this.acctType = acctType;
		this.acctTypeDesc = acctTypeDesc;
		this.acctBal = acctBal;
		this.custID = custID;
	}
	
	public Account(int acctID, int acctNum, String acctType, String acctTypeDesc, double acctBal, String initDate, int custID) {
		this.acctID = acctID;
		this.acctNum = acctNum;
		this.acctType = acctType;
		this.acctTypeDesc = acctTypeDesc;
		this.acctBal = acctBal;
		this.initDate = initDate;
		this.custID = custID;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public int getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getAcctTypeDesc() {
		return acctTypeDesc;
	}

	public void setAcctTypeDesc(String acctTypeDesc) {
		this.acctTypeDesc = acctTypeDesc;
	}

	public double getAcctBal() {
		return acctBal;
	}

	public void setAcctBal(double acctBal) {
		this.acctBal = acctBal;
	}

	public String getInitDate() {
		return initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	@Override
	public String toString() {
		return "Account [acctID=" + acctID + ", acctNum=" + acctNum + ", acctType=" + acctType + ", acctTypeDesc="
				+ acctTypeDesc + ", acctBal=" + acctBal + ", initDate=" + initDate + ", custID=" + custID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(acctBal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + acctID;
		result = prime * result + acctNum;
		result = prime * result + ((acctType == null) ? 0 : acctType.hashCode());
		result = prime * result + ((acctTypeDesc == null) ? 0 : acctTypeDesc.hashCode());
		result = prime * result + custID;
		result = prime * result + ((initDate == null) ? 0 : initDate.hashCode());
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(acctBal) != Double.doubleToLongBits(other.acctBal))
			return false;
		if (acctID != other.acctID)
			return false;
		if (acctNum != other.acctNum)
			return false;
		if (acctType == null) {
			if (other.acctType != null)
				return false;
		} else if (!acctType.equals(other.acctType))
			return false;
		if (acctTypeDesc == null) {
			if (other.acctTypeDesc != null)
				return false;
		} else if (!acctTypeDesc.equals(other.acctTypeDesc))
			return false;
		if (custID != other.custID)
			return false;
		if (initDate == null) {
			if (other.initDate != null)
				return false;
		} else if (!initDate.equals(other.initDate))
			return false;
		return true;
	}
	
	
	
}
	
 