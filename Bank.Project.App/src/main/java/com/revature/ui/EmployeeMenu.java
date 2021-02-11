package com.revature.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

//import com.revature.models.Customer;
import com.revature.dao.TrxnsDAO;
import com.revature.models.CustomerAcctView;
import com.revature.models.NewCustomer;
import com.revature.models.Transactions;
import com.revature.services.AccountService;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;
import com.revature.utils.ConnUtil;
import com.revature.dao.CustDAO;
import com.revature.dao.CustDAOImplements;
import com.revature.exceptions.DBConnException;

import com.revature.dao.TrxnsDAOImplements;
import com.revature.services.TrxnService;

public class EmployeeMenu implements Menu {
	
public EmployeeService empService;
public CustomerService custService;
public AccountService acctService;
public TrxnService trxnSercive;
	
	public EmployeeMenu() {
		empService = new EmployeeService();
		custService = new CustomerService();
		acctService = new AccountService();
		trxnSercive = new TrxnService();
	}

	@Override
	public void display() {
		
		int choice = 0;
		 
		 do {
			 System.out.println("             EMPLOYEE MENU                 ");
			 System.out.println("*******************************************");
			 System.out.println("*  (1) Accept/Reject New Accounts         *");
			 System.out.println("*  (2) Create New Customer Account        *");
			 System.out.println("*  (3) View Customer Account              *");
			 System.out.println("*  (4) View Customer Transaction History  *");
			 System.out.println("*  (5) Exit Menu                           ");
			 System.out.println("===========================================");
			 
			 try {
				 
				 choice = Integer.parseInt(Menu.sc.nextLine());
				 
			 } catch (NumberFormatException e){
			 }
			 
			 switch (choice) {
			 	case 1:
			 		//  Select all customers that are on standby
			 		CustDAO custDao = new CustDAOImplements();
					List<NewCustomer> newCustomers = custDao.getNewCustomers();
				
					if (newCustomers.isEmpty()) {
						System.out.println(" *** There are no new Customers to review. ***");
					} else {
						System.out.println(newCustomers);
						System.out.println("<<<<<<<<<<  Accept/Reject New Customer >>>>>>>>>>");
						int custID = getCustIDInput();
						String appStatus = getAcceptInput();
						custService.updateAppStatus(custID, appStatus);
					}
					
			 		break;
			 		
			 	case 2:
			 		System.out.println("<<<<<<<<<<  Create New Bank Account >>>>>>>>>>");
			 		int newCustID = getNewCustIDInput();
			 		acctService.createAcct(newCustID);
			 		break;
			 		
			 	case 3:
			 		System.out.println("<<<<<<<<<<  View Coustomer Account >>>>>>>>>>");
			 		System.out.println();
			 		int acctNum = getAcctNumInput();
			 		
			 		CustomerAcctView custCAV = null;
			 		try(Connection conn = ConnUtil.getConnection()){
			 			String custSql = "SELECT customer_tbl.cust_fname, customer_tbl.cust_lname, account_tbl.acct_desc, account_tbl.acct_num, "
						               + "account_tbl.curr_acct_bal, account_tbl.prev_acct_bal, account_tbl.last_activity_date " 
								       + "FROM project_banking.customer_tbl INNER JOIN project_banking.account_tbl "
								       + "ON account_tbl.acct_num = customer_tbl.acct_num "
								       + "WHERE customer_tbl.acct_num = ?"; 
			 			PreparedStatement custPstmt = conn.prepareStatement(custSql);
			 			custPstmt.setInt(1, acctNum);
			 			ResultSet rs = custPstmt.executeQuery();
			 			if (rs.next()) {
			 				String custFName = rs.getString("cust_fname");
							String custLName = rs.getString("cust_lname");
							String acctDesc = rs.getString("acct_desc");
							double currAcctBal = rs.getDouble("curr_acct_bal");
							double prevAcctBal = rs.getDouble("curr_acct_bal");
							String lastTrxnDt = rs.getString("last_activity_date");
							
			 				custCAV = new CustomerAcctView(acctNum, custFName, custLName, currAcctBal, prevAcctBal, acctDesc, lastTrxnDt);
			 			}
			 			System.out.println(custCAV);
			 			System.out.println();
			 		}catch (DBConnException | SQLException e){
				 			System.out.println(e.getMessage());
			 		}
			 		break;
			 	
			 	case 4:// ****  Set up as list ***
			 		System.out.println("<<<<<<<<<<  View Account Transactions >>>>>>>>>>");
			 		
			 		TrxnsDAO trxnDAO = new TrxnsDAOImplements();
			 		List<Transactions> trxns = trxnDAO.getTrxns();
			 		
					if (trxns.isEmpty()) {
						System.out.println(" *** There are no transactions to view. ***");
					} else {
						System.out.println(trxns);
					}
			 		
			 		break;
			 		
			 	case 5:
			 		Menu mainMenu = new MainMenu();
			 		mainMenu.display();
			 		break;
			 		
			 	default:
			 		System.out.println("Invalid Selection entered.  Please try again.....");
			 		break;
			 }
		 } while (choice != 4);
		
	}
	
	public int getCustIDInput() {
		
		int custID;
		
		while (true) {
			try {
				System.out.println("Enter Customer ID: ");
				custID = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e){
				System.out.println("Invalid input. Please re-enter value.");
				continue;
			}
			break;
		}
		return custID;
	}
	
	public int getNewCustIDInput() {
		
		int newCustID;
		
		while (true) {
			try {
				System.out.println("Enter Customer ID: ");
				newCustID = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e){
				System.out.println("Invalid input. Please re-enter value.");
				continue;
			}
			break;
		}
		return newCustID;
	}
	
	public String getAcceptInput() {
		System.out.println("Enter Decision (Accept/Reject): ");
		String appStatus = Menu.sc.nextLine();
		return appStatus;
	}
	
	public int getAcctNumInput() {
		System.out.println("Enter Customer Account Number: ");
		int acctNum = Integer.parseInt(Menu.sc.nextLine());
		return acctNum;
	}
		 
}
