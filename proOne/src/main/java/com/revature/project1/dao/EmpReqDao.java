package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Requests;

public interface EmpReqDao {
	//13 methods
	
	public List<Employees> getAllEmpMan(); //10 get all employees and their managers
	
	public List<Requests> getAllRequests(); //9 requests from employees and see who resolved it 
	
	public List<Requests> getEmpReqFromMan();//7 view all requests form employees they manage 
	
	public List<Requests> getEmpReq(); //11 view a singular rq form a single employee that they manage
	
	public List<Requests> getReciepts(); //8 view images of receipts form all requests
	
	public boolean createRequest(int employeeId, int managedId, String type, double amount); //1 NEED TO ADD IMAGE
	
	public List<Requests> getPendingRequests(int employeeId); //2
	
	public List<Requests> getResolvedRequests(int employeeId); //3
	
	public void getEmployeeInfo(Employees emp); //4
	
	public void updateEmployeeInfo(Employees emp); //5 employee update names/email username = solid 
	
	public void resolveRequest(int requestId); //6 Manager can resolve requests
	
	public Employees getLogin(String username, String password); //13 get login
	
	public boolean registerEmployee(Employees emp); //12 register employee -- EXTRA
	

}
