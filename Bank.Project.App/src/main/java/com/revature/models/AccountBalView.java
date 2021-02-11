package com.revature.models;

public class AccountBalView {
	
	//private int acctID;
	//private int acctNum;
	//private String acctType;
	//private String acctTypeDesc;
	private int acctBal;
	//private String initDate;
	//private int custID;
	
	
	public AccountBalView(int acctBal) {
		this.acctBal = acctBal;
	}


	public double getAcctBal() {
		return acctBal;
	}


	@Override
	public String toString() {
		return "AccountBalView [acctBal=" + acctBal + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(acctBal);
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
		AccountBalView other = (AccountBalView) obj;
		if (Double.doubleToLongBits(acctBal) != Double.doubleToLongBits(other.acctBal))
			return false;
		return true;
	}

	
	

	

	

	
	
	
}
