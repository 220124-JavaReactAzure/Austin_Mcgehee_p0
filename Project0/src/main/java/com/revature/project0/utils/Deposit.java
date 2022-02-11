package com.revature.project0.utils;

import java.io.BufferedReader;
import java.sql.Connection;

import com.revature.project0.daos.AccountDAO;
import com.revature.project0.menus.Menu;
import com.revature.project0.utils.datasource.ConnectionDriver;

public class Deposit extends Menu {
	AccountDAO accountDAO = new AccountDAO();

	public Deposit(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super("Deposit", "/deposit", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	public Deposit(BufferedReader consoleReader, MenuRouter router, AccountDAO accountDAO) {
		// TODO Auto-generated constructor stub
		super("Deposit", "/deposit", consoleReader, router);
		this.accountDAO = accountDAO;
		
		
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionDriver.getInstance().getConnection()) {
			System.out.print("How much would you like to deposit? >");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
