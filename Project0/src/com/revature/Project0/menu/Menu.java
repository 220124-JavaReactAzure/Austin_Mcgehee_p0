package com.revature.Project0.menu;

import java.io.BufferedReader;
import com.revature.Project0.util.*;

public abstract class Menu {
	protected String name;
	protected String route;
	protected BufferedReader consoleReader;
	protected MenuRouter router;

	public Menu(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super();
		this.name = name;
		this.route = route;
		this.consoleReader = consoleReader;
		this.router = router;
	}

	public String getName() {
		return name;
	}

	public String getRoute() {
		return route;
	}

	public abstract void render() throws Exception;

}
