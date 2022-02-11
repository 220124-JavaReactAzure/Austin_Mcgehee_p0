package com.revature.project0.menus;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.project0.daos.AccountDAO;
import com.revature.project0.services.AccountServices;
import com.revature.project0.utils.MenuRouter;
import com.revature.project0.utils.datasource.ConnectionDriver;
import static com.revature.project0.utils.AppState.shutdown;

public class Show extends Menu {

	AccountDAO accountDAO = new AccountDAO();
	AccountServices accountServices = new AccountServices(accountDAO);
	

	public Show(BufferedReader consoleReader, MenuRouter router, AccountServices accountServices) {
		super("Show", "/show", consoleReader, router);
		this.accountServices = accountServices;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub

		try (Connection conn = ConnectionDriver.getInstance().getConnection()) {
			String sql = "select balance from accounts where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, this.accountServices.getSessionAccount().getUsername());
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Balance: " + rs);
			
			System.out.println("Select which menu you would like >");
			System.out.print("1)Deposit\n" + "2)Withdraw\n" + "3)Exit\n" + ">");
			
			String userSel = consoleReader.readLine();
			
			switch(userSel) {
			case "1":
				router.transfer("/deposit");
				break;
			case "2":
				router.transfer("/withdraw");
				break;
			case "3":
				shutdown();
				break;
			default:
				System.out.println("NOT AN OPTION!!!");
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
