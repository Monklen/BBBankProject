package com.bbbank.exceptions;

public class AccountDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountDoesNotExistException() {
		super("Account Does Not Exist");
	}
	
	

}
