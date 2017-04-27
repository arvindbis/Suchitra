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

import com.kpit.booking.form.BusForm;
import com.kpit.booking.modal.BusModal;

/**
 * @author suchitras
 *
 */
public class EditBusInfoAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in EditBusInfoAction");
		System.out.println("bus number(edit)"+request.getParameter("busnumber"));
		BusModal busModel=new BusModal();
		ServletContext context=request.getServletContext();
		Connection connection=(Connection) context.getAttribute("connection");
		boolean result=busModel.isBusDetailsExist(connection, request.getParameter("busnumber"));
		if(result){
			/*NewBusForm bus = new NewBusForm();*/
			BusForm bus=new BusForm();
			
		    bus=busModel.editBusDetails(connection, request.getParameter("busnumber"));
			System.out.println(bus.toString());
			return mapping.findForward("success");
		}else{
			return mapping.findForward("failure");
		}
		
	}

}
