package com.revature.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
	///COME BACK AND UTILIZE DOA METHODS
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
		HttpSession session = request.getSession();
		//session.setMaxInactiveInterval(5*60); //ho ho getting it to go out in 5 min
		System.out.println(session.getId()+"lgin");
		
		
		Login login = new Login(request.getParameter("username"), request.getParameter("password"));
		Employees emp = as.isValidUser(login);
		
		if (emp != null) {
				String title = emp.getTitle();
				session.setAttribute("employeeId", emp.getEmployeeId());
				session.setAttribute("firstname", emp.getFirstName());
				session.setAttribute("lastName", emp.getLastName());
				session.setAttribute("title", emp.getTitle());
				session.setAttribute("email", emp.getEmail());
//				session.setAttribute("manager", emp.getManager());
//				session.setAttribute("reportsTo", emp.getReportsTo());
				System.out.println("so help me, you better work" + title);
			if (title != "" ) {
				if(title.equals("TEMP")) {
					//System.out.println(title);
					session.setAttribute("employeeId", emp.getEmployeeId());
					session.setAttribute("firstname", emp.getFirstName());
					session.setAttribute("lastName", emp.getLastName());
					session.setAttribute("title", emp.getTitle());
					session.setAttribute("email", emp.getEmail());
					session.setAttribute("reportsTo", emp.getReportsTo());
					response.sendRedirect("employeehome");//url pattern
					}else {
					session.setAttribute("employeeId", emp.getEmployeeId());
					session.setAttribute("firstName", emp.getFirstName());
					session.setAttribute("lastName", emp.getLastName());
					session.setAttribute("title", emp.getTitle());
					session.setAttribute("email", emp.getEmail());
//					session.setAttribute("reportsTo", emp.getReportsTo());
					response.sendRedirect("ManagerHome");
					}
				}
		}else {
				response.sendRedirect("login");
				//check file path
			}
		}
	}
	
   



		
