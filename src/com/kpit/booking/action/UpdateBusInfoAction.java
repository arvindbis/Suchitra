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
public class UpdateBusInfoAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BusForm bus=new BusForm();
		System.out.println("UPDATE");
		System.out.println(request.getParameter("busname"));
		bus.setBusname(request.getParameter("busname"));
		bus.setBusnumber(request.getParameter("busnumber"));
		bus.setFromAddress(request.getParameter("fromAddress"));
		bus.setToAddress(request.getParameter("toAddress"));
		
		String departureTimeinString=request.getParameter("departureTime");
		float departureTime=Float.parseFloat(departureTimeinString); 
		bus.setDepartureTime(departureTime);
		String arrivalTimeinString=request.getParameter("arrivalTime");
		float arrivalTime=Float.parseFloat(arrivalTimeinString);
		bus.setArrivalTime(arrivalTime);
		BusModal newBus=new BusModal();
		ServletContext context=request.getServletContext();
		Connection connection=(Connection) context.getAttribute("connection");
		System.out.println("bustostring\n"+bus.toString());
		boolean result=newBus.editBusDetails(connection, bus);
		if(result){
			return mapping.findForward("success");
		}
		else
			return mapping.findForward("failure");
	}

}
