package com.revature.project0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.project0.models.Account;
import com.revature.project0.utils.collections.LinkedList;
import com.revature.project0.utils.collections.List;
import com.revature.project0.utils.datasource.ConnectionDriver;

public class AccountDAO implements CrudDAO<Account> {
	
	public Account findUsernameAndPassword(String username, String password) {
		
		try (Connection conn = ConnectionDriver.getInstance().getConnection()) {
			
			
			while (rs.next()) {
				Account account = new Account();
				
				return account;
			}
		}
		
	}

	@Override
	public Account create(Account newObj) {
		// TODO Auto-generated method stub
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
