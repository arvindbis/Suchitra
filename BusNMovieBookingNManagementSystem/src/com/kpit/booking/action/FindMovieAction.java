package com.kpit.booking.action;

import java.sql.Connection;
import java.text.SimpleDateFormat;
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

public class FindMovieAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ServletContext context=request.getServletContext();
		Connection connection=(Connection) context.getAttribute("connection");
		MovieForm movie=(MovieForm) form;
		System.out.println("Movie Watching Date: "+request.getParameter("moviewatchingdate"));
		MovieModal movieModal=new MovieModal();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	    Date date = null;

		date = dateFormat.parse(request.getParameter("moviewatchingdate"));
		HttpSession session = request.getSession();
		session.setAttribute("moviewatchingdate", date);
		System.out.println(date);
		
		List<MovieForm> foundmovies = new ArrayList<MovieForm>();
		foundmovies=movieModal.getMovies(date,connection);
		movie.setFoundmovies(foundmovies);
		context.setAttribute("foundmovies", foundmovies);
		Iterator<MovieForm> it=foundmovies.iterator();
		System.out.println("ALL MOVIES");
		while(it.hasNext()){
			System.out.println(it.next().getMovieID());
		}
		
		if(foundmovies.isEmpty()){
			return mapping.findForward("failure");
		}
		
		return mapping.findForward("success");
	}

}
