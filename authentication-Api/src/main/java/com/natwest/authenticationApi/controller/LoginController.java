package com.natwest.authenticationApi.controller;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.authenticationApi.model.UserProfile;
import com.natwest.authenticationApi.utility.JwtUtility;

@RestController
public class LoginController {

	@Autowired
	private JwtUtility jwtutlity;
	Map<String, String> map = new HashMap<>();

	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody UserProfile user) {
		String mytoken;
		try {
			
			mytoken = jwtutlity.generateToken(user.getUsername(),user.getPassword());
			map.clear();
			map.put("token", mytoken);
            map.put("currentuser", user.getUsername());

			
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.ACCEPTED);
			
		} catch (ServletException e) {
			
			map.clear();
			map.put("token", null);
			map.put("message", e.getMessage());
			return new ResponseEntity<Map<String,String>>(map, HttpStatus.UNAUTHORIZED);
		}
		
	}

	
		
	
}
