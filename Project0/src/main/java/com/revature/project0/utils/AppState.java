package com.revature.project0.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.project0.menus.Start.StartMenu;
import com.revature.project0.daos.AccountDAO;
import com.revature.project0.menus.Dashboard;
import com.revature.project0.menus.Start.Login;
import com.revature.project0.menus.Start.Register;
import com.revature.project0.services.AccountServices;
import com.revature.project0.utils.logging.Logger;
import com.revature.project0.menus.Show;

public class AppState {

	private final Logger logger;
	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		logger = Logger.getLogger(true);
		logger.log("Application is initiliazing.....");
		
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		AccountDAO accountDAO = new AccountDAO();
		AccountServices accountServices = new AccountServices(accountDAO);
		
		router.addMenu(new StartMenu(consoleReader, router));
		router.addMenu(new Login(consoleReader, router));
		router.addMenu(new Register(consoleReader, router, accountServices));
		router.addMenu(new Dashboard(consoleReader, router, accountServices));
		router.addMenu(new Show(consoleReader, router, accountServices));
		router.addMenu(new Deposit(consoleReader, router, accountDAO));
		
		logger.log("Application initiliazed!!! We do did it!~WOOO~");
		
		
	}
	
	public void startup() {
		try {
			while(isRunning) {
				router.transfer("/start");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void shutdown() {
		isRunning = false;
	}
	
}
