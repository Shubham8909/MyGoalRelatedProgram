package com.jUnit.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User{
	
	private String user;
	private HashSet<String> followerList;
	private List<Tweet> tweetList;
	private List<Tweet> follweTweetList;
	
	public User(String user) {
		super();
		this.user = user;
		this.followerList=new HashSet<>();
		this.tweetList=new ArrayList<>();
		this.follweTweetList=new ArrayList<>();
	}
	
}
