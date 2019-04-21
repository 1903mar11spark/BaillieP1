package com.revature.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Requests;
import com.revature.project1.util.ConnectionsUtil;

public class EmpReqDaoImp implements EmpReqDao {

	@Override
	public List<Employees> getAllEmpMan() {
		List<Employees> users = new ArrayList<>();
		try (Connection con = ConnectionsUtil.getConnection()) {
			String sql = "SELECT E1.FIRSTNAME, E2.FIRSTNAME FROM EMPLOYEES E1 INNER JOIN EMPLOYEES E2 ON E2.EMPLOYEE_ID = E1.REPORTSTO;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USERPASSWORD");
				Employees bankUser = new Employees(userId, username, password);
				users.add(bankUser);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	
	}

	@Override
	public List<Requests> getAllRequests() {
		
		
		
		return null;
	}

	@Override
	public List<Requests> getEmpReqFromMan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Requests> getEmpReq() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Requests> getReciepts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createRequest(int employeeId, int managedId, String type, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Requests> getPendingRequests(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Requests> getResolvedRequests(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getEmployeeInfo(Employees emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployeeInfo(Employees emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resolveRequest(int requestId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employees getLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerEmployee(Employees emp) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
