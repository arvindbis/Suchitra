package com.kpit.booking.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
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

public class BusInfoAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session!=null){
		BusModal newBus=new BusModal();
		ServletContext context=request.getServletContext();
		Connection connection=(Connection) context.getAttribute("connection");
		List<BusForm> list=new ArrayList<BusForm>();
		list=newBus.getBusDetails(connection);
		
		Iterator<BusForm> it=list.iterator();
		request.setAttribute("list", list);
		BusForm bus=(BusForm) form;
		bus.setList(list);
		System.out.println("LIST");
		while(it.hasNext()){
			
			System.out.println(it.next().toString());
		}
		
		return mapping.findForward("buslist");
	}
		else{
			System.out.println("session is not null");
			
			return mapping.findForward("failure");
			}
	}
	
	
}
