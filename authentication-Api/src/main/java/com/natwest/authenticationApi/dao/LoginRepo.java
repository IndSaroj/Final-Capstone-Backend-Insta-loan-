package com.natwest.authenticationApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.authenticationApi.model.UserProfile;

@Repository
public interface LoginRepo extends JpaRepository<UserProfile, String>{

	public UserProfile findByUsernameAndPassword(String username, String password);
}
