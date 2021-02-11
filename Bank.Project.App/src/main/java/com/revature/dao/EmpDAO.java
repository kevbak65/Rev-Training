package com.revature.dao;

import java.util.List;


import com.revature.exceptions.DBConnException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.NewCustomer;

public interface EmpDAO {
	
	public Employee getEmpByUserName(String empUserName, String empPswd);
	public NewCustomer getCustByAppStatus(String status);
	public List<NewCustomer> getNewCustomers() throws DBConnException;
	public Customer updateAppStatus(int custID, String status);
	public int getTrxns(Employee emp) throws DBConnException;
}
