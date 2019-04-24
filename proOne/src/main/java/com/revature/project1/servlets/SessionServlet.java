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
		if (session != null && session.getAttribute("employeeId") != null) {
			try {
				int userId = Integer.parseInt(session.getAttribute("employeeId").toString());
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String title = session.getAttribute("title").toString();
				System.out.println(session.getAttribute("lastname")+"here we are");
				
				Employees u = new Employees(userId, firstname, lastname, title);
				System.out.println(u);
				
				String resp = new ObjectMapper().writeValueAsString(u);
				response.getWriter().write(resp);
				
				System.out.println(resp + "servelt session 1");
				
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
				System.out.println(session + "SESSION SERVLET2");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
			System.out.println(session + "SESSION SERVLET3");
		}
		
	}
	
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
