package com.revature.project1.beans;

public class Login {
	
	private String username;
	private String password;
	private int employeeId;
	
	public Login() {
		super();

	}

	public Login(String username, String password, int employeeId) {
		super();
		this.username = username;
		this.password = password;
		this.employeeId = employeeId;
	}
	
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", employeeId=" + employeeId + "]";
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	

}
