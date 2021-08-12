package com.cleartrip.properties.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	private String user;
	private List<Property> listOfProperties;
	public User(String user) {
		this.user = user;
		this.listOfProperties= new ArrayList<Property>();
	}
	
}
