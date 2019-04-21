package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Login;
import com.revature.project1.beans.Requests;

public interface EmpReqDao {
	//13 methods
	
	public List<Employees> getAllEmpMan(); //10 get all employees and their managers
	//done
	public List<Requests> getAllRequests(); //9 requests from employees and see who resolved it 
	//done
	public List<Requests> getEmpReqFromMan(int employeeId);//7 view all requests from employees they manage 
	//done
	public List<Requests> getEmpReq(int empId, int manId); //11 view a singular rq form a single employee that they manage
	//done
	public List<Requests> getReciepts(); //8 view images of receipts form all requests
	//done
	public boolean createRequest(int employeeId, String type, double amount, String info); //1 NEED TO ADD IMAGE
	//done
	public List<Requests> getPendingRequests(int employeeId); //2 EMPLOYEE PENDING
	
	public List<Requests> getResolvedRequests(int employeeId); //3
	
	public void getEmployeeInfo(int employeeId); //4
	
	public void updateEmployeeInfo(Employees emp); //5 employee update names/email username = solid 
	
	public void resolveRequest(int requestId); //6 Manager can resolve requests
	
	public boolean getLogin(String username, String password); //13 get login
	
	public boolean registerEmployee(Employees emp); //12 register employee -- EXTRA

	

}
