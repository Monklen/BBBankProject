package com.bbbank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bbbank.models.AccountHolder;

//--from practice project coder - ethan mcgill--

public interface AccountHolderDao {
	
List<AccountHolder> getAllAccountHolders();
	
AccountHolder getUserByUsername(String username);
	
	void createUser(AccountHolder ach) throws SQLException;
	
	void updateUser(AccountHolder ach);
	
	void deleteUser(AccountHolder ach);

}
