package com.shareriding.exception;

public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 2313150926905885123L;

	public InvalidUserException(String msg) {
		super(msg);
	}
}
