package com.revature.ui;

import com.revature.exceptions.DBConnException;
//import com.revature.exceptions.NoRecordFound;
//import com.revature.models.User;
import com.revature.services.CustomerService;
import com.revature.services.UserService;

public class NewUserMenu implements Menu {
	
	public UserService userService;
	public CustomerService custService;
	
	public NewUserMenu() {
		//userService = new UserService();
		custService = new CustomerService();
	}
	
	@Override
	public void display() {
		 int choice = 0;
		 
		 do {
			 System.out.println("      NEW USER ACCOUNT MENU        ");
			 System.out.println("***********************************");
			 System.out.println("  (1) Create New User and Account  ");
			 System.out.println("  (2) Exit                         ");
			 System.out.println("===================================");
			 
			 try {
				 
				 choice = Integer.parseInt(Menu.sc.nextLine());
				 
			 } catch (NumberFormatException e){
			 }
			 
			 switch (choice) {
			 	case 1:
			 		String userName = getCreateUserNameInput();
			 		String userPswd = getCreateUserPswd();
			 		//userService.createUser(userName, userPswd);
			 		
			 		System.out.println("******  Apply for New Account *****");
			 		String acctType = getAcctTypenput();
			 		String custSSN = getCustSSNInput();
			 		String custLName = getCustLNameInput();
			 		String custFName = getCustFNameInput();
			 		String custAddress = getCustAddressInput();
			 		String custCity = getCustCityInput();
			 		String custState = getCustStateInput();
			 		String custZip = getCustZipInput();
			 		String custDOB = getCustDOBInput();
			 		String custPhoneNum = getCustPhoneInput();
			 			
				try {
					custService.createCustomer(acctType, custSSN, custLName, custFName, custAddress, custCity, custState, custZip, custDOB, custPhoneNum, userName, userPswd);
				} catch (DBConnException e) {
					e.printStackTrace();
				}
			 		
			 		System.out.println("New User account registered successfully!");
			 		System.out.println();
			 		
			 		System.out.println("You have successully applied for an Account. Please check back for status.");
			 		System.out.println();
			 		
			 		break;
			 		
			 	case 2:
			 		Menu mainMenu = new MainMenu();
			 		mainMenu.display();
			 		break;
			 }
			  
		 } while (choice != 3);

	}
	
	// Inputs for new username and password
	public String getCreateUserNameInput() {
		System.out.println("<<<<<<<<<<  Create User Login >>>>>>>>>>");
		System.out.println("Enter New Username: ");
		String userName = Menu.sc.nextLine();
		return userName;
	}
	
	private String getCreateUserPswd() {
		System.out.println("Enter New Password: ");
		String userPswd = Menu.sc.nextLine();
		return userPswd;
	}
	
	// User inputs for new Customer account application
	
	//     Get Account Type:
	public String getAcctTypenput() {
		System.out.println("Enter Account Type('C'= Checking; 'S'= Savings): ");
		String acctType = Menu.sc.nextLine();
		return acctType;
	}
	//  SSN
	public String getCustSSNInput() {	
		System.out.println("Enter SSN (000-00-0000): ");
		String custSSN = Menu.sc.nextLine();
		return custSSN;
	}
	
	//  Last Name
	public String getCustLNameInput() {
		System.out.println("Enter Last Name: ");
		String custLName = Menu.sc.nextLine();
		return custLName;
	}
	
	//  First Name
	public String getCustFNameInput() {	
		System.out.println("Enter First Name: ");
		String custFName = Menu.sc.nextLine();
		return custFName;
	}
	
	//  Address
	public String getCustAddressInput() {	
		System.out.println("Enter Street Address: ");
		String custAddress = Menu.sc.nextLine();
		return custAddress;
	}
	
	//  City
	public String getCustCityInput() {
		System.out.println("Enter City: ");
		String custCity = Menu.sc.nextLine();
		return custCity;
	}
	//  State
	public String getCustStateInput() {
		System.out.println("Enter State (Abbreviated): ");
		String custState = Menu.sc.nextLine();
		return custState;
	}
	
	//  Zip Code
	public String getCustZipInput() {	
		System.out.println("Enter Zip Code: ");
		String custZip = Menu.sc.nextLine();
		return custZip;
	}
	
	//  DOB
	public String getCustDOBInput() {	
		System.out.println("Enter Date of Birth(mm/dd/yyyy): ");
		String custDOB = Menu.sc.nextLine();
		return custDOB;
	}
	
	//  Phone Number
	public String getCustPhoneInput() {	
		System.out.println("Enter Enter Primary Phone Number(000-000-0000): ");
		String custPhoneNum = Menu.sc.nextLine();
		return custPhoneNum;
	}
	
	
	
	
	
	
	
	
	
	

}
