/**
 * 
 */
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

/**
 * @author suchitras
 *
 */
public class EditMovieInfoAction extends Action{
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	ServletContext context = request.getServletContext();
	Connection connection = (Connection) context.getAttribute("connection");
	MovieForm movie = (MovieForm) form;
	MovieModal movieModel = new MovieModal();

	boolean result = movieModel.editBusDetails(connection, movie);

	List<MovieForm> list = new ArrayList<MovieForm>();
	list = movieModel.getMovieDetails(connection);
	request.setAttribute("movielist", list);
	movie.setList(list);
	if (result) {

		return mapping.findForward("success");
	} else {
		return mapping.findForward("failure");
	}
	
}
}
