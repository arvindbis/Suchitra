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
public class DeleteBusInfoAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BusModal busModal = new BusModal();
		ServletContext context = request.getServletContext();
		Connection connection = (Connection) context.getAttribute("connection");

		System.out.println("in DeleteBusInfoAction");
		System.out.println("selectedbusnumber" + request.getParameter("busNumber"));

		boolean result = busModal.deleteBusDetails(connection, request.getParameter("busNumber"));

		List<BusForm> list = new ArrayList<BusForm>();
		list = busModal.getBusDetails(connection);

		request.setAttribute("list", list);
		BusForm bus = (BusForm) form;
		bus.setList(list);
		if (result) {
			return mapping.findForward("succ");
		} else {

			return mapping.findForward("fail");
		}

	}
}
