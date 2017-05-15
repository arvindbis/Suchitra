package com.kpit.booking.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
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

import com.kpit.booking.form.PassengerForm;
import com.kpit.booking.modal.MovieModal;

public class CustomerDetailsAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		System.out.println("IN CustomerDetailsAction");
		List<PassengerForm> customer=new ArrayList<PassengerForm>();
		ServletContext context=request.getServletContext();
		int noofseats=(Integer)context.getAttribute("numberOfSeatsformovie");
		System.out.println("noofseats"+noofseats);
	
		List<String> seats=new ArrayList<String>();
				seats=(List<String>) context.getAttribute("seatNumbersformovie");
		System.out.println("SEATS MOVIE");
		Iterator<String> it=seats.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		for(int iter=0;iter<noofseats;iter++){
			PassengerForm passenger = new PassengerForm();
			String cName = "customerName" + iter;
			
			String customerName = request.getParameter(cName);
			
			String contact = request.getParameter("customerContact");
			System.out.println(customerName+"  "+contact);
			passenger.setPassengerName(customerName);
			passenger.setContact(contact);
			customer.add(passenger);
	}
		int movieId=(int) session.getAttribute("selectedmovieID");
		String movieTimimg=(String) session.getAttribute("selectedmovietiming");
		Date moviewatchingDate=(Date) session.getAttribute("selectedmoviedate");
		System.out.println("movieId"+movieId+"\n"+movieTimimg+"\n"+moviewatchingDate);
		MovieModal movieModal=new MovieModal();
		Connection connection=(Connection) context.getAttribute("connection");
		List<Integer> customerId=new ArrayList<Integer>();
		customerId=movieModal.getCustomerId(connection,customer);
		Iterator<Integer> iter=customerId.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		boolean value=movieModal.getShowingTimeofMovie(connection, movieId, moviewatchingDate,movieTimimg);
		if(value){
			String showId=movieModal.getshowId(connection,movieId,moviewatchingDate,movieTimimg);
			int seatReservationId=movieModal.doSeatReservation(connection,showId,seats,customerId);
			System.out.println("seatReservationId"+seatReservationId);

			System.out.println("showId "+showId);
			request.setAttribute("resevationid", seatReservationId);
			if(showId.equals(null)){
				return mapping.findForward("failure");
			}
		}else{
			return mapping.findForward("shownotexit");
		}
		
		
		
		return mapping.findForward("success");
	}

}
