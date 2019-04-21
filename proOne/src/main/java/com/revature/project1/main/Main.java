package com.revature.project1.main;



import java.util.List;

import com.revature.project1.beans.Employees;
import com.revature.project1.dao.EmpReqDaoImp;

public class Main {
	
	public static void main(String[] args) {
		
		EmpReqDaoImp erd = new EmpReqDaoImp();
		
		List<Employees> bearList = erd.getAllEmpMan();

		
		for(Employees b : bearList) {
			System.out.println(b);
		}
	}
}
