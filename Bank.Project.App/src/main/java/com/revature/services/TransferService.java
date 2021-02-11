package com.revature.services;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.AcctDAO;
import com.revature.dao.AcctDAOImplements;
import com.revature.exceptions.DBConnException;
import com.revature.models.Transfers;
import com.revature.utils.ConnUtil;

public class TransferService {
	
	private static Logger log=Logger.getLogger(TransferService.class);
	
	public AcctDAO acctDAO;
	
	public TransferService() {
		acctDAO = new AcctDAOImplements();
	}
	
	public int postToAcct(int trnsAmt, int trnsFromAcct, int trnsToAcct) {
		
		int count = 0;
		
		Transfers transfer = new Transfers(trnsAmt, trnsFromAcct, trnsToAcct);
		
		try (Connection conn = ConnUtil.getConnection()){
			conn.setAutoCommit(false);
			
			count = acctDAO.postToAcct(transfer, conn);
			
			conn.commit();
			
			System.out.println("Trans Amount of: " + trnsAmt + " was posted to account '" + transfer.getTransToAcctNum() + " successfully.");
			
		} catch (SQLException | DBConnException e) {
			log.trace(e.getMessage());
		}
		
		return count;
	}
	
	public int getTransfer(int acctNum) {
		int updtCount = 0;
		
		System.out.println(" In gettransfer method in service");
	    System.out.println(" Transfer service ");
	    
	    Transfers  transfer = new Transfers(acctNum);
	    
		try (Connection conn = ConnUtil.getConnection()){
			
			conn.setAutoCommit(false);
			updtCount = acctDAO.getTransfer(acctNum);
			conn.commit();
			
		}catch (SQLException | DBConnException e) {
			log.trace(e.getMessage());
		}
		
		return updtCount;
			
	}
	
}
