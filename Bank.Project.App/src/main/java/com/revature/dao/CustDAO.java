package com.revature.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.exceptions.DBConnException;
//import com.revature.exceptions.NoRecordFound;
import com.revature.models.Customer;
import com.revature.models.NewCustomer;

public interface CustDAO {
	
	public int createCustomer(Customer customer, Connection conn) throws SQLException;
	public int updtCust(Customer customer) throws DBConnException;
	public Customer getCustStatusByID(int cust_id);
	public int updateAppStatus(int custID, String appStatus) throws DBConnException;
	public List<NewCustomer> getNewCustomers();
	public Customer getCustByAcctNum(int acctNum);
	
	
	

}
