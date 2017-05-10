package com.kpit.booking.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kpit.booking.form.PassengerForm;
import com.kpit.booking.modal.BusModal;

public class PassengerDetailsAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	System.out.println("IN PassengerDetailsAction");
	/*String value="passengerName"+0;
	String value1="passengerName"+1;
	
	
	System.out.println(value+"    "+value1);
	String name=request.getParameter(value);
	String name1=request.getParameter(value1);
	System.out.println(name+"      "+name1);*/
	ServletContext context=request.getServletContext();
	int noofseats=(Integer)context.getAttribute("numberOfSeats");
	List<PassengerForm> passengers=new ArrayList<PassengerForm>();
	for(int iter=0;iter<noofseats;iter++){
			PassengerForm passenger = new PassengerForm();
			String pName = "passengerName" + iter;
			String pGender = "passengerGender" + iter;
			String pAge = "passengerAge" + iter;
			String passengerName = request.getParameter(pName);
			String passengerGender = request.getParameter(pGender);
			String passengerage = request.getParameter(pAge);
			int age = Integer.parseInt(passengerage);
			String contact = request.getParameter("passengerContact");
			System.out.println(passengerName + " " + passengerGender + " " + passengerage);
			passenger.setPassengerName(passengerName);
			passenger.setGender(passengerGender);
			passenger.setAge(age);
			passenger.setContact(contact);
			passengers.add(passenger);
	}
	System.out.println("noofseats"+noofseats);
	Iterator<PassengerForm> iterator=passengers.iterator();
	while(iterator.hasNext()){
		System.out.println(iterator.next().toString());
	}
	BusModal bus=new BusModal();
	Connection connection=(Connection) context.getAttribute("connection");
	String busno=(String) context.getAttribute("busno");
	Date travelDate= (Date) context.getAttribute("travelDate");
	System.out.println("BUSNUMBER  "+busno);
	System.out.println("TRAVELDATE  "+travelDate);
	List<Integer> pid=new ArrayList<Integer>();
	pid=bus.addPassengerDetails(connection,busno,travelDate,passengers);
	
	List<String> list=new ArrayList<String>();
	list= (List<String>) context.getAttribute("seatNumbers");
	String busnumber=(String) context.getAttribute("busno");
	Date date=(Date) context.getAttribute("travelDate");
	System.out.println(busnumber+"      busnumber date    "+date);
	System.out.println(list);
	boolean value=bus.addSeatNumbers(connection,busno,list,pid,date);
	
	
	
	/*for(int j=0;j<noofSeats;j++){
		System.out.println(selectedSeats[j]);
		
	}*/
	/*BusForm busForm = (BusForm) form;
	busForm.setSeatNumbers(selectedSeats);*/
	if(value){
		return mapping.findForward("success");
	}
	else
		return mapping.findForward("failure");
	}
}
