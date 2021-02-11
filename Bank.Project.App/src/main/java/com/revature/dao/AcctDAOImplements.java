package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.exceptions.DBConnException;
import com.revature.models.Account;
import com.revature.models.AccountBalView;

import com.revature.models.Transfers;
import com.revature.utils.ConnUtil;

public class AcctDAOImplements implements AcctDAO {
	
	private static Logger log=Logger.getLogger(AcctDAOImplements.class);
	
	public AcctDAOImplements() {
		super();
	}
	// Create New Bank Account
	@Override
	public int createAccount(int custID) throws SQLException, DBConnException {
		
		int createAcctCount = 0;
		try (Connection conn = ConnUtil.getConnection()){
			
			String insertAcctSQL = "INSERT INTO project_banking.account_tbl (cust_id, acct_num, acct_type, acct_desc) VALUES "
		             + "((SELECT cust_id FROM project_banking.customer_tbl WHERE cust_id = ?), "
		             + "(SELECT acct_num FROM project_banking.customer_tbl WHERE cust_id = ?),"
		             + "(SELECT acct_type FROM project_banking.customer_tbl WHERE cust_id = ?), 'Checking')";
			
			
			PreparedStatement newAcctPstmt = conn.prepareStatement(insertAcctSQL);
			
			newAcctPstmt.setInt(1, custID);
			newAcctPstmt.setInt(2, custID);	
			newAcctPstmt.setInt(3, custID);	
			
			newAcctPstmt.executeUpdate();
			
			System.out.println("New Bank Account has been successfully created for customer id: '" +  custID + "'");
			System.out.println();
			System.out.println();
			
			String insertTrxnSQL = "INSERT INTO project_banking.trxn_tbl (trxn_desc, acct_num, acct_type) VALUES "
		             + "(('New Checking Account was created'), "
		             + "(SELECT acct_num FROM project_banking.customer_tbl WHERE cust_id = ?),"
		             + "(SELECT acct_type FROM project_banking.customer_tbl WHERE cust_id = ?))";
			
			
			PreparedStatement newTrxnPstmt = conn.prepareStatement(insertTrxnSQL);
			
			newTrxnPstmt.setInt(1, custID);
			newTrxnPstmt.setInt(2, custID);	
			
			newTrxnPstmt.executeUpdate();
			
		} catch (SQLException e) {
			log.trace(e.getMessage());
		}			
		return createAcctCount;
	}

	// Update the Account table
		@Override
		public int updtAcct(Account acct) throws DBConnException {
			
			int udptAcctCount = 0;
			try(Connection conn = ConnUtil.getConnection()){
				
				String updtAcctSQL = "UPDATE project_banking.account_tbl SET acct_type = ?, app_date = DEFAULT, cust_init_dt = DEFAULT, "
						+ "cust_ssn = ?, cust_lname = ?, cust_lname = ?, cust_address = ?, cust_city = ?, cust_state = ?, cust_zip = ?,"
						+ "cust_DOB = ?, cust_phonenum = ?, acct_status = 'Standby' WHERE username = ?";
				
				PreparedStatement pstmt = conn.prepareStatement(updtAcctSQL);
				
				pstmt.setInt(1, acct.getCustID());
				pstmt.setInt(2, acct.getAcctNum());
				pstmt.setString(3, acct.getAcctType());
				pstmt.setString(4, acct.getAcctTypeDesc());
				
				udptAcctCount = pstmt.executeUpdate();
				
			} catch (DBConnException | SQLException e) {
				log.trace(e.getMessage());
			}
			
			return udptAcctCount;
		}

	// Update current balance with deposit and enter trxn record
	
	@Override
	public int depToAcct(int acctNum, double depAmt) {
		int depCount =0;
 		try(Connection conn = ConnUtil.getConnection()){
 			
 			String depSql = "UPDATE project_banking.account_tbl "
				      + "SET prev_acct_bal = curr_acct_bal, curr_acct_bal = (curr_acct_bal + "
				      + "MONEY(?)) WHERE acct_num = ?";
 			
 			PreparedStatement depPstmt = conn.prepareStatement(depSql);
 			depPstmt.setInt(1, (int) depAmt);
 			depPstmt.setInt(2, acctNum);
			
 			depCount = depPstmt.executeUpdate();
 			System.out.println(depCount + " deposit was made in the amount of '" + (double)depAmt + "' for Account Number: '" + acctNum + "'");
			
 			String insertTrxnSQL = "INSERT INTO project_banking.trxn_tbl (trxn_desc, acct_type, acct_num, trxn_amt) VALUES "
		             + "('Deposit', "
		             + "(SELECT acct_type FROM project_banking.customer_tbl WHERE acct_num = ?), ?, ?)";
 			
			PreparedStatement newTrxnPstmt = conn.prepareStatement(insertTrxnSQL);
			
			newTrxnPstmt.setInt(1, acctNum);
			newTrxnPstmt.setInt(2, acctNum);
			newTrxnPstmt.setInt(3, (int) depAmt);
			
			newTrxnPstmt.executeUpdate();
 			
 		}catch (DBConnException | SQLException e){
 			log.trace(e.getMessage());
 		} 
 		
		return depCount;	
	}
		
		

	// Retrieve current balance of account
	@Override
	public AccountBalView getAcctBalance (int acctNum) {
		
		AccountBalView acctBalVw = null;
		try(Connection conn = ConnUtil.getConnection()){
			String getBalSql = "SELECT curr_acct_bal FROM project_banking.account_tbl WHERE acct_num = ?";
			
			PreparedStatement balPstmt = conn.prepareStatement(getBalSql);
			balPstmt.setInt(1, acctNum);
			
			ResultSet rs = balPstmt.executeQuery();
			
			if (rs.next()) {
				acctBalVw = new AccountBalView(acctNum);
				double acctBal = rs.getDouble("curr_acct_bal");
				System.out.println(acctBal);
			}
 			
 		}catch (DBConnException | SQLException e){
 			log.trace(e.getMessage());
 		} 
		
		return acctBalVw;
	}	
	
	
	@Override	
	public int withdrawlFromAcct(int acctNum, double wdAmt) {
			int wdCount = 0;
			
			try (Connection conn = ConnUtil.getConnection()){
				String wdSql = "UPDATE project_banking.account_tbl "
					      + "SET prev_acct_bal = curr_acct_bal, curr_acct_bal = (curr_acct_bal - "
					      + "MONEY(?)) WHERE acct_num = ?";
				
				PreparedStatement wdPstmt = conn.prepareStatement(wdSql);
				wdPstmt.setInt(1, (int) wdAmt);
				wdPstmt.setInt(2, acctNum);
				
				wdCount = wdPstmt.executeUpdate();
				System.out.println(wdCount + " withdrawl was made in the amount of '" + (double)wdAmt + "' for Account Number: '" + acctNum + "'");
				
				//  Insert withdrawl into transactions table
				String insertTrxnSQL = "INSERT INTO project_banking.trxn_tbl (trxn_desc, acct_type, acct_num, trxn_amt) VALUES "
	             + "('Withrawl', "
	             + "(SELECT acct_type FROM project_banking.customer_tbl WHERE acct_num = ?), ?, ?)";
		
				PreparedStatement newTrxnPstmt = conn.prepareStatement(insertTrxnSQL);
				
				newTrxnPstmt.setInt(1, acctNum);
				newTrxnPstmt.setInt(2, acctNum);
				newTrxnPstmt.setInt(3, (int) wdAmt);
				
				newTrxnPstmt.executeUpdate();
				
			} catch (DBConnException | SQLException e){
				log.trace(e.getMessage());
			}	
				
			return wdCount;		
	}
	
	
	@Override
	public int postToAcct(Transfers transfer, Connection conn) {
			int recCount = 0;
					
			String postAmtSql = "INSERT INTO project_banking.transfer_tbl (transfer_to_amount, transfer_from_acct_num, transfer_to_acct_num) VALUES (?,?,?)";
			
			try {
				PreparedStatement postPstmt = conn.prepareStatement(postAmtSql);
				
				postPstmt.setInt(3, transfer.getTransAmt());
				postPstmt.setInt(2, transfer.getTransFromAcct()); 
				postPstmt.setInt(1, transfer.getTransToAcctNum());
				
				recCount = postPstmt.executeUpdate();
				
				String insertTrxnSQL = "INSERT INTO project_banking.trxn_tbl (trxn_desc, acct_type, acct_num, trxn_amt) VALUES "
			             + "('Deposit was made to account', "
			             + "(SELECT acct_type FROM project_banking.customer_tbl WHERE acct_num = ?), ?, ?)";
	 			
				PreparedStatement newTrxnPstmt = conn.prepareStatement(insertTrxnSQL);
				
				newTrxnPstmt.setInt(1, transfer.getTransToAcctNum());
				newTrxnPstmt.setInt(2, (int) transfer.getTransAmt());
				
				newTrxnPstmt.executeUpdate();
				
			} catch (SQLException e) {
				log.trace(e.getMessage());
			}
			
			return recCount;
	}
	
	
	@Override
	public int getTransfer(int acctNum) throws DBConnException {
			int recCount = 0;
			//System.out.println("acctNum: " + acctNum);
			try(Connection conn = ConnUtil.getConnection()){
				
				String recvAmtSql = "UPDATE account_tbl SET account_tbl.prev_acct_bal = account_tbl.curr_acct_bal, account_tbl.curr_acct_bal = "
					+ "(SELECT SUM(account_tbl.curr_acct_bal + transfer_tbl.transfer_to_amount WHERE account_tbl.acct_num = ? ) FROM project_banking.account_tbl "
					+ "INNER JOIN project_banking.transfer_tbl ON account_tbl.acct_num = transfer_tbl.transfer_to_acct_num) WHERE acct_num = ?";
				
				//System.out.println("Sql: " + recvAmtSql);
			
				PreparedStatement transPstmt = conn.prepareStatement(recvAmtSql);
				
				transPstmt.setInt(1, acctNum);
				
				recCount = transPstmt.executeUpdate(recvAmtSql);
				
				System.out.println("PSTMT: " + transPstmt);
				
	 			System.out.println(recCount + " Transfer was made for Account Number: '" + acctNum + "'");
				
	 			String insertTrxnSQL = "INSERT INTO project_banking.trxn_tbl (trxn_desc, acct_type, acct_num, trxn_amt) VALUES "
			             + "('Transfer', "
			             + "(SELECT acct_type FROM project_banking.customer_tbl WHERE acct_num = ?), ?, ?)";
	 			
				PreparedStatement newTrxnPstmt = conn.prepareStatement(insertTrxnSQL);
				
				newTrxnPstmt.setInt(1, acctNum);
				
				newTrxnPstmt.executeUpdate();
	 			
	 		}catch (DBConnException | SQLException e){
	 			log.trace(e.getMessage());
	 		} 
 		
		return recCount;	
	}
	@Override
	public int updtTransfer(int acctNum) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getTransfer(Transfers transfer, Connection conn) throws DBConnException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getTransfer(Transfers transfer) throws DBConnException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
			
}
