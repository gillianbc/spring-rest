package com.gillianbc.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull(message="Must have a first name")
	@Size(min=2, message="Must be 2 or longer")
	private String firstName;
	
	@NotNull(message="Must have a last name")
	@Size(min=2, message="Must be 2 or longer")
	private String lastName;
	
	//  See https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-defineconstraints-spec
	@NotNull(message="Must have an email")
	@Email
	private String email;
	
	@NotNull(message="Must have a password")
	@Size(min=8, max=16, message="Password must be between 8 and 16 characters long")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
