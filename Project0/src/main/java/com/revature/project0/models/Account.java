package com.revature.project0.models;

import java.io.Serializable;
import java.util.Objects;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getRoutNum() {
		return routNum;
	}

	public void setRoutNum(int routNum) {
		this.routNum = routNum;
	}

}
