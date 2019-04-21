package com.revature.project1.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
			String sql = "SELECT E1.FIRSTNAME AS EMPLOYEE, E2.FIRSTNAME AS SUPERVISOR FROM EMPLOYEES E1 INNER JOIN EMPLOYEES E2 ON E2.EMPLOYEE_ID = E1.REPORTSTO";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				String manager = rs.getString("SUPERVISOR");
				String firstname = rs.getString("EMPLOYEE");
				a.add(new Employees(manager, firstname));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
	}
	
	//FIX LATER TO SHOW NAMES NOT JUST ID NUMBERS
	@Override
	public List<Requests> getAllRequests() {
		List<Requests> a = new ArrayList<>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUESTS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int rq = rs.getInt("REQUEST_ID");
				int em = rs.getInt("EMPLOYEE_ID");
				int man = rs.getInt("MANAGEDBY");
				Date date = rs.getDate("RQ_DATE");
				String type = rs.getString("RQ_TYPE");
				double amt = rs.getDouble("RQ_AMT");
				String stat = rs.getString("REQUEST_STATUS");
				a.add(new Requests(rq, em, man, date, type, amt, stat));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
	}

	@Override
	public List<Requests> getEmpReqFromMan(int employeeId) {
		List<Requests> a = new ArrayList<>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUESTS WHERE MANAGEDBY=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int rq = rs.getInt("REQUEST_ID");
				int em = rs.getInt("EMPLOYEE_ID");
				Date date = rs.getDate("RQ_DATE");
				String type = rs.getString("RQ_TYPE");
				double amt = rs.getDouble("RQ_AMT");
				String stat = rs.getString("REQUEST_STATUS");
				String info = rs.getString("INFO");
				a.add(new Requests(rq, em, date, type, amt, stat, info));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
	}

	@Override
	public List<Requests> getEmpReq(int empId, int manId) {
		List<Requests> a = new ArrayList<>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUESTS WHERE EMPLOYEE_ID = ? AND MANAGEDBY = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			pstmt.setInt(2, manId);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int rq = rs.getInt("REQUEST_ID");
				int em = rs.getInt("EMPLOYEE_ID");
				Date date = rs.getDate("RQ_DATE");
				String type = rs.getString("RQ_TYPE");
				double amt = rs.getDouble("RQ_AMT");
				String stat = rs.getString("REQUEST_STATUS");
				String info = rs.getString("INFO");
				a.add(new Requests(rq, em, date, type, amt, stat, info));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
	
	}

	@Override
	public List<Requests> getReciepts() {
			List<Requests> a = new ArrayList<>();
			try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
				String sql = "SELECT RQ_IMAGE FROM REQUESTS";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery(sql);
				while (rs.next()) {
					String img = rs.getString("RQ_IMAGE");
					a.add(new Requests(img));
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			} 
			return a;
	}

	@Override
	public boolean createRequest(int employeeId, String type, double amount, String info) {
			try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO REQUESTS (EMPLOYEE_ID, RQ_TYPE, RQ_AMT, INFO) VALUES (?,?,?,?)";	
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			pstmt.setString(2, type);
			pstmt.setDouble(3, amount);
			pstmt.setString(4, info);
			pstmt.executeUpdate();
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		return true;
	}

	
	
	@Override
	public List<Requests> getPendingRequests(int employeeId) {
		List<Requests> a = new ArrayList<>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT RQ_IMAGE FROM REQUESTS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				String img = rs.getString("RQ_IMAGE");
				a.add(new Requests(img));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
	}

	@Override
	public List<Requests> getResolvedRequests(int employeeId) {
		List<Requests> a = new ArrayList<>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT RQ_IMAGE FROM REQUESTS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				String img = rs.getString("RQ_IMAGE");
				a.add(new Requests(img));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
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
