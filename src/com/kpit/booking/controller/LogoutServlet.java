package com.kpit.booking.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("logout");
		HttpSession session = req.getSession(); 
		session.removeAttribute("username");
		System.out.print("user is:"+session.getAttribute("username")); 
		session.invalidate();  
		
	
		Writer writer=resp.getWriter();
		writer.write("<br><p id='registrationsuccess'> Successful logout</p>");
		req.getRequestDispatcher("jsp/login.jsp").include(req, resp);
	}
}
