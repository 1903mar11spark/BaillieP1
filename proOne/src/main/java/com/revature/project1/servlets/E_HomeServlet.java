package com.revature.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.project1.dao.EmpReqDaoImp;

public class E_HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 7539407230076728912L;
	private ObjectMapper om;
	private EmpReqDaoImp erd;
	// this is our service class whose methods we will call

	//from Bear demo

	  public E_HomeServlet() {
		  	erd = new EmpReqDaoImp();
		  	om = new ObjectMapper();
			
	    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("E_Home.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				int typeId = Integer.parseInt(request.getParameter("employeeId"));	
				String image = request.getParameter("image");
				double amt = Double.parseDouble(request.getParameter("amount"));
				String info = request.getParameter("info");
				erd.createRequest(typeId, image, amt, info);
				
				//request.getRequestDispatcher("E_Home.html").forward(request, response);
			//put this on all for sesssionnnnssss
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
		
		}
	
}

