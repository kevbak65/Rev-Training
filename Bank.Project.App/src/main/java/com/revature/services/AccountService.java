package com.revature.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.AcctDAO;
import com.revature.dao.AcctDAOImplements;
import com.revature.exceptions.DBConnException;
import com.revature.exceptions.NoRecordFound;

import com.revature.models.AccountBalView;
import com.revature.models.Transfers;
import com.revature.utils.ConnUtil;

public class AccountService {
	
	private static Logger log=Logger.getLogger(AcctDAOImplements.class);
	
		public AcctDAO acctDAO;
		
		public AccountService() {
			acctDAO = new AcctDAOImplements();
		}
		
		// Create new account record
		public int createAcct(int custID) {
		
			int count = 0;
		
			try (Connection conn = ConnUtil.getConnection()){
				conn.setAutoCommit(false);
			
				count = acctDAO.createAccount(custID);
				
				conn.commit();
			} catch (SQLException | DBConnException e) {
				log.trace(e.getMessage());
			}
			
			return count;
		}
		
		public double getAcctBalance(int wdAmt) throws NoRecordFound {
			AcctDAO acctDAO = new AcctDAOImplements();
			AccountBalView acctBalVw = null;
		
			acctBalVw = acctDAO.getAcctBalance((int) wdAmt);
			System.out.println("In the AccountBalView getAcctBalance method in CustomerService");
			
			if (acctBalVw != null) {
				return(acctBalVw.getAcctBal());	
			} else {
				throw new NoRecordFound("No customer account for id '" + wdAmt + "' was fouund!");
			}
				
		}
		
		// Update account balance
			
		public int depToAcct(int acctNum, double depAmt) {
			
			int count = 0;
			
			try (Connection conn = ConnUtil.getConnection()){
				conn.setAutoCommit(false);
				
				count = acctDAO.depToAcct(acctNum, depAmt);
				
				conn.commit();
			} catch (SQLException | DBConnException e) {
				log.trace(e.getMessage());
			}
			
			return count;
		}
		
		public int withdrawlFromAcct(int acctNum, double wdAmt) {
			
			int count = 0;
		
			try (Connection conn = ConnUtil.getConnection()){
				conn.setAutoCommit(false);
				
				count = acctDAO.withdrawlFromAcct(acctNum, wdAmt);
				
				conn.commit();
			} catch (SQLException | DBConnException e) {
				log.trace(e.getMessage());
			}
			
			return count;
		}
		
		public int postToAcct(int trnsAmt, int trnsFromAcct, int trnsToAcct) {
			
			int count = 0;
			
			System.out.println("before Transfer instatiation line");
			Transfers transfer = new Transfers(trnsAmt, trnsFromAcct, trnsToAcct);
			System.out.println("after Transfer instatiation line");
			
			try (Connection conn = ConnUtil.getConnection()){
				conn.setAutoCommit(false);
				
				count = acctDAO.postToAcct(transfer, conn);
				
				System.out.println("Trans Amount: " + trnsAmt);
				
				conn.commit();
			} catch (SQLException | DBConnException e) {
				log.trace(e.getMessage());
			}
			
			return count;
		}

}
