package com.jUnit.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jUnit.demo.exception.UserAlreadyPresentException;
import com.jUnit.demo.exception.UserNotPresentException;
import com.jUnit.demo.model.Tweet;
import com.jUnit.demo.model.User;

@Service
public class TweetService {

	static Map<String, User> usermap = new HashMap<>();
	
	@Autowired
	@Qualifier("defultNoti")
	private Follower follwer;

	public String create_user(String user) {
		User u = new User(user);
		if (!usermap.containsKey(user)) {
			usermap.put(user, u);
			return "Added";
		}
		throw new UserAlreadyPresentException();
	}

	public String addFollower(String user, List<String> userList) {
		if (usermap!=null && !usermap.containsKey(user)) 
			throw new UserNotPresentException();
		
		User userFromMap=usermap.get(user);
		userFromMap.getFollowerList().addAll(userList);
		return "Follower Added";
	}

	public String post_tweet(String user, String msg) {
		if (usermap!=null && !usermap.containsKey(user)) 
			throw new UserNotPresentException();
		
		User userFromMap=usermap.get(user);
		String twwtId= UUID.randomUUID().toString();
		Tweet twt= new Tweet(twwtId, user, msg);
		userFromMap.getTweetList().add(twt);
		usermap.put(user, userFromMap);
		follwer.notifyFollwer(userFromMap, twt);
		return "Post and Notify";
	}

	public List<Tweet> getTweet(String user) {
		if (usermap!=null && !usermap.containsKey(user)) 
			throw new UserNotPresentException();
		
		User userFromMap=usermap.get(user);
		return userFromMap.getTweetList();
	}

	public List<Tweet> getFeedByUsername(String user) {
		if (!usermap.containsKey(user)) 
			throw new UserNotPresentException();
		User userFromMap=usermap.get(user);
		List<Tweet> allTweet=new ArrayList<>();
		
		allTweet.addAll(userFromMap.getTweetList());
		allTweet.addAll(userFromMap.getFollweTweetList());
		return allTweet;
	}

}
