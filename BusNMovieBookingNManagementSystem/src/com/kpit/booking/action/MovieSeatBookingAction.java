package com.kpit.booking.action;

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

public class MovieSeatBookingAction extends Action{
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
		request.setAttribute("numberOfSeatsformovie", noofSeats);
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
		for(int i=0;i<=100;i++){
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
		context.setAttribute("numberOfSeatsformovie", noofSeats);
		context.setAttribute("seatNumbersformovie", selectedSeats);
		request.setAttribute("seatNumbersformovie", selectedSeats);
		Iterator<String> it=selectedSeats.iterator();
		while(it.hasNext()){
			System.out.println("sysout "+it.next());
		}
		
		System.out.println("noofSeats"+noofSeats);
		return mapping.findForward("customer");
	}


}
