package com.revature.project1.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5907583721624179922L;

	public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtain request parameters
		String paramN1 = request.getParameter("username");
		String paramN2 = request.getParameter("password");
		
		//define some variables
		String answer = "";
		String error = "";
		
		//null check
		if (paramN1 == null && paramN2 == null) {
			error = "Please enter a username and password";
		}
		
		//write to the response
		//response.getWriter().write("the answer is: " + answer);
		
		//include answer and error as attributes of the request
		//and forward request to another servlet
		request.setAttribute("username", answer);
		request.setAttribute("error", error);
		
		RequestDispatcher rd = request.getRequestDispatcher("result");
		rd.forward(request, response);
		
	}

	
}
