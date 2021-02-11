package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.revature.exceptions.DBConnException;
//import com.revature.exceptions.NoRecordFound;
import com.revature.models.Customer;
import com.revature.models.NewCustomer;
import com.revature.utils.ConnUtil;

public class CustDAOImplements implements CustDAO {

	// Create new customer record
	@Override
	public int createCustomer(Customer customer, Connection conn) throws SQLException {
		int createCount = 0;
			
			String insertSQL = "INSERT INTO project_banking.customer_tbl (acct_type, cust_ssn, cust_lname, cust_fname, "
					         + "cust_address, cust_city, cust_state, cust_zip, "
					         + "cust_DOB, cust_phonenum, username, user_password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			
			pstmt.setString(1, customer.getAcctType());
			pstmt.setString(2, customer.getCustSSN());
			pstmt.setString(3, customer.getCustLName());
			pstmt.setString(4, customer.getCustFName());
			pstmt.setString(5, customer.getCustAddress());
			pstmt.setString(6, customer.getCustCity());
			pstmt.setString(7, customer.getCustState());
			pstmt.setString(8, customer.getCustZip());
			pstmt.setString(9, customer.getCustDOB());
			pstmt.setString(10, customer.getCustPhoneNum());
			pstmt.setString(11, customer.getUserName());
			pstmt.setString(12, customer.getUserPswd());
			
			createCount = pstmt.executeUpdate();
		
		return createCount;
	}
	
	// Update the Customer tbl
	@Override
	public int updtCust(Customer customer) throws DBConnException {
	
		//Customer customer = null;
		int udptCount = 0;
		try(Connection conn = ConnUtil.getConnection()){
			
			String updtSQL = "UPDATE project_banking.customer_tbl SET acct_type = ?, app_date = DEFAULT, cust_init_dt = DEFAULT, "
					+ "cust_ssn = ?, cust_lname = ?, cust_lname = ?, cust_address = ?, cust_city = ?, cust_state = ?, cust_zip = ?,"
					+ "cust_DOB = ?, cust_phonenum = ?, acct_status = 'Standby' WHERE username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(updtSQL);
			pstmt.setString(1, customer.getAcctType());
			pstmt.setString(2, customer.getCustSSN());
			pstmt.setString(3, customer.getCustLName());
			pstmt.setString(4, customer.getCustFName());
			pstmt.setString(5, customer.getCustAddress());
			pstmt.setString(6, customer.getCustCity());
			pstmt.setString(7, customer.getCustState());
			pstmt.setString(8, customer.getCustZip());
			pstmt.setString(9, customer.getCustDOB());
			pstmt.setString(10, customer.getCustPhoneNum());
			
			udptCount = pstmt.executeUpdate();
			
		} catch (DBConnException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return udptCount;
	}

	// Retrieve Customer Customer ID
	@Override
	public Customer getCustStatusByID(int cust_id) {
		Customer cust = null;
		try (Connection conn = ConnUtil.getConnection()){
			String getCustSQL = "SELECT cust_id, acct_type, acct_num, cust_init_dt, cust_lname, cust_fname, acct_status FROM project_banking.customer_tbl "
					+ "WHERE customer_tbl.cust_ID = ?";
			
			PreparedStatement getPStmt = conn.prepareStatement(getCustSQL);
			getPStmt.setInt(1, cust_id);
			
			ResultSet rs = getPStmt.executeQuery();
			
			if (rs.next()) {
				int custID = rs.getInt("cust_id");
				String acctType = rs.getString("acct_type");
				int acctNum = rs.getInt("acct_num");
				String initDt = rs.getString("cust_init_dt");
				String custLName = rs.getString("cust_lname");
				String custFName = rs.getString("cust_fname");
				String acctStatus = rs.getString("acct_status");
			}	 
		} catch (DBConnException | SQLException e){
			System.out.println(e.getMessage());
		}
		return cust;
	}
	


    //  Update the New Customer App status
	@Override
	public int updateAppStatus(int custID, String appStatus) throws DBConnException {
		
		int updtCount = 0;
		try (Connection conn = ConnUtil.getConnection()){
			
			String updtSQL = "UPDATE project_banking.customer_tbl SET acct_status = ? WHERE cust_id = ?";
			PreparedStatement updtPStmt = conn.prepareStatement(updtSQL);	
			
			updtPStmt.setString(1, appStatus);
			updtPStmt.setInt(2, custID);
			
			updtCount = updtPStmt.executeUpdate();
			
			System.out.println(updtCount + " record(s) were updated for '" + custID + "'");
			
		} catch (SQLException e) {
			throw new DBConnException("Connection error when updating application status.");
		}
		return updtCount;	
	}

	// Retrieve all New Customers that are in 'Standby' status
	@Override
	public List<NewCustomer> getNewCustomers() { 
	
		List<NewCustomer> newCustList = new ArrayList<>();
		
		try (Connection conn = ConnUtil.getConnection()){
			String sql = "SELECT cust_ID, acct_type, app_date, cust_ssn, cust_lname, cust_fname, cust_address, cust_city, cust_state, cust_zip, cust_DOB, "
					   + "cust_phonenum, acct_status FROM project_banking.customer_tbl WHERE customer_tbl.acct_status = 'Standby'";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				NewCustomer newCust = new NewCustomer(); 

				newCust.setCustID(rs.getInt("cust_id"));
				newCust.setAcctType(rs.getString("acct_type"));
				newCust.setAppDate(rs.getString("app_date"));
				newCust.setCustSSN(rs.getString("cust_SSN"));
				newCust.setCustLName(rs.getString("cust_lname"));
				newCust.setCustFName(rs.getString("cust_fname"));
				newCust.setCustAddress(rs.getString("cust_address"));
				newCust.setCustCity(rs.getString("cust_city"));
				newCust.setCustState(rs.getString("cust_state")); 
				newCust.setCustZip(rs.getString("cust_zip"));
				newCust.setCustDOB(rs.getString("cust_DOB"));	
				newCust.setCustPhoneNum(rs.getString("cust_phonenum"));
				newCust.setAppStatus(rs.getString("acct_status"));
				
				newCustList.add(newCust);
			}
						
		} catch (DBConnException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return newCustList;
		
	}

	@Override
	public Customer getCustByAcctNum(int acctNum) {
		Customer cust = null;
		System.out.println("In the Customer getCustByAcctNum method in CustDAOImplements");
		try (Connection conn = ConnUtil.getConnection()){
			
			String getCustSQL = "SELECT customer_tbl.cust_fname, customer_tbl.cust_lname, account_tbl.acct_desc, account_tbl.acct_num, "
					          + "account_tbl.acct_balance, account_tbl.init_date " 
							  + "FROM project_banking.customer_tbl INNER JOIN project_banking.account_tbl "
							  + "ON account_tbl.acct_num = customer_tbl.acct_num "
							  + "WHERE customer_tbl.acct_num = ?"; 

			PreparedStatement pstmt = conn.prepareStatement(getCustSQL);
			pstmt.setInt(1, acctNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String custFName = rs.getString("cust_fname");
				String custLName = rs.getString("cust_lname");
				String acctDesc = rs.getString("acct_desc");
				double acctBal = rs.getDouble("acct_balance");
				String lastTrxnDt = rs.getString("init_date");

				cust = new Customer(custFName, custLName, acctDesc, acctBal, lastTrxnDt);
			}
			
		} catch (DBConnException | SQLException e){
			System.out.println(e.getMessage());
		}
		return cust;
	}

	
	
}
	
	
	
	
	
	
	
	

	
	

	


