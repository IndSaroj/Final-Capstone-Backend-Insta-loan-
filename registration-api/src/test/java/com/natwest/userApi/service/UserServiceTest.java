package com.natwest.userApi.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.natwest.userApi.dao.UserRepo;
import com.natwest.userApi.exception.UserNameAlreadyExist;
import com.natwest.userApi.model.UserProfile;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	UserRepo userRepository;
	
	 @InjectMocks
	ServiceClassImpl userService;
	
	
	
	  @Test
	  void testSaveAUser() throws UserNameAlreadyExist {
		  UserProfile usertosave = new UserProfile("nitin@gmail.com", "nitin78", "Nitin", "9909009988", "009977", "Delhi", "nitin78");
	    when(userService.addUser(usertosave)).thenReturn(usertosave);
	    UserProfile actual = userService.addUser(usertosave);
	    assertEquals(usertosave, actual);
	    assertEquals(usertosave.getUsername(), actual.getUsername());
	    assertEquals(usertosave.getAcnumber(), actual.getAcnumber());
	   
	  }
	 
}







