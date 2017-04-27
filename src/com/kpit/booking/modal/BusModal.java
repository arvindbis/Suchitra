package com.kpit.booking.modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.kpit.booking.form.BusForm;
import com.kpit.booking.form.NewBusForm;

public class BusModal {
	public boolean addNewBusDetails(Connection connection, NewBusForm bus) {

		int value = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO BUS VALUES(?,?,?,?,?,?)");
			preparedStatement.setString(1, bus.getNewbusnumber());
			preparedStatement.setString(2, bus.getNewbusname());
			preparedStatement.setString(3, bus.getFromAddress());
			preparedStatement.setString(4, bus.getToAddress());
			preparedStatement.setFloat(5, bus.getDepartureTime());
			preparedStatement.setFloat(6, bus.getArrivalTime());
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
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BUS WHERE bUS_NUMBER=?");
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

	/*public NewBusForm editBusDetails(Connection connection, String busNumber) {

		NewBusForm bus = new NewBusForm();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM BUS WHERE BUS_NUMBER=?");
			preparedStatement.setString(1, busNumber);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				bus.setNewbusnumber(rs.getString("bus_number"));
				bus.setNewbusname(rs.getString("bus_name"));
				bus.setFromAddress(rs.getString("source_address"));
				bus.setToAddress(rs.getString("destination_address"));
				Date startTime = rs.getTime("start_time");
				Float departureTime = (float) startTime.getTime();
				bus.setDepartureTime(departureTime);
				Date reachTime = rs.getTime("reach_time");
				Float arrivalTime = (float) reachTime.getTime();
				bus.setDepartureTime(arrivalTime);
				System.out.println("innnnnnnnnnnnnnnn");
				System.out.println(bus.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bus;

	}*/
	public BusForm editBusDetails(Connection connection, String busNumber) {

		BusForm bus = new BusForm();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM BUS WHERE BUS_NUMBER=?");
			preparedStatement.setString(1, busNumber);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				bus.setBusnumber(rs.getString("bus_number"));
				bus.setBusname(rs.getString("bus_name"));
				bus.setFromAddress(rs.getString("source_address"));
				bus.setToAddress(rs.getString("destination_address"));
				Date startTime = rs.getTime("start_time");
				Float departureTime = (float) startTime.getTime();
				bus.setDepartureTime(departureTime);
				Date reachTime = rs.getTime("reach_time");
				Float arrivalTime = (float) reachTime.getTime();
				bus.setDepartureTime(arrivalTime);
				bus.setBusnumber(rs.getString("bus_number"));
				System.out.println("innnnnnnnnnnnnnnn");
				System.out.println(bus.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bus;

	}

	public boolean editBusDetails(Connection connection, BusForm bus) {
		int value = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("UPDATE BUS SET BUS_NAME=?,SOURCE_ADDRESS=? ,DESTINATION_ADDRESS=?, START_TIME=?,REACH_TIME=? WHERE BUS_NUMBER=?");
			
			preparedStatement.setString(1, bus.getBusname());
			preparedStatement.setString(2, bus.getFromAddress());
			preparedStatement.setString(3, bus.getToAddress());
			preparedStatement.setFloat(4, bus.getDepartureTime());
			preparedStatement.setFloat(5, bus.getArrivalTime());
			preparedStatement.setString(6, bus.getBusnumber());
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

}
