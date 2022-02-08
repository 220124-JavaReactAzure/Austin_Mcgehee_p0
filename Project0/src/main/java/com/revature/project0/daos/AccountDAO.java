package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.revature.project0.models.Account;
import com.revature.project0.utils.collections.LinkedList;
import com.revature.project0.utils.collections.List;
import com.revature.project0.utils.datasource.ConnectionDriver;

public class AccountDAO implements CrudDAO<Account> {
	
	public Account findUsernameAndPassword(String username, String password) {
		
		try (Connection conn = ConnectionDriver.getInstance().getConnection()) {
			
			String sql = "select * from accounts where username = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Account account = new Account();
				
				account.setAccountId(1);
				account.setUsername("AustinM");
				account.setPassword("Password$");
				account.setRoutNum(1214);
				account.setFirstName("Austin");
				account.setLastName("Mcgehee");
				
				return account;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Account findByUsername(String username) {
		try(Connection conn = ConnectionDriver.getInstance().getConnection()) {
			
			String sql = "select * from accounts where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("accountId"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setRoutNum(rs.getInt("routNum"));
				account.setFirstName(rs.getString("firstName"));
				account.setLastName(rs.getString("lastName"));

				return account;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
// ###########################################################################################################################################

	@Override
	public Account create(Account newAccount) {
		// TODO Auto-generated method stub
		
		try (Connection conn = ConnectionDriver.getInstance().getConnection()) {
			
			Random rand = new Random();

			newAccount.setAccountId(rand.nextInt());

			String sql = "insert into accounts (accountId, username, password, routNum, firstName, lastName) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, newAccount.getAccountId());
			ps.setString(2, newAccount.getUsername());
			ps.setString(3, newAccount.getPassword());
			ps.setInt(4, newAccount.getRoutNum());
			ps.setString(5, newAccount.getFirstName());
			ps.setString(6, newAccount.getLastName());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newAccount;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
