package com.kpit.booking.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class BusForm extends /*ValidatorForm*/ ActionForm{
	@Override
	public String toString() {
		return "BusForm [busNumber=" + busNumber + ", busName=" + busName + ", numberOfSeats=" + numberOfSeats
				+ ", busType=" + busType + "]";
	}
	/**
	 * 
	 */
	private List<BusForm> list;
	private List<BusForm> foundbusdetails;
	
	public List<BusForm> getFoundbusdetails() {
		return foundbusdetails;
	}
	public void setFoundbusdetails(List<BusForm> foundbusdetails) {
		this.foundbusdetails = foundbusdetails;
	}
	public List<BusForm> getList() {
		return list;
	}
	public void setList(List<BusForm> list) {
		this.list = list;
	}
	private static final long serialVersionUID = 1L;
	private String busNumber;
	private String busName;
	private int numberOfSeats;
	private String busType;
	private String fromAddress;
	private String toAddress;
	private String[] seatNumbers;
	private String femaleSeats;
    
	
	public String getFemaleSeatNumbers() {
		return femaleSeats;
	}
	public void setFemaleSeatNumbers(String femaleSeatNumbers) {
		this.femaleSeats = femaleSeatNumbers;
	}
	public String[] getSeatNumbers() {
		return seatNumbers;
	}
	public void setSeatNumbers(String[] seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	
}
