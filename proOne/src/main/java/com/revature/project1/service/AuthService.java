package com.revature.project1.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Login;
import com.revature.project1.dao.EmpReqDaoImp;
import com.revature.project1.util.ConnectionsUtil;

public class AuthService {
	
	//Use your DAO, be smart about this
	//abstract away your problems
	EmpReqDaoImp erd = new EmpReqDaoImp();
	
	public Employees isValidUser(Login login) {
		Employees emp = null;
				String username = login.getUsername();
				String password = login.getPassword();
				//System.out.println(password);
				int employeeId = erd.getLogin(username, password);
				if (employeeId != 0) {
					emp = erd.getEmployeeInfo(employeeId);
					System.out.println(emp + "from auth service ");
				} 
				return emp;
			}
	
	
}
	
	

