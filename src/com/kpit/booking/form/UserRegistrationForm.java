/**
 * 
 */
package com.kpit.booking.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

/**
 * @author suchitras
 *
 */
public class UserRegistrationForm extends /*ValidatorForm */ ActionForm{

	private static final long serialVersionUID = 1L;

	public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}

	String pwd;
	String repwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	String emailAddress;
}
