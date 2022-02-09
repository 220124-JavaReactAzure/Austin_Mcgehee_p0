package com.revature.project0.menus.Start;

import com.revature.project0.menus.Menu;
import com.revature.project0.utils.MenuRouter;
import static com.revature.project0.utils.AppState.shutdown;

import java.io.BufferedReader;

import com.revature.project0.services.AccountServices;
import com.revature.project0.utils.MenuRouter;
import com.revature.project0.models.Account;
import com.revature.project0.menus.Menu;

public class Register extends Menu {
	
	AccountServices accountServices;

	public Register(BufferedReader buffered, MenuRouter router, AccountServices accountServices) {
		super("Register", "/register", buffered, router);
		this.accountServices = accountServices;
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("The user selected Register!");
		
		System.out.println("Enter the required information");
		System.out.print("Username: ");
		String username = consoleReader.readLine();
		
		System.out.print("Password: ");
		String password = consoleReader.readLine();
		
		System.out.print("First Name: ");
		String firstName = consoleReader.readLine();
		
		System.out.print("Last Name: ");
		String lastName = consoleReader.readLine();
		
		Account account = new Account(username, password, firstName, lastName);
		
		try {
			accountServices.registerNewAccount(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); 
			System.out.println("YOU HAVE PROVIDED INVALID DATA PLEASE TRY AGAIN\n\n\n");

			router.transfer("/welcome");
			
		}		
		
	}

}
