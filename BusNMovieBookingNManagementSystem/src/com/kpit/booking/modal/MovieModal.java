package com.kpit.booking.modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.kpit.booking.form.MovieForm;
import com.kpit.booking.form.PassengerForm;

public class MovieModal {

	public List<MovieForm> getMovies(Date date,Connection connection) {
		List<MovieForm> list = new ArrayList<MovieForm>();
		try {
			java.sql.PreparedStatement preparedStatement=connection.prepareStatement("select title,movie_id from movie m where m.movie_id in (select movie_id from screening where date=?)");
			java.sql.Date movieWatchingDate=new java.sql.Date(date.getTime());
			preparedStatement.setDate(1, movieWatchingDate);
			ResultSet rs=preparedStatement.executeQuery();
			System.out.println("movies");
			while(rs.next()){
				MovieForm movie=new MovieForm();
			    movie.setTitle(rs.getString("title"));
			    movie.setMovieID(rs.getInt("movie_id"));
			    list.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<MovieForm> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		
		return list;
		
	}

	public List<MovieForm> getMovieDetails(Connection connection) {
		List<MovieForm> list = new ArrayList<MovieForm>();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM Movie";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				MovieForm movie = new MovieForm();
				String mId=rs.getString("movie_id");
				int movieID=Integer.parseInt(mId);
				movie.setMovieID(movieID);
				movie.setTitle(rs.getString("title"));
				movie.setDirector(rs.getString("director"));
				list.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public boolean addNewMovieDetails(Connection connection, MovieForm movie) {
		if (movie.getTitle().equals("") | movie.getDirector().equals("")) {
			return false;
		}
		int value = 0;
		java.sql.PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO MOVIE(TITLE,DIRECTOR) VALUES(?,?)");
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getDirector());
			value = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (value == 1)
			return true;
		else
			return false;
	}

	public boolean deleteBusDetails(Connection connection, int movieID) {
		int value = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM MOVIE WHERE MOVIE_ID=?");
			preparedStatement.setLong(1, movieID);
			value = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (value == 1) {
			System.out.println(" bus record Deleted");
			return true;
		}

		else
			return false;
	}

	public boolean editBusDetails(Connection connection, MovieForm movie) {
		if (movie.getTitle().equals("")|movie.getDirector().equals("")) {
			return false;
		}
		int value = 0;
		PreparedStatement preparedStatement;
		System.out.println("EDIT");
		

		try {
			preparedStatement = connection
					.prepareStatement("UPDATE MOVIE SET TITLE=?,DIRECTOR=? WHERE MOVIE_ID=?");

			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getDirector());
			preparedStatement.setInt(3, movie.getMovieID());
			value = preparedStatement.executeUpdate();
			System.out.println("value = " + value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (value == 1) {
			System.out.println("edit successful");
			return true;
		}

		else {
			System.out.println("edit unsuccessful");
			return false;
		}
	}

	

	public List<String> getMovieBookedSeats(Connection connection, int movieID, Date moviewatchingdate,String showtime) {
			
		List<String> list = new ArrayList<String>();
		try {
			java.sql.PreparedStatement preparedStatement=connection.prepareStatement("select seatnumber from seat_reservation where show_id in (select show_id from screening where movie_id=? and date=? and timing=?)");
			java.sql.Date movieWatchingDate=new java.sql.Date(moviewatchingdate.getTime());
			preparedStatement.setInt(1, movieID);
			preparedStatement.setDate(2, movieWatchingDate);
			preparedStatement.setString(3, showtime);
			ResultSet rs=preparedStatement.executeQuery();
			System.out.println("booked seats");
			while(rs.next()){
				String seat=rs.getString("seatnumber");
			    list.add(seat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		return list;
	}

	public List<Integer> getCustomerId(Connection connection, List<PassengerForm> customer) {
		List<Integer> list = new ArrayList<Integer>();
		Iterator<PassengerForm> it=customer.iterator();
		int value =0;
		while(it.hasNext()){
			PassengerForm passenger=new PassengerForm();
			passenger=it.next();
			String customerName=passenger.getPassengerName();
		    String contact= passenger.getContact();
			try {
				java.sql.PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO CUSTOMER (NAME,CONTACT) VALUES(?,?)");
				preparedStatement.setString(1, customerName);
				preparedStatement.setString(2, contact);
				value = preparedStatement.executeUpdate();
				java.sql.PreparedStatement preparedStatementforGettingId=connection.prepareStatement("SELECT CUSTOMER_ID FROM CUSTOMER WHERE NAME=? AND CONTACT=?");
				preparedStatementforGettingId.setString(1, customerName);
				preparedStatementforGettingId.setString(2, contact);
				ResultSet rs=preparedStatementforGettingId.executeQuery();
				while(rs.next()){
					list.add(rs.getInt("customer_id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Movie value"+value);
		}
		
		
		
		return list;
		
	}
	
	public String getshowId(Connection connection, int movieId, Date moviewatchingDate, String movieTimimg) {
		String showID=null;
		java.sql.PreparedStatement preparedStatementforGettingId;
		
		
				try {
					preparedStatementforGettingId = connection.prepareStatement("SELECT SHOW_ID FROM SCREENING WHERE MOVIE_ID=? AND DATE=? AND TIMING=?");
					preparedStatementforGettingId.setInt(1, movieId);
					java.sql.Date movieWatchingDate=new java.sql.Date(moviewatchingDate.getTime());
					preparedStatementforGettingId.setDate(2, movieWatchingDate);;
					preparedStatementforGettingId.setString(3, movieTimimg);
					ResultSet rs=preparedStatementforGettingId.executeQuery();
					while(rs.next()){
						showID=rs.getString("SHOW_ID");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return showID;
	}

	public int doSeatReservation(Connection connection, String showId, List<String> seats, List<Integer> customerId) {
		Iterator<String> it=seats.iterator();
		int i=0;
		int value=0;
		int seatReservationId=0;
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("Select max(SEAT_RESERVATION_ID) from seat_reservation");
			while(resultSet.next()){
				 seatReservationId=resultSet.getInt("max(SEAT_RESERVATION_ID)");
			}
			System.out.println(seatReservationId);
			seatReservationId+=1;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(it.hasNext()){
			System.out.println("customerId.get"+customerId.get(i));
			try {
				java.sql.PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO SEAT_RESERVATION (SEAT_RESERVATION_ID,SHOW_ID,SEATNUMBER,CUSTOMER_ID) VALUES(?,?,?,?)");
				preparedStatement.setInt(1, seatReservationId);
				preparedStatement.setString(2, showId);
				preparedStatement.setString(3, it.next());
				preparedStatement.setInt(4, customerId.get(i));
				value=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			System.out.println("seat reservation update "+value);
		}
		return seatReservationId;
	}

	public boolean getShowingTimeofMovie(Connection connection, int movieID, Date date, String movieTimimg) {
		boolean result=false;
		List<String> showtimeList=new ArrayList<String>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT TIMING FROM SCREENING WHERE MOVIE_ID=? AND DATE=?");
			preparedStatement.setInt(1, movieID);
			java.sql.Date movieWatchingDate=new java.sql.Date(date.getTime());
			preparedStatement.setDate(2, movieWatchingDate);;
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()){
				showtimeList.add(rs.getString("TIMING"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<String> it=showtimeList.iterator();
		while(it.hasNext()){
			if(it.next().equals(movieTimimg)){
				result=true;
			}
		}
		
		return result;
	}

}
