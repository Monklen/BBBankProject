package com.bbbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bbbank.models.AccountHolder;
import com.bbbank.utils.ConnectionUtil;

public class BalanceDao {
	
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
public AccountHolder getBalanceByUsername(String username) {
		
		AccountHolder aholder = new AccountHolder();
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT balance FROM accountholders WHERE accountholders.username = '"+ username +"'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				aholder.setBalance(rs.getDouble(1));
			}
			return aholder;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}	

