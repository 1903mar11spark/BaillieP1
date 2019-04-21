package com.revature.project1.servlets;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.beans.Employees;
import com.revature.project1.beans.Login;
import com.revature.project1.service.AuthService;



public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5907583721624179922L;
	private AuthService as = new AuthService();

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
		// check whether session exists, and create one if not
		// overloaded version takes a boolean parameter, if false returns null when there is none
		HttpSession session = request.getSession();
		//grab credentials from request
		Login creds = new Login(request.getParameter("username"), request.getParameter("password"));
		//attempt to authenticate user
		Employees u = as.isValidUser(creds);
		if (u != null) {
			//set user information as session attributes (not request attributes!)
			//session.setAttribute("userId", u.getEmployeeId());
			session.setAttribute("firstname", u.getFirstName());
			session.setAttribute("lastname", u.getLastName());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("problem", null);
			//redirect user to profile page if authenticated
			response.sendRedirect("EmployeeHome"); //this has to be the url Mapping
		} else {
			System.out.println("success");
			session.setAttribute("problem", "invalid credentials");
			//otherwise redirect to login page
			System.out.println();
			response.sendRedirect("Login"); // this has to be the url mapping but also make sure
		}
	}
		
}
