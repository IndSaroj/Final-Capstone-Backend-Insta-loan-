package com.natwest.authenticationApi.service;

import com.natwest.authenticationApi.model.UserProfile;

public interface LoginService {
	
	public UserProfile findByUsernameAndPassword(String username, String password);

}
