package com.natwest.authenticationApi.utility;

import com.natwest.authenticationApi.model.UserProfile;
import com.natwest.authenticationApi.service.LoginService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;


@Component
public class JwtUtility {
	
	@Value("${jwt.secretkey}")
	String secretkey;
	
	
	@Autowired
	private LoginService loginService;
	

	static final long EXPIRYTIME = 7000*60*60;
	
	public String generateToken(String username, String password) throws ServletException {
			
			if(username == null || password == null) {
				throw new ServletException("Please fill the username and password field");
			} else {
				UserProfile temp = loginService.findByUsernameAndPassword(username, password);
				
				if(temp == null) {
					throw new ServletException("Username or password incorrect, please check and try again");
				}
				String jwtToken = Jwts
									.builder()
									.setSubject(username)
									.setIssuedAt(new Date())
									.setExpiration(new Date(System.currentTimeMillis()+EXPIRYTIME))
									.signWith(SignatureAlgorithm.HS256, secretkey)
									.compact();
				
				return jwtToken;
			}
		

	}
	}
