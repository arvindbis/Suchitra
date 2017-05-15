/**
 * 
 */
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

import com.kpit.booking.form.MovieForm;
import com.kpit.booking.modal.MovieModal;

/**
 * @author suchitras
 *
 */
public class MovieInfoAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MovieModal movie=new MovieModal();
		ServletContext context=request.getServletContext();
		Connection connection=(Connection) context.getAttribute("connection");
		List<MovieForm> list=new ArrayList<MovieForm>();
		list=movie.getMovieDetails(connection);
		
		Iterator<MovieForm> it=list.iterator();
		request.setAttribute("movielist", list);
		MovieForm bus=(MovieForm) form;
		bus.setList(list);
		System.out.println("LIST");
		while(it.hasNext()){
			
			System.out.println(it.next().toString());
		}
		return mapping.findForward("movielist");
	}

}
