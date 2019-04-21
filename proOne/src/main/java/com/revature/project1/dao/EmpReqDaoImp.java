package com.revature.project1.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Requests;
import com.revature.project1.util.ConnectionsUtil;

public class EmpReqDaoImp implements EmpReqDao {

	@Override
	public List<Employees> getAllEmpMan() {
		List<Employees> a = new ArrayList<>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT FIRSTNAME, REPORTSTO FROM EMPLOYEES";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int man = rs.getInt("REPORTSTO");
				String emp = rs.getString("FIRSTNAME");
				a.add(new Employees(man, emp));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
	}
	
	@Override
	public List<Requests> getAllRequests() {
		List<Employees> a = new ArrayList<>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT FIRSTNAME, REPORTSTO FROM EMPLOYEES";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int man = rs.getInt("REPORTSTO");
				String emp = rs.getString("FIRSTNAME");
				a.add(new Employees(man, emp));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
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
