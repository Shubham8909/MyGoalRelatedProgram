package com.inventory.demo.exception;

public class InvalidProductException extends RuntimeException {

	private static final long serialVersionUID = 3200416196562802807L;
	
	public InvalidProductException(String msg){
		super(msg);
	}

}
