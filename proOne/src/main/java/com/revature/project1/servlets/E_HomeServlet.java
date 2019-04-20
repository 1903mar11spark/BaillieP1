package com.revature.project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/result")
public class E_HomeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7539407230076728912L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//grab request attributes
		Enumeration<String> atts = req.getAttributeNames();
		while(atts.hasMoreElements()) {
			String s = atts.nextElement();
			System.out.println(s + " : " + req.getAttribute(s));
		}
		String error = (String) req.getAttribute("error");//sanitize user input
		PrintWriter pw = resp.getWriter();
		
		if(error == null || error.equals("")) {
			//throws null pointer exception -- will see a fair number of these--always check the input coming into server, first do the null check
			try {
				String answer = (String) req.getAttribute("");
				pw.write("<p style=\"margin:30px\"> The answer is: "+answer+"</p>");
			} catch (Exception e) {
				pw.write("<p style=\"margin:30px\">Error: invalid value</p>");
			}
		} else {
			pw.write("<p style=\"margin:30px\">Error: "+error+"</p>");
		}
		pw.write("<p style=\"margin:30px\"><a href=\"calculator\">GO BACK</a></p>");
		}
	
		
}

