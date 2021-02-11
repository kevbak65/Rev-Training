package com.revature.models;

public class Employee {

	//public Employee(String empUserName, String empPswd) {
		// TODO Auto-generated constructor stub
	//}
	
	private String empUserName;
	private String empPswd;
	private int empID;
	
	public Employee() {
		super();
	}
	
	public Employee(int empID) {
		this.empID = empID;
	}
	
	public Employee(String empUserName, String empPswd) {
		this.empUserName = empUserName;
		this.empPswd = empPswd;
	}

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	public String getEmpPswd() {
		return empPswd;
	}

	public void setEmpPswd(String empPswd) {
		this.empPswd = empPswd;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	@Override
	public String toString() {
		return "Employee [empUserName=" + empUserName + ", empPswd=" + empPswd + ", empID=" + empID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empID;
		result = prime * result + ((empPswd == null) ? 0 : empPswd.hashCode());
		result = prime * result + ((empUserName == null) ? 0 : empUserName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empID != other.empID)
			return false;
		if (empPswd == null) {
			if (other.empPswd != null)
				return false;
		} else if (!empPswd.equals(other.empPswd))
			return false;
		if (empUserName == null) {
			if (other.empUserName != null)
				return false;
		} else if (!empUserName.equals(other.empUserName))
			return false;
		return true;
	}
	
	

}
