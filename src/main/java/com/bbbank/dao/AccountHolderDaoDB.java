package com.bbbank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbbank.models.AccountHolder;
import com.bbbank.utils.ConnectionUtil;

public class AccountHolderDaoDB implements AccountHolderDao{
	
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	//use statements to talk to the database
	
	@Override
	public List<AccountHolder> getAllAccountHolders() {
		
		List<AccountHolder> accountlist = new ArrayList<AccountHolder>();
		
		try {
			// make the connection the db
			Connection con = conUtil.getConnection();
			
			//create a sql statement
			String sql = "SELECT * FROM accountholders";
			
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			// we have to loop through the resultset and create objects based off the return
			while(rs.next()) {
				accountlist.add(new AccountHolder(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
			}
			return accountlist;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public AccountHolder getUserByAccountHolder(String username) {
		
		AccountHolder aholder = new AccountHolder();
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "SELECT * FROM accountholders WHERE accountholders.username = '"+ username +"'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				aholder.setId(rs.getInt(1));
				aholder.setFirstname(rs.getString(2));
				aholder.setLastname(rs.getString(3));
				aholder.setUsername(rs.getString(4));
				aholder.setPassword(rs.getString(5));
				aholder.setBalance(rs.getDouble(6));
			}
			return aholder;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//use prepared statement to precompile the sql and protect against sql injection
	
	@Override
	public void createAccountHolder(AccountHolder ac) throws SQLException {
		
		Connection con = conUtil.getConnection();
		
		//still create the sql string, but with some small changes
		String sql = "INSERT INTO accountholders (firstname,lastname,username,password,balance) VALUES (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, ac.getFirstname());
		ps.setString(2, ac.getLastname());
		ps.setString(3, ac.getUsername());
		ps.setString(4, ac.getPassword());
		ps.setDouble(5, ac.getBalance());
		
		ps.execute();
	}

	@Override
	public void updateAccountHolder(AccountHolder ac) {
		
		Connection con = conUtil.getConnection();
		
		try {
			
		//still create the sql string, but with some small changes
		String sql = "UPDATE accountholders SET firstname = ?, lastname = ?, username = ?, password = ?, balance = ? WHERE accountholders.id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ac.getFirstname());
		ps.setString(2, ac.getLastname());
		ps.setString(3, ac.getUsername());
		ps.setString(4, ac.getPassword());
		ps.setDouble(5, ac.getBalance());
		ps.setInt(6, ac.getId());
		
		ps.execute();
		
		
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	} 
	
	@Override
	public void deleteAccountHolder(AccountHolder ac) {
		try {
		Connection con = conUtil.getConnection();
		
		String sql = "DELETE FROM accountholders WHERE accountholders.id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ac.getId());
		ps.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBalance(AccountHolder ac) {
		try {
			Connection con = conUtil.getConnection();
	
			//still create the sql string, but with some small changes
			String sql = "UPDATE accountholders SET balance = ? WHERE accountholders.id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, ac.getBalance());
			ps.setInt(2, ac.getId());
			
			ps.executeUpdate();
		}
		catch(SQLException e) {
		e.printStackTrace();
		}
	}
	
public AccountHolder updateBalanceByAccountHolder(AccountHolder ac) {
		
		AccountHolder aholder = new AccountHolder();
		
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE accountholders SET balance = ? WHERE accountholders.username = '"+ ac.getUsername() +"'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
				
			aholder.setBalance(rs.getDouble(1));
			
			return aholder;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
