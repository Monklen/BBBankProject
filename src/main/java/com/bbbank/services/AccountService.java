package com.bbbank.services;

import java.sql.SQLException;

import com.bbbank.dao.AccountHolderDao;
import com.bbbank.exceptions.AccountDoesNotExistException;
import com.bbbank.exceptions.InvalidCredentialsException;
import com.bbbank.exceptions.UsernameAlreadyExistsException;
import com.bbbank.logging.Logging;
import com.bbbank.models.AccountHolder;

public class AccountService {
	
	private AccountHolderDao aDao;
	
	public AccountService(AccountHolderDao ac) {
		this.aDao = ac;
	}
	
	public AccountHolder signup(String first, String last, String username, String password, double balance) throws UsernameAlreadyExistsException {
		
		AccountHolder ac = new AccountHolder(first, last, username, password, balance);
		
		try {
			aDao.createAccountHolder(ac);
			Logging.logger.info("New account has been created");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			Logging.logger.warn("Account already exists");
			throw new UsernameAlreadyExistsException();
		}
		
		return ac;
	}
	
	public AccountHolder login(String username, String password) throws AccountDoesNotExistException, InvalidCredentialsException{
		
		AccountHolder ac = aDao.getUserByAccountHolder(username);
		
		if(ac.getId() == 0) {
			Logging.logger.warn("Account tried loggin in does not exist");
			throw new AccountDoesNotExistException();
		}
		else if(!ac.getPassword().equals(password)) {
			Logging.logger.warn("Invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("Account logged in");
			return ac;
		}
	}
	
	

}
