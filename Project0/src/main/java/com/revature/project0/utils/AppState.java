package com.revature.project0.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.project0.menus.Start.StartMenu;

public class AppState {

	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		router.addMenu(new StartMenu(consoleReader, router));
		
		
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
