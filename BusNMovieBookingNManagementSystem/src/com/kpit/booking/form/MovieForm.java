package com.kpit.booking.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

public class MovieForm extends ValidatorForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int movieID;
	private String title;
	private String director;
	private List<MovieForm> list;
	private List<String> showtimes;
	public List<String> getShowtimes() {
		return showtimes;
	}
	public void setShowtimes(List<String> showtimes) {
		this.showtimes = showtimes;
	}
	public List<MovieForm> getList() {
		return list;
	}
	public void setList(List<MovieForm> list) {
		this.list = list;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	@Override
	public String toString() {
		return "MovieForm [movieID=" + movieID + ", title=" + title + ", director=" + director + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	private Date date;
	private List<MovieForm> foundmovies;
	public List<MovieForm> getFoundmovies() {
		return foundmovies;
	}
	public void setFoundmovies(List<MovieForm> foundmovies2) {
		this.foundmovies = foundmovies2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
