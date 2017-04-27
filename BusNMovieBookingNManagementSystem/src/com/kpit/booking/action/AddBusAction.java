package com.kpit.booking.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kpit.booking.form.BusForm;
import com.kpit.booking.modal.BusModal;

public class AddBusAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("CLASS"+((BusForm) form).getBusNumber());

		HttpSession session = request.getSession(false);
		if (session != null) {
			System.out.println("session is not null");
			
			BusForm bus = ((BusForm) form);

			
/*
			bus.setBusName(bus.getBusName());
			bus.setBusNumber(bus.getBusNumber());
			bus.setNumberOfSeats(40);
			bus.setBusType(bus.getBusType());*/
			
		
			System.out.println(bus.getBusName());
			System.out.println(bus.getBusNumber());

			System.out.println(bus.getBusType());

			BusModal newBus = new BusModal();
			ServletContext context = request.getServletContext();
			Connection connection = (Connection) context.getAttribute("connection");
			boolean result = newBus.addNewBusDetails(connection, bus);
			if (result) {
				List<BusForm> list = new ArrayList<BusForm>();
				list = newBus.getBusDetails(connection);
				bus.setList(list);
				System.out.println("LIST");
				return mapping.findForward("success");
			} else
				return mapping.findForward("failure");
		}
		/* if session is null */
		else {
			
			return mapping.findForward("failure");
		}
	}

}
