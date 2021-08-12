package com.jUnit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jUnit.demo.model.Tweet;
import com.jUnit.demo.service.TweetService;

@RestController
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@PostMapping("/adduser")
	public String CREATE_USER(String user) {
		return tweetService.create_user(user);
	}
	
	@PostMapping("/addFollwer/{user}")
	public String Add_Follower(@PathVariable("user") String user, @RequestBody List<String> userList) {
		return tweetService.addFollower(user,userList);
	}
	@PostMapping("/postMsg/{user}/{msg}")
	public String POST_TWEET(@PathVariable("user") String user, @PathVariable("msg") String msg) {
		return tweetService.post_tweet(user, msg);
	}
	
	@GetMapping("/getTwt/{user}")
	public List<Tweet> GET_USER_TWEETS_BY_USER_NAME(@PathVariable("user") String user){
		return tweetService.getTweet(user);
	}
	
	
	@GetMapping("/getFeedByUser/{user}")
	public List<Tweet> GET_USER_FEED_BY_USER_NAME(@PathVariable("user") String user){
		return tweetService.getFeedByUsername(user);
	}
	
	/*
	 * @PutMapping("/hideTwt/{user}/{twtId}") public String
	 * HIDE_TWEET_FOR_USER_BY_TWEETID(@PathVariable("user") String user)
	 */
	

}
