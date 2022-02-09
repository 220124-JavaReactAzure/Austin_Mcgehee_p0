package com.revature.project0.menus;

import java.io.BufferedReader;

import com.revature.project0.services.AccountServices;
import com.revature.project0.utils.MenuRouter;

public class Show extends Menu {

	AccountServices accountServices;
	
	public Show(BufferedReader consoleReader, MenuRouter router, AccountServices accountServices) {
		super("Show", "/show", consoleReader, router);
		this.accountServices = accountServices;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		System.out.print("Your balance is: ");
		
		
	}

}
