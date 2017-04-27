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
import com.kpit.booking.modal.BusModal;

/**
 * @author suchitras
 *
 */
public class DeleteBusInfoAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in DeleteBusInfoAction");
		System.out.println("busnumber"+request.getParameter("busnumber"));
		BusModal bus=new BusModal();
		ServletContext context=request.getServletContext();
		Connection connection=(Connection) context.getAttribute("connection");
		boolean result=bus.deleteBusDetails(connection, request.getParameter("busnumber"));
		if(result){
			return mapping.findForward("succ");
		}
		else{
			
			return mapping.findForward("fail");
		}
			
	}

}
