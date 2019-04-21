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
import com.revature.project1.beans.Login;
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
				String image = rs.getString("RQ_IMAGE");
				String info = rs.getString("INFO");
				a.add(new Requests(rq, em, man, date, type, amt, stat, image, info));
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
				int man = rs.getInt("MANAGEDBY");
				Date date = rs.getDate("RQ_DATE");
				String type = rs.getString("RQ_TYPE");
				double amt = rs.getDouble("RQ_AMT");
				String stat = rs.getString("REQUEST_STATUS");
				String image = rs.getString("RQ_IMAGE");
				String info = rs.getString("INFO");
				a.add(new Requests(rq, em, man, date, type, amt, stat,image, info));
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

	
	
	@Override //#2 
	public List<Requests> getPendingRequests(int employeeId) {
		List<Requests> a = new ArrayList<Requests>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT REQUEST_ID, EMPLOYEE_ID, RQ_DATE, RQ_TYPE, RQ_AMT, "
					+ "REQUEST_STATUS, RQ_IMAGE, INFO FROM REQUESTS WHERE EMPLOYEE_ID= ? "
					+ "AND REQUEST_STATUS='PENDING'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int rq = rs.getInt("REQUEST_ID");
				int em = rs.getInt("EMPLOYEE_ID");
				Date date = rs.getDate("RQ_DATE");
				String type = rs.getString("RQ_TYPE");
				double amt = rs.getDouble("RQ_AMT");
				String stat = rs.getString("REQUEST_STATUS");
				String img = rs.getString("RQ_IMAGE");
				String info = rs.getString("INFO");
				a.add(new Requests(rq, em, date, type,  amt, img, stat, info));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
	}
	

	@Override
	public List<Requests> getResolvedRequests(int employeeId) {
		List<Requests> a = new ArrayList<Requests>();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT REQUEST_ID, EMPLOYEE_ID, RQ_DATE, RQ_TYPE, RQ_AMT,"
					+ " REQUEST_STATUS, RQ_IMAGE, INFO FROM REQUESTS WHERE EMPLOYEE_ID= ? "
					+ "AND REQUEST_STATUS='RESOLVED'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int rq = rs.getInt("REQUEST_ID");
				int em = rs.getInt("EMPLOYEE_ID");
				Date date = rs.getDate("RQ_DATE");
				String type = rs.getString("RQ_TYPE");
				double amt = rs.getDouble("RQ_AMT");
				String stat = rs.getString("REQUEST_STATUS");
				String img = rs.getString("RQ_IMAGE");
				String info = rs.getString("INFO");
				a.add(new Requests(rq, em, date, type,  amt, img, stat, info));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return a;
	}

	@Override 
	public void getEmployeeInfo(int employeeId) {
		Employees emp = new Employees();
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT TITLE, FIRSTNAME, LASTNAME, EMAIL FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			pstmt.executeUpdate();
			System.out.println("Successful for retreving info");
			while (rs.next()) {
				String type = rs.getString("RQ_TYPE");
				String stat = rs.getString("REQUEST_STATUS");
				String img = rs.getString("RQ_IMAGE");
				String info = rs.getString("INFO");
				emp.add(title, firstname, lastname, email);
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}

	

	@Override
	public void resolveRequest(int requestId) {
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "UPDATE REQUESTS SET REQUEST_STATUS = 'RESOLVED' WHERE REQUEST_ID=?";	
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, requestId);
			pstmt.executeUpdate();
			System.out.println("Successful for requests");
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();	
		}
		
	}

	@Override
	public boolean getLogin(String username, String password) {
		PreparedStatement pstmt = null;
		boolean toLogin = false;
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql = "SELECT USERNAME, UPASSWORD FROM LOGIN WHERE USERNAME=? AND UPASSWORD=?";
			pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					toLogin = true;
					return toLogin;
				}else {
					System.out.println("Doesn't match bruv");
					return toLogin;
			} 
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return toLogin;
		
	}
	

	@Override //AFTER MVP
	public boolean registerEmployee(Employees emp) {
		
		return false;
	}

	@Override
	public void updateEmployeeInfo(Employees emp) {
		// TODO Auto-generated method stub
		
	}

	

}
