package com.cleartrip.properties.service;

import com.cleartrip.properties.exceptions.UserNotRegisterException;
import com.cleartrip.properties.model.Property;
import com.cleartrip.properties.model.User;

public class PropertiesRegisterService {

	private UserRegisterService userRegisterService;

	public PropertiesRegisterService(UserRegisterService userRegisterService) {
		super();
		this.userRegisterService = userRegisterService;
	}

	public String RegisterProperties(Property property) {

		if (!userRegisterService.userMap.containsKey(property.getUsername())) {
			throw new UserNotRegisterException("User Not Registered !");
		}
		User user = userRegisterService.userMap.get(property.getUsername());
		user.getListOfProperties().add(property);
		return "Property listed successfully.";
	}

}
