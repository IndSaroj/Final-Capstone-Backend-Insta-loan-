package com.natwest.userApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.userApi.model.UserProfile;

@Repository
public interface UserRepo extends JpaRepository<UserProfile, String>{

}
