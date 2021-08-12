package com.jUnit.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tweet {
	
	private String twtId;
	private String user;
	private String msg;
	private boolean tweetHide;
	
	public void changeTweetHideState() {
		this.tweetHide=true;
	}

	public Tweet(String twtId, String user, String msg) {
		super();
		this.twtId = twtId;
		this.user = user;
		this.msg = msg;
	}
	

}
