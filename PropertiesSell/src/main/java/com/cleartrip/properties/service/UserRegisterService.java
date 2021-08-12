package com.cleartrip.properties.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cleartrip.properties.exceptions.UserAllreadyPresentException;
import com.cleartrip.properties.model.User;

@Service
public class UserRegisterService {

	public Map<String, User> userMap= new HashMap<String, User>();

	public String userregister(String username) {
		if(userMap.containsKey(username)) {
			throw new UserAllreadyPresentException("User Already Present !");
		}
		User user= new User(username);
		userMap.put(username, user);
		return "User registered successfully.";
	}
	
	
}
