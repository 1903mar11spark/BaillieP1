package com.revature.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class E_HomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7539407230076728912L;
	
	  public E_HomeServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("E_Home.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String str = session.getAttribute("username").toString();
		System.out.println(str);
		
		PrintWriter out = response.getWriter();
		out.print("Welcome " + str);
		
		}
	
}

