package com.revature.models;

public class CustomerAcctView {
	private int acctNum;
	private String custFName;
	private String custLName;
	private double currAcctBal;
	private double prevAcctBal;
	private String acctDesc;
	private String lastTrxnDt;
	
	
	public CustomerAcctView() {
		super();
	}
	
	public CustomerAcctView(int acctNum, String custFName, String custLName, double currAcctBal, double prevAcctBal, String acctDesc, String lastTrxnDt) {
		this.acctNum = acctNum;
		this.custFName = custFName;
		this.custLName = custLName;
		this.currAcctBal = currAcctBal;
		this.prevAcctBal = prevAcctBal;
		this.acctDesc = acctDesc;
		this.lastTrxnDt = lastTrxnDt;		
	}
	public int getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}
	public String getCustFName() {
		return custFName;
	}
	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}
	public String getCustLName() {
		return custLName;
	}
	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}
	public double getCurrAcctBal() {
		return currAcctBal;
	}
	public void setCurrAcctBal(double currAcctBal) {
		this.currAcctBal = currAcctBal;
	}
	public double getPrevAcctBal() {
		return prevAcctBal;
	}
	public void setPrevAcctBal(double prevAcctBal) {
		this.prevAcctBal = prevAcctBal;
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
	@Override
	public String toString() {
		return "CustomerAcctView [acctNum=" + acctNum + ", custFName=" + custFName + ", custLName=" + custLName
				+ ", currAcctBal=" + currAcctBal + ", prevAcctBal=" + prevAcctBal + ", acctDesc=" + acctDesc
				+ ", lastTrxnDt=" + lastTrxnDt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctDesc == null) ? 0 : acctDesc.hashCode());
		result = prime * result + acctNum;
		long temp;
		temp = Double.doubleToLongBits(currAcctBal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((custFName == null) ? 0 : custFName.hashCode());
		result = prime * result + ((custLName == null) ? 0 : custLName.hashCode());
		result = prime * result + ((lastTrxnDt == null) ? 0 : lastTrxnDt.hashCode());
		temp = Double.doubleToLongBits(prevAcctBal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CustomerAcctView other = (CustomerAcctView) obj;
		if (acctDesc == null) {
			if (other.acctDesc != null)
				return false;
		} else if (!acctDesc.equals(other.acctDesc))
			return false;
		if (acctNum != other.acctNum)
			return false;
		if (Double.doubleToLongBits(currAcctBal) != Double.doubleToLongBits(other.currAcctBal))
			return false;
		if (custFName == null) {
			if (other.custFName != null)
				return false;
		} else if (!custFName.equals(other.custFName))
			return false;
		if (custLName == null) {
			if (other.custLName != null)
				return false;
		} else if (!custLName.equals(other.custLName))
			return false;
		if (lastTrxnDt == null) {
			if (other.lastTrxnDt != null)
				return false;
		} else if (!lastTrxnDt.equals(other.lastTrxnDt))
			return false;
		if (Double.doubleToLongBits(prevAcctBal) != Double.doubleToLongBits(other.prevAcctBal))
			return false;
		return true;
	}

	
	
	
	

}
