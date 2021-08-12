package com.shareriding.exception;

public class UserNotFoundException extends Exception {
     
	private static final long serialVersionUID = -8199534559597874363L;
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
