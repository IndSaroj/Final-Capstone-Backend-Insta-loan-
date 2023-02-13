package com.natwest.userApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.natwest.userApi.exception.UserNameAlreadyExist;
import com.natwest.userApi.model.UserProfile;
import com.natwest.userApi.service.UserService;
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody UserProfile user) throws UserNameAlreadyExist{
		 UserProfile user1;
		 try {
			 user1 = userservice.addUser(user);
			 return new ResponseEntity<UserProfile>(user1, HttpStatus.CREATED);
		 }catch(UserNameAlreadyExist e) {
			 return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		 }
	 }


}
