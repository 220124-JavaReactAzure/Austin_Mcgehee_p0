package com.revature.project0.services;

import com.revature.project0.models.Account;
import com.revature.project0.utils.collections.List;
import com.revature.project0.daos.AccountDAO;

public class AccountServices {

	private final AccountDAO accountDAO;
	private Account sessionAccount;

	public AccountServices(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
		this.sessionAccount = null;
	}

	public AccountServices(String username, String password) {
		super();
		this.accountDAO = new AccountDAO();
		// TODO Auto-generated constructor stub
	}

	public Account getSessionAccount() {
		return sessionAccount;
	}

	public Account registerNewAccount(Account newAccount) throws Exception {
		if (!isAccountValid(newAccount)) {
			throw new Exception("Invalid user data provider");
		}

		boolean usernameAvailable = accountDAO.findByUsername(newAccount.getUsername()) == null;

		if (!usernameAvailable) {
			if (!usernameAvailable) {
				throw new Exception("The provided username was already taken in the database");
			}
		}

		Account persistedAccount = accountDAO.create(newAccount);

		if (persistedAccount == null) {
			throw new Exception("The scientist could not be persisted");
		}

		return persistedAccount;
	}

	public boolean isAccountValid(Account newAccount) {
		
		if(newAccount == null) return false;
		if(newAccount.getFirstName() == null || newAccount.getFirstName().trim().equals("")) return false;
		if(newAccount.getLastName() == null || newAccount.getLastName().trim().equals("")) return false;
		if(newAccount.getUsername() == null || newAccount.getUsername().trim().equals("")) return false;
		return newAccount.getPassword() != null || !newAccount.getPassword().trim().equals("");
		
	}

	public List<Account> getAllAccounts() {
		return accountDAO.findAll();
	}

	// TODO: Impelement authentication
	public void authenticateAccount(String username, String password) throws Exception {

		if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new Exception(
					"Either username or password is an invalid entry. Please try logging in again");
		}

		Account authenticatedAccount = accountDAO.findByUsernameAndPassword(username, password);

		if (authenticatedAccount == null) {
			throw new Exception(
					"Unauthenticated user, information provided was not found in our database.");
		}
		sessionAccount = authenticatedAccount;
	}

	public boolean isAccounttValid(Account newAccount) {
		if (newAccount == null)
			return false;
		if (newAccount.getFirstName() == null || newAccount.getFirstName().trim().equals(""))
			return false;
		if (newAccount.getLastName() == null || newAccount.getLastName().trim().equals(""))
			return false;
		if (newAccount.getUsername() == null || newAccount.getUsername().trim().equals(""))
			return false;
		return newAccount.getPassword() != null || !newAccount.getPassword().trim().equals("");

	}

	public void logout() {
		sessionAccount = null;
	}

	public boolean isSessionActive() {
		return sessionAccount != null;
	}

}
