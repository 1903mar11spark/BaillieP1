package com.revature.project1.main;





import java.util.List;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Requests;
import com.revature.project1.dao.EmpReqDaoImp;

public class Main {
	
	public static void main(String[] args) {
		
		EmpReqDaoImp erd = new EmpReqDaoImp();
		erd.getEmployeeInfo(8);
//		List<Requests> bearList = erd.getResolvedRequests(10);
//	
//		for(Requests b : bearList) {
//			System.out.println(b);
		
		
		}
}
