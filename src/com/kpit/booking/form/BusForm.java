package com.kpit.booking.form;

import org.apache.struts.action.ActionForm;

public class BusForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String busnumber;
	String busname;
	@Override
	public String toString() {
		return "BusForm [busnumber=" + busnumber + ", busname=" + busname + ", fromAddress=" + fromAddress
				+ ", toAddress=" + toAddress + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ "]";
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
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
	public float getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(float departureTime) {
		this.departureTime = departureTime;
	}
	public float getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(float arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	String fromAddress;
	String toAddress;		
	float departureTime;
	float arrivalTime;
	public String getBusnumber() {
		return busnumber;
	}
	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}

}
