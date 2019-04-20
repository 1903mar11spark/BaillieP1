package com.revature.project1.service;

import java.util.List;


import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Requests;
import com.revature.project1.dao.EmpReqDao;
import com.revature.project1.dao.EmpReqDaoImp;

public class RRServiceImp implements RRService{

	private EmpReqDao erd = new EmpReqDaoImp();
	
	@Override
	public List<Employees> getAllEmpMan() {

		return erd.getAllEmpMan();
	}

	@Override
	public List<Requests> getAllRequests() {
		
		return erd.getAllRequests();
	}

	@Override
	public List<Requests> getEmpReqFromMan() {

		return erd.getEmpReqFromMan();
	}

	@Override
	public boolean registerEmployee(Employees emp) {
		
		return erd.registerEmployee(emp);
	}
	
	

}
