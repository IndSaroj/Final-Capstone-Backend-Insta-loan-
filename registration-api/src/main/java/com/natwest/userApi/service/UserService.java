package com.natwest.userApi.service;

import com.natwest.userApi.exception.UserNameAlreadyExist;
import com.natwest.userApi.model.UserProfile;

public interface UserService {
	
	public UserProfile addUser(UserProfile user) throws UserNameAlreadyExist;

}
