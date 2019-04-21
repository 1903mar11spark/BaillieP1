package com.revature.project1.main;





import com.revature.project1.dao.EmpReqDaoImp;

public class Main {
	
	public static void main(String[] args) {
		
		EmpReqDaoImp erd = new EmpReqDaoImp();
		
		System.out.println(erd.createRequest(11,"TRAVEL EXPENSE", 434.00, "FLIGHT TO ZANZIBAR"));
		
	}
}
