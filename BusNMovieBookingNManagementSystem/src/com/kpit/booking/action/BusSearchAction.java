/**
 * 
 */
package com.kpit.booking.action;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.kpit.booking.form.BusForm;
import com.kpit.booking.modal.BusModal;

/**
 * @author suchitras
 *
 */
public class BusSearchAction extends Action {
	
	/**
	 * 
	 */
	


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("BusSearchAction");
		BusForm busForm = ((BusForm) form);
		System.out.println(busForm.getFromAddress());
		System.out.println(busForm.getToAddress());
		System.out.println(request.getParameter("traveldate"));
		String fromAddress=request.getParameter("fromAddress");
		String toAddress=request.getParameter("toAddress");
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		    Date date = null;
			try {
				date =  dateFormat.parse(request.getParameter("traveldate"));
				HttpSession session=request.getSession();
				session.setAttribute("travelDate", date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
		
		    Calendar c = Calendar.getInstance();
		    c.setTime(date);
		    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		    System.out.println("dayOfWeek"+dayOfWeek);
		    String day;
		    if(dayOfWeek==1)
		    	day="sunday";
		    else if(dayOfWeek==2)
		    	day="monday";
		    else if(dayOfWeek==3)
		    	day="tuesday";
		    else if(dayOfWeek==4)
		    	day="wednesday";
		    else if(dayOfWeek==5)
		    	day="thursday";
		    else if(dayOfWeek==6)
		    	day="friday";
		    else 
		    	day="saturday";
		    System.out.println(day+"  day");
		    BusModal bus=new BusModal();
		    ServletContext context=request.getServletContext();
		    Connection connection=(Connection) context.getAttribute("connection");
		    List<String> busNumbers=new ArrayList<String>();
		    busNumbers=bus.findBusNumbers(connection,fromAddress,toAddress,day);
		    Iterator<String> it=busNumbers.iterator();
		    System.out.println("BUS NUMBERS FROM LIST");
			while(it.hasNext()){
				System.out.println(it.next());
			}
			List<BusForm> busDetails=new ArrayList<BusForm>();
			busDetails=bus.getFoundBusDetails(connection,busNumbers);
			 Iterator<BusForm> iterator=busDetails.iterator();
			 while(iterator.hasNext()){
				 System.out.println(iterator.next().toString());
			 }
			 request.setAttribute("foundbusdetails", busDetails);
			
			 busForm.setFoundbusdetails(busDetails);
		return mapping.findForward("success");
	}
	
		

	
	
}
