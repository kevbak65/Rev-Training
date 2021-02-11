package com.revature.main;

import com.revature.ui.Menu;
import com.revature.ui.MainMenu;

public class Application {

	public static void main(String[] args) {

		System.out.println("              Welcome to New Baker Bank                ");
		System.out.println("  ===================================================  ");
		
		// Invoke Main Menu display method
		Menu mainMenu = new MainMenu();
		mainMenu.display();
		
		Menu.sc.close();
		System.out.println("  Thank you for using New Baker Bank online services. Have a Nice Day!  ");
	}

}
