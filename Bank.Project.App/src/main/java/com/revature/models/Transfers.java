package com.revature.models;

public class Transfers {
	
	private int transAmt;
	private int transFromAcct;
	private int transToAcctNum;
	
	public Transfers(int acctNum) {
		super();
	}
	
	public Transfers(int transToAcctNum, int transAmt, int transFromAcct) {
		
		this.transAmt = transAmt;
		this.transFromAcct = transFromAcct;
		this.transToAcctNum = transToAcctNum;
	}

	public int getTransToAcctNum() {
		return transToAcctNum;
	}

	public void setTransToAcctNum(int transToAcctNum) {
		this.transToAcctNum = transToAcctNum;
	}

	public int getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(int transAmt) {
		this.transAmt = transAmt;
	}

	public int getTransFromAcct() {
		return transFromAcct;
	}

	public void setTransFromAcct(int transFromAcct) {
		this.transFromAcct = transFromAcct;
	}

	@Override
	public String toString() {
		return "Transfers [transToAcctNum=" + transToAcctNum + ", transAmt=" + transAmt + ", transFromAcct="
				+ transFromAcct + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transAmt;
		result = prime * result + transFromAcct;
		result = prime * result + transToAcctNum;
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
		Transfers other = (Transfers) obj;
		if (transAmt != other.transAmt)
			return false;
		if (transFromAcct != other.transFromAcct)
			return false;
		if (transToAcctNum != other.transToAcctNum)
			return false;
		return true;
	}
	
	

}
