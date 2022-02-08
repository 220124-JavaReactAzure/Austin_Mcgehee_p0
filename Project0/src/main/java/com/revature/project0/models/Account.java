package com.revature.project0.models;

import java.io.Serializable;

public class Account implements Serializable {
	
	private String username;
	private String password;
	private int accountId;
	private int routNum;
	
	public Account() {
		super();
	}
	
	public Account(String username, String password, int accountId, int routNum) {
		super();
		this.username = username;
		this.password = password;
		this.accountId = accountId;
		this.routNum = routNum;
	}
	
	

}
