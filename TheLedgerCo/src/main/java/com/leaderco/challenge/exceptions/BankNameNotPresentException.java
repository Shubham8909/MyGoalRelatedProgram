package com.leaderco.challenge.exceptions;

public class BankNameNotPresentException extends Exception{
	private static final long serialVersionUID = 1L;
    
	public BankNameNotPresentException(String msg) {
		super(msg);
	}
	
}
