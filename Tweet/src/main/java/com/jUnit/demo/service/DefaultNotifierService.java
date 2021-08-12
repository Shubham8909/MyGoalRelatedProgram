package com.jUnit.demo.service;

import java.util.HashSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.jUnit.demo.model.Tweet;
import com.jUnit.demo.model.User;

@Component("defultNoti")
public class DefaultNotifierService implements Follower {

	@Override
	public void notifyFollwer(User user, Tweet twt) {
		HashSet<String> followerList = user.getFollowerList();
		Map<String, User> usermap = TweetService.usermap;
		for (String key : followerList) {
			if (usermap.containsKey(key)) {
				User followerUser = usermap.get(key);
				followerUser.getFollweTweetList().add(twt);
			}
		}

	}

}
