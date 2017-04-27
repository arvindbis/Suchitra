/**
 * 
 */
package com.kpit.booking.action;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kpit.booking.form.UserForm;
import com.kpit.booking.modal.LoginDao;

/**
 * @author suchitras
 *
 */
public class UserAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm user=new UserForm();
		user.setEmail(request.getParameter("email"));
		System.out.println("email:"+request.getParameter("email"));
		System.out.println("password:"+request.getParameter("password"));
		user.setPassword(request.getParameter("password"));
		HttpSession session=((HttpServletRequest) request).getSession();
		session.setAttribute("username", request.getParameter("email"));
		if(request.getParameter("email").equals("suchitras@gmail.com")&&request.getParameter("password").equals("suchitras")){
			
			return mapping.findForward("admin");
		}
		else{
			LoginDao dao=new LoginDao();
			ServletContext context=request.getServletContext();
			Connection connection=(Connection) context.getAttribute("connection");
			System.out.println("connection :"+connection);
			boolean result=dao.isUserPresent(connection, user);
			System.out.println("result: "+result);
			if(result){
				return mapping.findForward("otheruser");
			}
			else
				return mapping.findForward("failure");
		}
		
	}

}
