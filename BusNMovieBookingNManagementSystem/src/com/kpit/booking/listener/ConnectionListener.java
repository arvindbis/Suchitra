package com.kpit.booking.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ConnectionListener implements ServletContextListener{
	private DataSource dataSource;
	private Connection connection;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("database");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			System.err.println("the NamingException is" + e);
		}catch (SQLException e) {
			System.err.println("the SQLException is" + e);
		}
		ServletContext context=arg0.getServletContext();
		context.setAttribute("connection", connection);
		System.out.println("in listener "+connection);
	}

}
