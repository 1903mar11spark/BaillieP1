package com.revature.project1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.beans.Employees;

public class SessionServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3616463879993422408L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("employeeId"));
		if (session != null && session.getAttribute("employeeId") != null) {
			try {
				int empId = Integer.parseInt(session.getAttribute("employeeId").toString());
				response.getWriter().write((new ObjectMapper()).writeValueAsString(empId));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
				System.out.println("Is this what you really wanted in life?");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	}
		
//	String req= request.getParameter("reqTyp");
//	System.out.println(request.getParameter("reqTyp"));
//
//	;
//	if ( session !=null && session.getAttribute("userId")!=null) {
//		try {
//			switch (req) {
//			case("viewInfo"):{
//				int userId = Integer.parseInt(session.getAttribute("userId").toString());
//				int boss = Integer.parseInt(session.getAttribute("boss").toString());
//				String fName = session.getAttribute("fName").toString();
//				String lName = session.getAttribute("lName").toString();
//				
//				Employees e = new Employees (userId, boss, fName, lName);
//				System.out.println(e);
//				String resp = new ObjectMapper().writeValueAsString(e);
//				
//				response.getWriter().write(resp);
//				
//				System.out.println(resp);
//				break;
//			}default:response.getWriter().write("You broke this.");;
//			}
//		
//
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



}
