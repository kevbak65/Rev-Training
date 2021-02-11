package com.revature.ui;

//import java.util.Scanner;

import com.revature.exceptions.NoRecordFound;
import com.revature.services.EmployeeService;
import com.revature.services.UserService;
import com.revature.models.User;
import com.revature.models.Employee;

public class MainMenu implements Menu {
	
	public UserService userService;
	public EmployeeService empService;

	public MainMenu() {
		userService = new UserService(); 
		empService = new EmployeeService();
	}
	
	@Override
	public void display() {
		int choice = 0;
		
		do {
			System.out.println("========================================================"); 
			System.out.println("=                    MAIN MENU                         =");
			System.out.println("========================================================");
			System.out.println("*           (1) Customer Signin                        *");
			System.out.println("*           (2) Employee Signin                        *");
			System.out.println("*           (3) New User Account                       *");
		    System.out.println("*           (4) Exit                                   *");
		    System.out.println("--------------------------------------------------------");
		    System.out.println();
		    System.out.println("Please make a selection (1, 2, 3, or 4):                   ");
		    System.out.println();		
		    try {
		    	choice = Integer.parseInt(Menu.sc.nextLine());
		    	
		    } catch (NumberFormatException e){
		    }
		    
		    switch (choice) {
		    	case 1: // Customer Login
		    		
		    		String userName = getUserNameInput();
			 		String userPswd = getUserPswdInput();
			 		
					try {
						User user = userService.getUser(userName, userPswd);
						if (user != null) {
							System.out.println("Login successful. Welcome back, " + userName + "'!");
							System.out.println();
							Menu customerMenu = new CustomerMenu();
				    		customerMenu.display();
						} else {
							throw new NoRecordFound("The username: '" + userName + "' was not found! Please try again or choose New User Account."); 
						}
					} catch (NoRecordFound e) {
						System.out.println(e.getMessage());
						System.out.println();
					}
			 		break;
		    		
		    	case 2: // Employee Login
		    		
		    		String empUserName = getUserNameInput();
			 		String empPswd = getUserPswdInput();
			 		
					try {
						Employee emp = userService.getEmpByUserName(empUserName, empPswd);
	
						if (emp != null) {
							System.out.println("Employee login for username '" + empUserName + "' was successful!");
							System.out.println();
							Menu empMenu = new EmployeeMenu();// replace with Employee Service
							empMenu.display();
						} else {
							throw new NoRecordFound("The username: '" + empUserName + "' was not found! Please try again or choose New User Account."); 
						}
						
					} catch (NoRecordFound e) {
						//e.printStackTrace();
						System.out.println(e.getMessage());
						System.out.println();
					}
			 		
			 		break;
		    		
		    		
		    	case 3: // New User Menu display
		    		Menu newUserMenu = new NewUserMenu();
		    		newUserMenu.display();
		    		break;
		    		
		    	case 4:
		    		System.out.println("  Thank you for using New Baker Bank online services. Have a Nice Day!");
		    		break;
		    		
		    	default:
		    		System.out.println("! ** Invalid selection. Please try again ** !");
		    }
			
		} while (choice != 4);
	}	

	private String getUserPswdInput() {
		System.out.println("Enter Password: ");
		String userPswd = Menu.sc.nextLine();
		return userPswd;
	}

	private String getUserNameInput() {
		System.out.println("Enter Username: ");
		String userName = Menu.sc.nextLine();
		return userName;
	}

}
