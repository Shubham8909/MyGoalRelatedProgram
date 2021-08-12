package com.cleartrip.properties.exceptions;

public class UserAllreadyPresentException extends RuntimeException {


	private static final long serialVersionUID = 664861615793261621L;
   
	
	public UserAllreadyPresentException(String msg) {
		super(msg);
	}
}
