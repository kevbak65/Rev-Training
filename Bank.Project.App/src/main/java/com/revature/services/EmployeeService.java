package com.revature.services;

import java.util.List;

import com.revature.dao.EmpDAO;
import com.revature.dao.EmpDAOImplements;
//import com.revature.dao.EmpDAOImplements;
import com.revature.exceptions.DBConnException;
import com.revature.exceptions.NoRecordFound;
import com.revature.models.NewCustomer;

//import com.revature.models.Employee;

public class EmployeeService {
	
	public EmpDAO empDAO;
	
	public EmployeeService() {
		empDAO = new EmpDAOImplements();
	}
	
	
			
	public List<NewCustomer> getNewCustomer(String status) throws NoRecordFound, DBConnException{
		List<NewCustomer> newCustList = empDAO.getNewCustomers();
		
		if (newCustList != null) {
			return newCustList;
		} else {
			throw new NoRecordFound("No standby customers were found.");
		}
	}
	
	

}
