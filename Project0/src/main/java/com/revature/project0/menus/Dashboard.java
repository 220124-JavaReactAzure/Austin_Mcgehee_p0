package com.revature.project0.menus;

import static com.revature.project0.utils.AppState.shutdown;

import java.io.BufferedReader;

import com.revature.project0.services.AccountServices;
import com.revature.project0.utils.MenuRouter;
import com.revature.project0.utils.logging.Logger;

public class Dashboard extends Menu {

	AccountServices accountServices;

	public Dashboard(BufferedReader buffered, MenuRouter router, AccountServices accountServices) {
		super("Dashboard", "/dash", buffered, router);
		this.accountServices = accountServices;
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		final Logger logger;
		logger = Logger.getLogger(true);
		logger.log("Login Successfull...");
		
		
		System.out.println("Welcome to your DASHBOARD");
		System.out.print("1)View/edit checking account\n" + "2)Create Checking Account\n" + "3)Exit\n" + ">");

		String userSel = consoleReader.readLine();

		switch (userSel) {
		case "1":
			router.transfer("/show");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutdown();
			break;
		default:
			System.out.println("That's not an option!!!");
			break;
		}

	}

}
