package com.revature.project0.menus.Start;

import java.io.BufferedReader;

import com.revature.project0.menus.Menu;
import com.revature.project0.utils.MenuRouter;
import static com.revature.project0.utils.AppState.shutdown;

public class StartMenu extends Menu {
	
	public StartMenu(BufferedReader buffered, MenuRouter router) {
		super("Start", "/start", buffered, router);
	}
	
	@Override
	public void render() throws Exception {
		
		System.out.print("Welcome to bank of Revature!\n" + "1)Login\n" + "2)Create Checking Account\n" + "3)Exit\n" + ">");
		
		String userSel = consoleReader.readLine();
		
		switch(userSel) {
		case "1":
			router.transfer("/login");
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
