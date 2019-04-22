package com.revature.project1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/NewRequest")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		double amount = request.getParameter("amount");
		String sAmount = Double.parseDouble(amount);
		
		
		String description = request.getParameter("description");
	
		
	
		
		String desc =request.getParameter("desc");
		String img = request.getParameter("inputRecipt");
		Request rq = new Requests(date, type, amount, desc, );
		String result = ra.requestA(reim);
		if(result !="") {
			response.sendRedirect("addEmployee");
		}else {
			//show alert employee was sucessfully been created
			response.sendRedirect("addEmployee");
		}

}
