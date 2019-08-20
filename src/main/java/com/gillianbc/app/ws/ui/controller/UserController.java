package com.gillianbc.app.ws.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gillianbc.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class UserController {
	
	@GetMapping(path="{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserRest getUser(@PathVariable String userId) {
		UserRest userRest =  new UserRest();
		userRest.setFirstName("Hugh");
		userRest.setLastName("Jass");
		userRest.setEmail("hugh@gmail.com");
		return userRest;
	}
	
	// You can use: required = false   
	// rather than a defaultValue, but don't use it with primitives
	@GetMapping
	public String getUsers(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="50") int limit) {
		
		return "Get users method was called with page: " + page + " limit: " + limit ;
	}
	
	@PostMapping
	public String createUser() {
		return "Create user method was called";
	}
	
	@PutMapping
	public String updateUser() {
		return "Update user method was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete user method was called";
	}
}
