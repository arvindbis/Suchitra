package com.kpit.booking.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FilterUser implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("suchia");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);

		System.out.println("filter  outside");
		if (session == null || session.getAttribute("username") == null) {
			System.out.println("filter");

			req.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			// resp.sendRedirect("jsp/login.jsp"); // No logged-in user found,
			// so redirect to login page.

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
