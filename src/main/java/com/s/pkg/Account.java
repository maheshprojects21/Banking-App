package com.s.pkg;

public class Account {
	
	private String firstName;
	private String lastName;
	private String password;
	private String accountId;
	private String emailId;
	private double balance;
	
	
	public Account(String firstName, String lastName, String password, String accountId, String emailId,
			double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.accountId = accountId;
		this.emailId = emailId;
		this.balance = balance;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FirstName = ").append(getFirstName());
		sb.append("LastName = ").append(getLastName());
		sb.append("Account ID = ").append(getAccountId());
		sb.append("Email ID = ").append(getEmailId());
		sb.append("Balance = ").append(getBalance());
		return sb.toString();
	}
	
	

}
