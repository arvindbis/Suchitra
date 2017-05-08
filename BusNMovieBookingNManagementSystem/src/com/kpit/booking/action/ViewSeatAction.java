/**
 * 
 */
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

import com.kpit.booking.modal.BusModal;

/**
 * @author suchitras
 *
 */
public class ViewSeatAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String busNumber=request.getParameter("busNumber");
	
		System.out.println("Selected bus for booking ticket   :"+busNumber);
		HttpSession session=request.getSession();
		System.out.println("DATE");
		System.out.println(session.getAttribute("travelDate"));
		Date date=(Date) session.getAttribute("travelDate");
		
		
		//ServletContextEvent arg0;
		ServletContext context=request.getServletContext();
		context.setAttribute("busno", busNumber);
		context.setAttribute("travelDate", date);
		List<String> totalSeatsList=new ArrayList<String>();
		
		
		
		System.out.println(date.getTime());
		BusModal bus=new BusModal();
		
		Connection connection=(Connection) context.getAttribute("connection");
		List<String> femaleSeats=new ArrayList<String>();
		int countofFemaleSeats=bus.getnoofFemaleSeat(connection, busNumber, date);
		request.setAttribute("countofFemaleSeats", countofFemaleSeats);
		femaleSeats=bus.getFemaleSeatNumbers(connection, busNumber,date);
		System.out.println("femaleseatsfromdao "+request.getAttribute("femaleseatsfromdao"));
		
		List<String> maleSeats=new ArrayList<String>();
		int countofMaleSeats=bus.getnoofMaleSeat(connection, busNumber, date);
		maleSeats=bus.getMaleSeatNumbers(connection, busNumber,date);
		int totalSeats=countofMaleSeats+countofFemaleSeats;
		System.out.println("totalSeats :"+totalSeats);
		request.setAttribute("totalSeats", totalSeats);
		
		totalSeatsList=bus.getFemaleSeatNumbers(connection, busNumber,date);
		totalSeatsList.addAll(bus.getMaleSeatNumbers(connection, busNumber,date));
		
		
		System.out.println(totalSeatsList);
		Iterator<String> it=femaleSeats.iterator();
		System.out.println("Female Seats");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		Iterator<String> iterator=maleSeats.iterator();
		System.out.println("Male Seats");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		request.setAttribute("femaleSeats", femaleSeats);
		
		 request.setAttribute("maleSeats", maleSeats);

		return mapping.findForward("success");
		
		
	}

}
