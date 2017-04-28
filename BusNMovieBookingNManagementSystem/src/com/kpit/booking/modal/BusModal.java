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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.kpit.booking.form.BusForm;
import com.kpit.booking.form.PassengerForm;

public class BusModal {
	public boolean addNewBusDetails(Connection connection, BusForm bus) {

		int value = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO BUS VALUES(?,?,?,?)");
			preparedStatement.setString(1, bus.getBusNumber());
			preparedStatement.setString(2, bus.getBusName());
			preparedStatement.setInt(3, bus.getNumberOfSeats());
			preparedStatement.setString(4, bus.getBusType());
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

	public boolean deleteBusDetails(Connection connection, String busNumber) {
		int value = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM BUS WHERE BUS_NUMBER=?");
			preparedStatement.setString(1, busNumber);
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

	public boolean isBusDetailsExist(Connection connection, String busNumber) {
		int value = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BUS WHERE BUS_NUMBER=?");
			preparedStatement.setString(1, busNumber);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				value = 1;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (value == 1) {

			return true;
		}

		else
			return false;

	}

	public List<BusForm> getBusDetails(Connection connection) {
		List<BusForm> list = new ArrayList<BusForm>();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM BUS";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				BusForm bus = new BusForm();
				bus.setBusName(rs.getString("BUS_NUMBER"));
				bus.setBusNumber(rs.getString("BUS_NAME"));
				bus.setNumberOfSeats(rs.getInt("NUMBER_OF_SEATS"));
				bus.setBusType(rs.getString("BUS_TYPE"));
				list.add(bus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean editBusDetails(Connection connection, BusForm bus) {
		int value = 0;
		PreparedStatement preparedStatement;
		System.out.println("EDIT");
		System.out.println(bus.getBusName());
		System.out.println(bus.getBusNumber());
		System.out.println(bus.getBusType());
		System.out.println(bus.getNumberOfSeats());

		try {
			preparedStatement = connection
					.prepareStatement("UPDATE BUS SET BUS_NAME=?,BUS_TYPE=?,NUMBER_OF_SEATS=? WHERE BUS_NUMBER=?");

			preparedStatement.setString(1, bus.getBusName());
			preparedStatement.setString(2, bus.getBusType());
			preparedStatement.setInt(3, bus.getNumberOfSeats());
			preparedStatement.setString(4, bus.getBusNumber());

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

	public List<String> findBusNumbers(Connection connection, String fromAddress, String toAddress, String day) {
		List<String> busNumbers=new ArrayList<String>();
		

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Select distinct(bus_number) from bus_route_mapping where day=? and route_id in (select route_id from route where source=? and destination=?);");
			preparedStatement.setString(1, day);
			preparedStatement.setString(2, fromAddress);
			preparedStatement.setString(3, toAddress);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				System.out.println(" BUS NUMBERS"+rs.getString("bus_number"));
				busNumbers.add(rs.getString("bus_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return busNumbers;

	}

	public List<BusForm> getFoundBusDetails(Connection connection, List<String> busNumbers) {
		
		Iterator<String> it=busNumbers.iterator();
		
		List<BusForm> busDetails=new ArrayList<BusForm>();
		
		while(it.hasNext()){
			BusForm bus=new BusForm();
			String busNumber=it.next();
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(
						"SELECT BUS_NUMBER,BUS_NAME,BUS_TYPE,number_of_seats FROM BUS WHERE BUS_NUMBER=?");
				preparedStatement.setString(1, busNumber);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					
					bus.setBusName(rs.getString("BUS_NAME"));
					bus.setBusNumber(rs.getString("BUS_NUMBER"));
					bus.setBusType(rs.getString("BUS_TYPE"));
					bus.setNumberOfSeats(rs.getInt("number_of_seats"));
					busDetails.add(bus);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return busDetails;
		
		
		
	}
	public int getnoofFemaleSeat(Connection connection,String busNumber, Date date){
		PreparedStatement preparedStatement;
		List<String> seats=new ArrayList<String>();
		System.out.println("Dateeeeeeeeeeeee"+date);
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT seat_number FROM seat_allocation WHERE bus_number=? and DATE=? and PID IN (SELECT PID FROM passenger_details WHERE gender='FEMALE');");
			preparedStatement.setString(1, busNumber);
			java.sql.Date travelingDate = new java.sql.Date(date.getTime());
		
			preparedStatement.setDate(2, travelingDate);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				seats.add(rs.getString("seat_number"));
			}
			System.out.println("SEAT SIZE"+seats.size());
			
			
			System.out.println("FEMALE SEATS"+seats);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seats.size();
	}
	public List<String> getFemaleSeatNumbers(Connection connection,String busNumber, Date date){
		PreparedStatement preparedStatement;
		List<String> seats=new ArrayList<String>();
		System.out.println("Dateeeeeeeeeeeee"+date);
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT seat_number FROM seat_allocation WHERE bus_number=? and DATE=? and PID IN (SELECT PID FROM passenger_details WHERE gender='FEMALE');");
			preparedStatement.setString(1, busNumber);
			java.sql.Date travelingDate = new java.sql.Date(date.getTime());
		
			preparedStatement.setDate(2, travelingDate);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				seats.add(rs.getString("seat_number"));
			}
			System.out.println("SEAT SIZE"+seats.size());
			
			
			System.out.println("FEMALE SEATS"+seats);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seats;
	}
	
	public List<String> getMaleSeatNumbers(Connection connection,String busNumber, Date date){
		PreparedStatement preparedStatement;
		List<String> seats=new ArrayList<String>();
		System.out.println("Dateeeeeeeeeeeee"+date);
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT seat_number FROM seat_allocation WHERE bus_number=? and DATE=? and PID IN (SELECT PID FROM passenger_details WHERE gender='MALE');");
			preparedStatement.setString(1, busNumber);
			java.sql.Date travelingDate = new java.sql.Date(date.getTime());
		
			preparedStatement.setDate(2, travelingDate);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				seats.add(rs.getString("seat_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seats;
	}
	public int getnoofMaleSeat(Connection connection,String busNumber, Date date){
		PreparedStatement preparedStatement;
		List<String> seats=new ArrayList<String>();
		System.out.println("Dateeeeeeeeeeeee"+date);
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT seat_number FROM seat_allocation WHERE bus_number=? and DATE=? and PID IN (SELECT PID FROM passenger_details WHERE gender='MALE');");
			preparedStatement.setString(1, busNumber);
			java.sql.Date travelingDate = new java.sql.Date(date.getTime());
		
			preparedStatement.setDate(2, travelingDate);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				seats.add(rs.getString("seat_number"));
			}
			System.out.println("SEAT SIZE"+seats.size());
			
			
			System.out.println("FEMALE SEATS"+seats);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seats.size();
	}
	public List<Integer> addPassengerDetails(Connection connection, String busno, Date travelDate, List<PassengerForm> passengers) {
		PreparedStatement preparedStatement;
		PreparedStatement preparedStatementforPid;
		Iterator<PassengerForm> iterator=passengers.iterator();
		List<Integer> pid=new ArrayList<Integer>();
		int value = 0;
		
		while(iterator.hasNext()){
			PassengerForm passenger=new PassengerForm();
			passenger=iterator.next();
			String passengerName=passenger.getPassengerName();
		    String gender=  passenger.getGender();
		    String contact= passenger.getContact();
		    int age=passenger.getAge();
		    
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO PASSENGER_DETAILS(NAME,AGE,GENDER,CONTACT) VALUES(?,?,?,?)");
				preparedStatement.setString(1,passengerName);
				preparedStatement.setInt(2,age);
				preparedStatement.setString(3,gender);
				preparedStatement.setString(4,contact);
				value=preparedStatement.executeUpdate();
				preparedStatementforPid=connection.prepareStatement("select pid from PASSENGER_DETAILS where name=? and age=? and gender=? and contact=?");
				preparedStatementforPid.setString(1, passengerName);
				preparedStatementforPid.setInt(2,age);
				preparedStatementforPid.setString(3,gender);
				preparedStatementforPid.setString(4, contact);
				ResultSet rs=preparedStatementforPid.executeQuery();
				while(rs.next()){
					pid.add(rs.getInt("pid"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("value"+value);
		Iterator<Integer> it=pid.iterator();
		while(it.hasNext()){
			System.out.println("PID: "+it.next());
		}
			
			return pid;
			
		
		
		
	}

	public void addSeatNumbers(Connection connection,String busno, List<String> list, List<Integer> pid, Date date) {
		PreparedStatement preparedStatement;
		Iterator<String> it=list.iterator();
		String[] seats=new String[40];
		int iter=0;
		while(it.hasNext()){
			seats[iter++]=it.next();
		}
		
		Iterator<Integer> iterator=pid.iterator();
		int j=0;
		while(iterator.hasNext()){
			int passengerId=iterator.next();
			try {
				preparedStatement=connection.prepareStatement("insert into seat_allocation values(?,?,?,?)");
				preparedStatement.setString(1, busno);
				preparedStatement.setString(2, seats[j++]);
				preparedStatement.setInt(3, passengerId);
				java.sql.Date travelingDate = new java.sql.Date(date.getTime());
				preparedStatement.setDate(4, travelingDate);
				int value=preparedStatement.executeUpdate();
				System.out.println("UPDATE: "+value);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	
	

}
