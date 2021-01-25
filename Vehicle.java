package com.revature.demo.assignment;

import java.sql.Array;

//The vehicle class assigns the drivers to their vehicle. 2 Drivers and 2 vehicles.  Driver 1 is assigned to vehicle 1 and 2, 
// but driver 2 is assigned to vehicle 1 only.

public class Vehicle extends Policy{
	int vehNumber;
	private int vehVIN;
	private String vehMake;
	private String vehModel;
	private String vehYear;
	
	
	public static void main(String[] args) {
		
		PolDriver driver = new PolDriver();
		
		System.out.println(driver.getDriverFName());
		System.out.println(driver.getDriverLName());
		System.out.println(driver.drvrNumber);
		System.out.println(driver.getGender());
		
		
	}
	
    
	

}
