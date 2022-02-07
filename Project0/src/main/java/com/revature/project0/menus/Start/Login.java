package com.revature.project0.menus.Start;

import java.io.BufferedReader;

import com.revature.project0.menus.Menu;
import com.revature.project0.utils.MenuRouter;
import static com.revature.project0.utils.AppState.shutdown;
import com.revature.project0.services.AccountServices;

public class Login extends Menu {
	
	public Login(BufferedReader buffered, MenuRouter router) {
		super("Login", "/login", buffered, router);
	}
	
	@Override
	public void render() throws Exception{
		System.out.print("Enter you credentials below\n");
		
		System.out.println("Username: ");
		String username = consoleReader.readLine();
		
		System.out.println("Password: ");
		String password = consoleReader.readLine();
		
		
		
		
	}

}
