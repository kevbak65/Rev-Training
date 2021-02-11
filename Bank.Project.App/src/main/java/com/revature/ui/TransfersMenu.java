package com.revature.ui;

import com.revature.services.AccountService;
import com.revature.services.TransferService;

//import org.apache.log4j.Logger;

public class TransfersMenu implements Menu {
//	private static Logger log=Logger.getLogger(TransferService.class);

public TransferService transService;
public AccountService acctService;

	public TransfersMenu() {
		transService = new TransferService();
		acctService = new AccountService();
	}
	
	@Override
	public void display() {
		
		int choice = 0;
		 
		 do {
			 System.out.println("     CUSTOMER TRANSFER MENU     ");
			 System.out.println("********************************");
			 System.out.println("      (1) Post a Transfer       ");
			 System.out.println("      (2) Receive Transfer      ");
			 System.out.println("      (3) Exit Menu             ");
			 System.out.println("================================");
			 
			 try {
				 
				 choice = Integer.parseInt(Menu.sc.nextLine());
				 
			 } catch (NumberFormatException e){
			 }
			 
			 switch (choice) {
			 	case 1:
			 		System.out.println("<<<<<<<<<<<<<<<<   Post A Transfer  >>>>>>>>>>>>>>>");
			 		System.out.println();
			 	    int trnsAmt = getTrnsAmtInput();
			 	    int trnsFromAcct = getFromAcctInput();
			 	    int trnsToAcct = getToAcctInput();
			 	    
			 		transService.postToAcct(trnsAmt, trnsFromAcct, trnsToAcct);

			 		break;
			 		
			 	case 2:
			 		System.out.println("<<<<<<<<<<<<<<<<   Receive a Transfer  >>>>>>>>>>>>>>>");
			 		System.out.println();
			 	    int rcvAcctNum = getFromAcctInput();
			 	    String compltTrns = CompleteInput();
			 	    
			 	    //  View transfers to receive
			 	    
			 	    if (compltTrns != "y" | compltTrns != "Y") {
			 	    	transService.getTransfer(rcvAcctNum);
			 	    	//System.out.println("Posted amount was successfully transferred to your account!");
			 	    }
			 		
			 		break;
			 		
			 	case 3:
			 		Menu custMenu = new CustomerMenu();
			 		custMenu.display();
			 		break;
			 		
			 	default:
			 		System.out.println("Invalid Selection entered.  Please try again.....");
			 		break;
			 
			 } 
		 } while (choice != 3);
		
		
		
	}
		
	public int getTrnsAmtInput() {
		
		System.out.println("Enter Amount to Transfer: ");
		int trnsAmt = Integer.parseInt(Menu.sc.nextLine());
		return trnsAmt;
	}
	
	private int getToAcctInput() {
		System.out.println("Enter Transfer To Account Number: ");
		int trnsToAcct = Integer.parseInt(Menu.sc.nextLine());
		return trnsToAcct;
	}
	
	public int getFromAcctInput() {
		System.out.println("Enter Account Number to Transfer amount: ");
		int trnsFromAcct = Integer.parseInt(Menu.sc.nextLine());
		return trnsFromAcct;
	}	 
	
	public String CompleteInput() {
		System.out.println("Complete Transfer(Y/N)?: ");
		String compltTrns = (Menu.sc.nextLine());
		return compltTrns;
	}	 

}
