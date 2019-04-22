package com.revature.project1.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.project1.beans.Login;
import com.revature.project1.dao.EmpReqDaoImp;
import com.revature.project1.util.ConnectionsUtil;

public class AuthService {
	
	public String isValidUser(Login login) {
		System.out.println(login);
	String enter = "";
	String username = login.getUsername();
	String password = login.getPassword();
	if (username != null && password != null) {
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
			String sql =  "SELECT * FROM LOGIN WHERE USERNAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			System.out.println(username);
			ResultSet rs= pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				String rPass = rs.getString("UPASSWORD");
				System.out.println(rPass);
				int eId = rs.getInt("EMPLOYEE_ID");
				enter = getEmployeeTitle(eId);
				System.out.println("This is the eId" + enter);
			}
			}
		 catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	return enter;

	}
	
	public String getEmployeeTitle(int eId) {
		String result ="";
		System.out.println(eId + "this should show 9");
		try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, eId);
		ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
					result=rs.getString("TITLE");
					System.out.println(result + "emp title");
					return result;
				}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}


		public String getEmployeeId(Login login) {
			String enter = ""; 
			String password = login.getPassword();
			String username = login.getUsername();
			if (username != null && password != null) {
				try (Connection con = ConnectionsUtil.getConnectionFromFile()) {
					String sql =  "SELECT EMPLOYEE_ID FROM LOGIN WHERE USERNAME = ? "
							+ "AND UPASSWORD= ?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1,username);
					pstmt.setString(2,password);
					ResultSet rs= pstmt.executeQuery();
					while(rs.next()) {
						int eId = rs.getInt("EMPLOYEE_ID");
						enter = Integer.toString(eId);
						System.out.println(enter + "perhaps the number");
						}
					
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
			}
			return enter;
		}
}