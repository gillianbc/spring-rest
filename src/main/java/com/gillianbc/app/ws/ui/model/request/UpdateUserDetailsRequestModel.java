package com.gillianbc.app.ws.ui.model.request;

import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
	@Size(min=2, message="Must be 2 or longer")
	private String firstName;
	@Size(min=2, message="Must be 2 or longer")
	private String lastName;
	
	
	
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
}
