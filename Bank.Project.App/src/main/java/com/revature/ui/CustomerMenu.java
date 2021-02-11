package com.revature.ui;

import com.revature.services.AccountService;
import com.revature.services.CustomerService;
import com.revature.services.TransferService;
import com.revature.utils.ConnUtil;
import com.revature.exceptions.DBConnException;

import com.revature.models.CustomerAcctView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class CustomerMenu implements Menu {
	
	private static Logger log=Logger.getLogger(TransferService.class);
	

public CustomerService custService;
public AccountService acctService;
	
	public CustomerMenu() {
		custService = new CustomerService();
		acctService = new AccountService();
	}
	
	@Override
	public void display() {
		 int choice = 0;
		 
		 do {
			 System.out.println("     CUSTOMER ACCOUNT MENU      ");
			 System.out.println("********************************");
			 System.out.println("  (1) View Application Status   ");
			 System.out.println("  (2) View Balance Information  ");
			 System.out.println("  (3) Make a Deposit            ");
			 System.out.println("  (4) Make a Withdrawl          ");
			 System.out.println("  (5) Account Transfers         ");
			 System.out.println("  (6) Exit Menu                 ");
			 System.out.println("================================");
			 
			 try {
				 
				 choice = Integer.parseInt(Menu.sc.nextLine());
				 
			 } catch (NumberFormatException e){
			 }
			 
			 switch (choice) {
			 	case 1:
			 		System.out.println();
			 		
			 		break;
			 		
			 	case 2:
			 		System.out.println("<<<<<<<<<<  View Account Balance >>>>>>>>>>");
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
							double prevAcctBal = rs.getDouble("prev_acct_bal");
							String lastTrxnDt = rs.getString("last_activity_date");
							
			 				custCAV = new CustomerAcctView(acctNum, custFName, custLName, currAcctBal, prevAcctBal, acctDesc, lastTrxnDt);
			 			} 
			 			System.out.println(custCAV);
			 			System.out.println();
			 		}catch (DBConnException | SQLException e){
			 			log.trace(e.getMessage());
			 		}
			 		break;
			 		
			 	case 3:
			 		System.out.println("<<<<<<<<<<  Deposit to Checking >>>>>>>>>>");
			 		System.out.println();
			 		int acctNumDep = getAcctNumInput();
			 		double depAmt = getDepAmtInput();
			 		
			 		if (depAmt > 0) {
			 			acctService.depToAcct(acctNumDep, depAmt);
			 		}else {
			 			System.out.println("A positive amount is required for a deposit.  Please try again!");
			 		}
			 		break;
			 		
			 	case 4:
			 		System.out.println("<<<<<<<<<<  Withdrawl from Account >>>>>>>>>>");
			 		System.out.println();
			 		int acctNumWD = getAcctNumInput();
			 		double wdAmt = getWDAmtInput();
			 
			 		acctService.withdrawlFromAcct(acctNumWD, wdAmt);
			 		
			 		break;
			 		
			 	case 5:
			 		Menu transferMenu = new TransfersMenu();
			 		transferMenu.display();
			 		break;
			 		
			 	case 6:
			 		Menu mainMenu = new MainMenu();
			 		mainMenu.display();
			 		break;

			 	default:
			 		System.out.println("Invalid Selection entered.  Please try again.....");
			 		break;
			 }
			  
		 } while (choice != 7);

	}
	
	public int getAcctNumInput() {
		System.out.println("Enter Account Number: ");
		int acctNum = Integer.parseInt(Menu.sc.nextLine());
		return acctNum;
	}
	
	public double getDepAmtInput() {
		System.out.println("Enter Deposit Amount: ");
		double depAmt = Integer.parseInt(Menu.sc.nextLine());
		return depAmt;
	}
	
	public double getWDAmtInput() {
		System.out.println("Enter Withdrawl Amount: ");
		double wdAmt = Integer.parseInt(Menu.sc.nextLine());
		return wdAmt;
	}

}
