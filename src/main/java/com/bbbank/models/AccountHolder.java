package com.bbbank.models;

public class AccountHolder {
	
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private double balance = 0;
	
	//--From practice project coder - ethan mcgill--
	
	public AccountHolder() {}

	//used to send user info to the database (database auto generates the id
	public AccountHolder(String firstname, String lastname, String username, String password, double balance) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	//used to get info from the data base and create a user from it
	public AccountHolder(int id, String firstname, String lastname, String username, String password,double balance) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountHolder \nid: " + id + "\nfirstname: " + firstname + "\nlastname: " + lastname + "\nusername: "
				+ username;
	}

	
	
	
	

}
