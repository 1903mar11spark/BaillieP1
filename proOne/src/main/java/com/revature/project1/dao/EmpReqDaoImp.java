package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Requests;

public class EmpReqDaoImp implements EmpReqDao {

	@Override
	public List<Employees> getAllEmpMan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Requests> getAllRequests() {
		// TODO Auto-generated method stub
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
