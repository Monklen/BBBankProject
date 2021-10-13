package com.bbbank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bbbank.models.AccountHolder;

//--from practice project coder - ethan mcgill--

public interface AccountHolderDao {
	
List<AccountHolder> getAllAccountHolders();
	
AccountHolder getUserByAccountHolder(String username);
	
	void createAccountHolder(AccountHolder ach) throws SQLException;
	
	void updateAccountHolder(AccountHolder ach);
	
	void deleteAccountHolder(AccountHolder ach);

}
