package com.collaboration.story.challenge.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ResponseStatus {
	
	private HttpStatus respHttpStatus=HttpStatus.CREATED;
	
	public void changeHttpStatus(HttpStatus httpStatus) {
		this.respHttpStatus=httpStatus;
	}

}

