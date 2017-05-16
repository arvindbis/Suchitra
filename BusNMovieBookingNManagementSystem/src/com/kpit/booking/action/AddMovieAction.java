package com.kpit.booking.action;

import java.sql.Connection;
import java.util.ArrayList;
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

public class AddMovieAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("ADDMOVIEACTION");
		MovieForm movie = ((MovieForm) form);
		MovieModal newMovie = new MovieModal();
		ServletContext context = request.getServletContext();
		Connection connection = (Connection) context.getAttribute("connection");
		boolean result = newMovie.addNewMovieDetails(connection, movie);
		if (result) {
			List<MovieForm> list = new ArrayList<MovieForm>();
			list = newMovie.getMovieDetails(connection);
			movie.setList(list);
			System.out.println("LIST");
			return mapping.findForward("success");
		} else
			return mapping.findForward("failure");
	}

}
