/**
 * 
 */
package com.kpit.booking.action;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kpit.booking.form.UserRegistrationForm;
import com.kpit.booking.modal.LoginDao;

/**
 * @author suchitras
 *
 */
public class UserRegistrationAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In User Registration Action");
		System.out.println("new emailid"+request.getParameter("emailAddress")+"  "+request.getParameter("pwd"));
		UserRegistrationForm user=new UserRegistrationForm();
		user.setEmailAddress(request.getParameter("emailAddress"));
		user.setPwd(request.getParameter("pwd"));
		LoginDao dao=new LoginDao();
		ServletContext context=request.getServletContext();
		Connection connection=(Connection) context.getAttribute("connection");
		boolean result=dao.addNewUser(connection, user);
		if(result){
			return mapping.findForward("success");
		}
		else
			return mapping.findForward("failure");
	}
}
