package com.revature.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.AcctDAOImplements;
import com.revature.dao.CustDAO;
import com.revature.dao.CustDAOImplements;
import com.revature.exceptions.DBConnException;
import com.revature.exceptions.NoRecordFound;
import com.revature.models.Customer;
import com.revature.models.NewCustomer;
import com.revature.utils.ConnUtil;

public class CustomerService {
	
	private static Logger log=Logger.getLogger(AcctDAOImplements.class);
	
	public CustDAO custDAO;
	
	public CustomerService() {
		custDAO = new CustDAOImplements();
	}
	
	// Get customer record
	public int createCustomer(String acctType, String custSSN, String custLName , String custFName, String custAddress, String custCity, 
			                  String custState, String custZip, String custDOB , String custPhoneNum, String userName, String userPswd) throws DBConnException{
		
		int count = 0;
	
		Customer customer = new Customer(acctType, custSSN, custLName, custFName, custAddress, custCity, custState, custZip, custDOB, custPhoneNum, 
				                         userName, userPswd);
		
		try (Connection conn = ConnUtil.getConnection()){
			conn.setAutoCommit(false);
			
			count = custDAO.createCustomer(customer, conn);
			
			conn.commit();
		} catch (SQLException | DBConnException e) {
			log.trace(e.getMessage());
		}
		
		return count;
	}
	
	public Customer getCustStatusByID(int custID, String appStatus) throws NoRecordFound {
		
		Customer cust = custDAO.getCustStatusByID(custID);
		
		if (cust != null) {
			return cust;
		} else {
			throw new NoRecordFound("No customer account for id '" + custID + "' was fouund!");
		}
			
	}
	
	// Retrieve Customer by Account Number
	public Customer getCustByAcctNum(int acctNum) throws NoRecordFound {
		
		Customer customer = custDAO.getCustByAcctNum(acctNum);
		
		//System.out.println("In the Customer getCustByAcctNum method in CustomerService");
		
		if (customer != null) {
			//System.out.println(customer);
			return customer;
			
		} else {
			throw new NoRecordFound("No customer account for id '" + acctNum + "' was fouund!");
		}
			
	}
	
	//  Retrieve all new customers with Standby status
	public List<NewCustomer> getNewCustomer(String status) throws NoRecordFound, DBConnException{
		List<NewCustomer> newCustList = custDAO.getNewCustomers();
		
		if (newCustList != null) {
			return newCustList;
		} else {
			throw new NoRecordFound("No standby customers were found.");
		}
	}
	
	// Udpate Customer Record
	public int updateAppStatus(int custID, String appStatus) {
		int updtCount = 0;
		
		try (Connection conn = ConnUtil.getConnection()){
			conn.setAutoCommit(false);
			updtCount = custDAO.updateAppStatus(custID, appStatus);
			conn.commit();
		} catch (SQLException | DBConnException e) {
			System.out.println(e.getMessage());
		}
		
		return updtCount;
	}
	

}
