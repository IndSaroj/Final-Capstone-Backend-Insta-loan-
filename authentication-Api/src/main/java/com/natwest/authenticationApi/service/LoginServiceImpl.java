package com.natwest.authenticationApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.authenticationApi.dao.LoginRepo;
import com.natwest.authenticationApi.model.UserProfile;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepo loginrepo;
	

	public LoginServiceImpl() {
		
	}


	@Override
	public UserProfile findByUsernameAndPassword(String username, String password) {
		
		return loginrepo.findByUsernameAndPassword(username, password);
	}

}
