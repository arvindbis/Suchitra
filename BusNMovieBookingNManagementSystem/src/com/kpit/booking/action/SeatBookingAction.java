package com.kpit.booking.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
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

public class SeatBookingAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("SEAT BOOKING ");
		
		String noofseatsinString=request.getParameter("noofseatselectedbyuser");
		if(noofseatsinString.isEmpty()){
			return mapping.findForward("failure");
		}
		int noofSeats=Integer.parseInt(noofseatsinString);
		if(noofSeats==0){
			return mapping.findForward("failure");
		}
		
	
		
		request.setAttribute("numberOfSeats", noofSeats);
		List<String> seatNumbers=new ArrayList<String>();
		for(int iter=0;iter<noofSeats;iter++){
			String seatnumber="bs"+iter;
			System.out.println(request.getParameter(seatnumber));
			seatNumbers.add(request.getParameter(seatnumber));
		}
		
		System.out.println("NO OF SEAT SELECTED BY USER: "+noofseatsinString);
		/*String[] selectedSeats=new String[40];*/
		List<String> selectedSeats=new ArrayList<String>();
		//int iter=0;
		System.out.println("SEATS ARE");
		for(int i=0;i<=40;i++){
			String seat="s"+i+"s";
			String snum=request.getParameter(seat);
			
			if(snum==null){
				//System.out.println(snum);
			}else{
				selectedSeats.add(snum);
				/*selectedSeats[iter++]=snum;*/
			}
		}
		
		ServletContext context=request.getServletContext();
		context.setAttribute("numberOfSeats", noofSeats);
		context.setAttribute("seatNumbers", selectedSeats);
		request.setAttribute("seatNumbers", selectedSeats);
		Iterator<String> it=selectedSeats.iterator();
		while(it.hasNext()){
			System.out.println("sysout "+it.next());
		}
		BusModal bus=new BusModal();
		Connection connection=(Connection) context.getAttribute("connection");
		List<String> pickupPoints=new ArrayList<String>();
		List<String> droppingPoints=new ArrayList<String>();	
		String busno=(String) context.getAttribute("busno");
		String day=(String) context.getAttribute("travelDay");
		String fromAddress=(String) context.getAttribute("travelFromAddress");
		String toAddress=(String) context.getAttribute("travelToAddress");
		
		String routeID=bus.getRouteId(connection,fromAddress,toAddress);
		pickupPoints=bus.findPickupPoints(connection,busno,day,routeID);
		Iterator<String> it1=pickupPoints.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		droppingPoints=bus.findDroppingPoints(connection,busno,day,routeID);
		Iterator<String> it2=droppingPoints.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		System.out.println("BUSNUMBERRRRRRRRRR"+busno+"\n day "+day+"\nrouteID  "+routeID);
		BusForm busForm=(BusForm) form;
		context.setAttribute("pickupPoints", pickupPoints);
		context.setAttribute("droppingPoints", droppingPoints);
		busForm.setPickupPoints(pickupPoints);
		busForm.setDroppingPoints(droppingPoints);
		
		return mapping.findForward("passengers");
	}

}
