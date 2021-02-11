package com.revature.models;

public class Transactions {
	
	private int trxnID;
	private	String trxnDtTime;
	private	String trxnDesc;
	private	String acctType; 
	private	int tacctNum;
	private	double trxnAmt;
	
	
	public Transactions() {
		super();
	}
	
	public Transactions(int trxnID, String trxnDtTime, String trxnDesc, String acctType, int tacctNum, double trxnAmt) {
		this.trxnID = trxnID;
		this.trxnDtTime = trxnDtTime;
		this.trxnDesc = trxnDesc;
		this.acctType = acctType;
		this.tacctNum = tacctNum;
		this.trxnAmt = trxnAmt;
	}


	public int getTrxnID() {
		return trxnID;
	}


	public void setTrxnID(int trxnID) {
		this.trxnID = trxnID;
	}


	public String getTrxnDtTime() {
		return trxnDtTime;
	}


	public void setTrxnDtTime(String trxnDtTime) {
		this.trxnDtTime = trxnDtTime;
	}


	public String getTrxnDesc() {
		return trxnDesc;
	}


	public void setTrxnDesc(String trxnDesc) {
		this.trxnDesc = trxnDesc;
	}


	public String getAccctType() {
		return acctType;
	}


	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}


	public int getTacctNum() {
		return tacctNum;
	}


	public void setTacctNum(int tacctNum) {
		this.tacctNum = tacctNum;
	}


	public double getTrxnAmt() {
		return trxnAmt;
	}


	public void setTrxnAmt(double trxnAmt) {
		this.trxnAmt = trxnAmt;
	}


	@Override
	public String toString() {
		return "Transactions [trxnID=" + trxnID + ", trxnDtTime=" + trxnDtTime + ", trxnDesc=" + trxnDesc
				+ ", acctType=" + acctType + ", tacctNum=" + tacctNum + ", trxnAmt=" + trxnAmt + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctType == null) ? 0 : acctType.hashCode());
		result = prime * result + tacctNum;
		long temp;
		temp = Double.doubleToLongBits(trxnAmt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((trxnDesc == null) ? 0 : trxnDesc.hashCode());
		result = prime * result + ((trxnDtTime == null) ? 0 : trxnDtTime.hashCode());
		result = prime * result + trxnID;
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
		Transactions other = (Transactions) obj;
		if (acctType == null) {
			if (other.acctType != null)
				return false;
		} else if (!acctType.equals(other.acctType))
			return false;
		if (tacctNum != other.tacctNum)
			return false;
		if (Double.doubleToLongBits(trxnAmt) != Double.doubleToLongBits(other.trxnAmt))
			return false;
		if (trxnDesc == null) {
			if (other.trxnDesc != null)
				return false;
		} else if (!trxnDesc.equals(other.trxnDesc))
			return false;
		if (trxnDtTime == null) {
			if (other.trxnDtTime != null)
				return false;
		} else if (!trxnDtTime.equals(other.trxnDtTime))
			return false;
		if (trxnID != other.trxnID)
			return false;
		return true;
	}
	
	

}
