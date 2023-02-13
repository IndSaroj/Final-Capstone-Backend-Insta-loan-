package com.natwest.userApi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.natwest.userApi.model.UserProfile;
import com.natwest.userApi.service.UserService;

import jakarta.ws.rs.core.MediaType;

@WebMvcTest
class UserControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService userserv;
	
	List<UserProfile> userlist =null;

	@BeforeEach
	void setUp() throws Exception {
		
		userlist = new LinkedList<>();
		userlist.add(new UserProfile("robin@gmail.com", "robin12", "Robin", "9900009988", "889977", "Delhi", "robin12"));
		userlist.add(new UserProfile("jimmy@gmail.com", "jim12", "Jimmy", "9340009988", "4589977", "Delhi", "jim12"));
	}

	@AfterEach
	void tearDown() throws Exception {
		userlist =null;
	}

	@Test
	void testSaveUser() throws Exception {
		UserProfile user = new UserProfile("nitin@gmail.com", "nitin78", "Nitin", "9909009988", "009977", "Delhi", "nitin78");
		
		
		ObjectMapper mapper = new ObjectMapper();
		String content = mapper.writeValueAsString(user);
	    when(userserv.addUser(user)).thenReturn(user);
	    mockMvc.perform(post("/api/user/register")
	        .contentType(MediaType.APPLICATION_JSON)
	        .content(content))
	        .andExpect(status().is(201));

	}
}

