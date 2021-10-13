package com.bbbank.services;

import java.sql.SQLException;

import com.bbbank.dao.AccountHolderDao;
import com.bbbank.exceptions.UsernameAlreadyExistsException;
import com.bbbank.logging.Logging;
import com.bbbank.models.AccountHolder;

public class AccountService {
	
	private AccountHolderDao aDao;
	
	public AccountService(AccountHolderDao ac) {
		this.aDao = ac;
	}
	
	public AccountHolder signup(String first,String last,String username,String password) throws UsernameAlreadyExistsException {
		
		AccountHolder ac = new AccountHolder(first,last,username,password);
		
		try {
			aDao.createAccountHolder(ac);
			Logging.logger.info("New account has been created");
		}
		catch(SQLException e) {
			Logging.logger.warn("Account already exists");
			throw new UsernameAlreadyExistsException();
		}
		
		return null;
	}

}
