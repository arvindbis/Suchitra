package com.kpit.booking.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout");
		req.getRequestDispatcher("jsp/login.jsp").include(req, response);
		HttpSession session=req.getSession();
		session.invalidate();
		Writer writer=response.getWriter();
		writer.write("<p id='logoutmsg'>Logout successful </p>");
				
		}
}
