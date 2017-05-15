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

import com.kpit.booking.form.MovieForm;
import com.kpit.booking.modal.MovieModal;

/**
 * @author suchitras
 *
 */
public class ViewMovieSeatAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Date moviewatchingdate = (Date) session.getAttribute("moviewatchingdate");
		System.out.println("\nmoviewatchingdate\n"+moviewatchingdate);
		MovieForm movie=(MovieForm) form;
		System.out.println(movie.getMovieID());
		System.out.println(movie.getTitle());
		ServletContext context=request.getServletContext();
		Connection connection=(Connection) context.getAttribute("connection");
		MovieModal movieModal=new MovieModal();
		List<String> seatlist = new ArrayList<String>();
		String showtime=request.getParameter("showtiming");
		System.out.println("showtime"+showtime);
		seatlist=movieModal.getMovieBookedSeats(connection,movie.getMovieID(),moviewatchingdate,showtime);
		request.setAttribute("boookedseats", seatlist);
		int noofbookedseats=seatlist.size();
		request.setAttribute("noofbookedseats", noofbookedseats);
		session.setAttribute("selectedmovieID", movie.getMovieID());
		session.setAttribute("selectedmovietiming",showtime);
		session.setAttribute("selectedmoviedate", moviewatchingdate);

		
		
		
		return mapping.findForward("success");
	}
}
