package com.revature.demo.assignment;

//import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//public class Driver extends Vehicle {
public class PolDriver {
	
	private Date dateNow = new Date();
	
	int drvrNumber;
	private String driverFName;
	private String driverLName;
	private Date doB;
	private String gender;
	
	public PolDriver() {
		super();
	}
	
    public PolDriver(String driverFName, String driverLName, Date doB, String gender) {
    	super();
    	this.driverFName = driverFName;
    	this.driverLName = driverLName;
    	this.setAge(doB);
    	
    	
    }
    
    public int setAge(Date doB) {
    	
        Calendar dobIn = getCurrentDate(doB);
    	Calendar currDate = getCurrentDate(dateNow);
        int age = currDate.get(Calendar.YEAR) - dobIn.get(Calendar.YEAR);
        if (dobIn.get(Calendar.DAY_OF_YEAR) > currDate.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        
        System.out.println(age);
        return age;

    }

	public static Calendar getCurrentDate(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        System.out.println(date);
        return cal;
    }

	/*
	 * Getters and Setters
	 */
	
	public void setDrvrNumber(int drvrNumber) {
		this.drvrNumber = drvrNumber;
	}

	public String getDriverFName() {
		return driverFName;
	}

	public void setDriverFName(String driverFName) {
		this.driverFName = driverFName;
	}

	public String getDriverLName() {
		return driverLName;
	}

	public void setDriverLName(String driverLName) {
		this.driverLName = driverLName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}

