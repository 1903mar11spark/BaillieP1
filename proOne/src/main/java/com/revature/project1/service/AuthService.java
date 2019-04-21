package com.revature.project1.service;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Login;

public class AuthService {
	
	public Employees isValidUser(Login login) {
		Employees u = null;
		String username = login.getUsername();
		String password = login.getPassword();
		if (username != null && password != null) {
			// this is fake authentication!
			if (username.equals("Merlin") && password.equals("cat")) {
				u = new Employees(6, "Broker", "Em", "Baillie", "ebaillie@gmail.com");
			}
		}
		return u;
	}

}
