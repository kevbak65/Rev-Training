package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.exceptions.DBConnException;
import com.revature.models.Account;
import com.revature.models.AccountBalView;
import com.revature.models.Transfers;

public interface AcctDAO {
	

	public int updtAcct(Account acct) throws DBConnException;
	public int createAccount(int custID) throws SQLException, DBConnException;
	public int depToAcct(int acctNum, double depAmt);
	public AccountBalView getAcctBalance(int acctNum);
	public int withdrawlFromAcct(int acctNum, double wdAmt);
	public int postToAcct(Transfers transfer, Connection conn);
	public int updtTransfer(int acctNum);
	public int getTransfer(int acctNum) throws DBConnException;
	public int getTransfer(Transfers transfer, Connection conn) throws DBConnException;
	public int getTransfer(Transfers transfer) throws DBConnException;
	
	
	
	
}