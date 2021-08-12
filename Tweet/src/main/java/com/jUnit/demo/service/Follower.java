package com.jUnit.demo.service;

import com.jUnit.demo.model.Tweet;
import com.jUnit.demo.model.User;

public interface Follower {
	 void notifyFollwer(User user, Tweet twt);
}
