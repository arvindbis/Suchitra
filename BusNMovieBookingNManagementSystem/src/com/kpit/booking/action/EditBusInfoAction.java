/**
 * 
 */
package com.kpit.booking.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
public class EditBusInfoAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BusModal busModal = new BusModal();
		ServletContext context = request.getServletContext();
		Connection connection = (Connection) context.getAttribute("connection");

		BusForm bus = (BusForm) form;

		System.out.println("in EditBusInfoAction");
		System.out.println("bus number(edit)" + bus.getBusNumber());
		System.out.println("bus name(edit)" + bus.getBusName());
		System.out.println("bus numberOfSeats(edit)" + bus.getNumberOfSeats());
		System.out.println("busType(edit)" +bus.getBusType());

		/*bus.setBusName(request.getParameter("busName"));
		bus.setBusNumber(request.getParameter("busNumber"));
		bus.setBusType(request.getParameter("busType"));
		bus.setNumberOfSeats(40);*/
		BusModal busModel = new BusModal();

		boolean result = busModel.editBusDetails(connection, bus);

		List<BusForm> list = new ArrayList<BusForm>();
		list = busModal.getBusDetails(connection);
		request.setAttribute("list", list);
		bus.setList(list);
		if (result) {

			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");
		}

	}

}
