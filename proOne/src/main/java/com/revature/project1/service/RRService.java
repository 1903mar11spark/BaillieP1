package com.revature.project1.service;

import java.util.List;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Requests;



public interface RRService {

	public List<Employees> getAllEmpMan();

	public List<Requests> getAllRequests(); 
	
	public List<Requests> getEmpReqFromMan();
	
	public boolean registerEmployee(Employees emp);
	
}
