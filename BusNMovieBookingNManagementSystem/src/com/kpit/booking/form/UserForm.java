/**
 * 
 */
package com.kpit.booking.form;

import org.apache.struts.action.ActionForm;

/**
 * @author suchitras
 *
 */
public class UserForm extends /*ValidatorForm*/ ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String password;
	
	String email;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
