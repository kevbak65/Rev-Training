package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.DBConnException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.NewCustomer;
import com.revature.utils.ConnUtil;

public class EmpDAOImplements implements EmpDAO {

	
	// Employee login verification
	@Override
	public Employee getEmpByUserName(String empUserName, String empPswd) {
		Employee emp = null;
		try (Connection conn = ConnUtil.getConnection()){
			String sql = "SELECT emp_username, emp_password FROM project_banking.employee_tbl WHERE employee_tbl.emp_username = ? AND employee_tbl.emp_password  = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empUserName);
			pstmt.setString(2, empPswd);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				emp = new Employee(empUserName, empPswd);
			}		
					
		} catch (DBConnException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}
	
	// Retrieve Customer records that are on Standby:
	@Override
	public List<NewCustomer> getNewCustomers() throws DBConnException{ 
	
		List<NewCustomer> newCustList = new ArrayList<>();
		
		try (Connection conn = ConnUtil.getConnection()){
			String sql = "SELECT cust_ID, acct_type, app_date, cust_ssn, cust_lname, cust_fname, cust_address, cust_city, cust_state, "
					+ "cust_zip, cust_DOB, cust_phonenum, acct_status FROM project_banking.customer_tbl WHERE customer_tbl.acct_status ="
					+ " 'Standby'";

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
	public NewCustomer getCustByAppStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateAppStatus(int custID, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTrxns(Employee emp) throws DBConnException {
		// TODO Auto-generated method stub
		return 0;
	}


	


}
