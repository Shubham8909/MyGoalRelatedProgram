package com.inventory.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomException {

	@ExceptionHandler(value = InvalidProductException.class)
	public ResponseEntity<Object> handleGenaralExcepion( Exception ex, WebRequest request) {
		 String res="";
		 if(ex instanceof InvalidProductException) {
			 res=((InvalidProductException) ex).getMessage();
		 }
		return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
	}
}