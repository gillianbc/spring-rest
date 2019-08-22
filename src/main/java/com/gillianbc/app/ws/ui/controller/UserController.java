package com.gillianbc.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gillianbc.app.ws.ui.model.request.UserDetailsRequestModel;
import com.gillianbc.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class UserController {
	
	// in-memory data store
	Map<String, UserRest> users;
	
	@GetMapping(path="{userId}", 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if (users != null && users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		} else 
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
	}
	
	// You can use: required = false   
	// rather than a defaultValue, but don't use it with primitives
	@GetMapping
	public String getUsers(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="50") int limit) {
		
		return "Get users method was called with page: " + page + " limit: " + limit ;
	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequest) {
		UserRest userRest =  new UserRest();
		userRest.setFirstName(userDetailsRequest.getFirstName());
		userRest.setLastName(userDetailsRequest.getLastName());
		userRest.setEmail(userDetailsRequest.getEmail());
		userRest.setPassword(userDetailsRequest.getPassword());
		String userId = UUID.randomUUID().toString();
		userRest.setUserId(userId);
		if (users == null) 
			users = new HashMap<>();
		users.put(userId, userRest);
		return new ResponseEntity<UserRest>(userRest, HttpStatus.CREATED);
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
