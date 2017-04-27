package com.kpit.booking.action;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kpit.booking.form.NewBusForm;
import com.kpit.booking.modal.BusModal;

public class AddBusAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		NewBusForm bus=new NewBusForm();
		System.out.println(request.getParameter("newbusname"));
		bus.setNewbusname(request.getParameter("newbusname"));
		bus.setNewbusnumber(request.getParameter("newbusnumber"));
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
		boolean result=newBus.addNewBusDetails(connection, bus);
		if(result){
			return mapping.findForward("success");
		}
		else
			return mapping.findForward("failure");
		
	}

}
