package com.natwest.userApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.natwest.userApi.dao.UserRepo;
import com.natwest.userApi.exception.UserNameAlreadyExist;
import com.natwest.userApi.model.UserProfile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class ServiceClassImpl implements UserService {
	
	
	@Autowired
	private UserRepo userrepo;
	
//	PasswordEncoder passwordEncoder;
	
//	public ServiceClassImpl(UserRepo userrepo) {
//		this.userrepo = userrepo;
//		 this.passwordEncoder = new BCryptPasswordEncoder();
//		
//	}

	@Override
	public UserProfile addUser(UserProfile user) throws UserNameAlreadyExist {
//		String encodedPassword = this.passwordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
		
//		String encodedPassword2 = this.passwordEncoder.encode(user.getConfirmpassword());
//		user.setConfirmpassword(encodedPassword2);
		
		Optional<UserProfile> user1 = userrepo.findById(user.getUsername());
		if(user1.isPresent()) {
			throw new UserNameAlreadyExist("Username already exist, please try with different username");
		}else {
			UserProfile temp = userrepo.save(user);
		
		return temp;
	}


	}	
	
}
