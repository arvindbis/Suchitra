package com.kpit.booking.form;

import org.apache.struts.action.ActionForm;

public class PassengerForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "PassengerForm [passengerName=" + passengerName + ", gender=" + gender + ", age=" + age + ", contact="
				+ contact + "]";
	}
	private String passengerName;
	private String gender;
	private int age;
	private String contact;
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
