package com.kpit.booking.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class NewBusForm extends/* ValidatorForm*/ ActionForm{
	@Override
	public String toString() {
		return "NewBusForm [newbusname=" + newbusname + ", newbusnumber=" + newbusnumber + ", fromAddress="
				+ fromAddress + ", toAddress=" + toAddress + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String newbusname;
	String newbusnumber;	
	String fromAddress;
	String toAddress;		
	float departureTime;
	float arrivalTime;
	public String getNewbusname() {
		return newbusname;
	}
	public void setNewbusname(String newbusname) {
		this.newbusname = newbusname;
	}
	public String getNewbusnumber() {
		return newbusnumber;
	}
	public void setNewbusnumber(String newbusnumber) {
		this.newbusnumber = newbusnumber;
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
	
	
}
