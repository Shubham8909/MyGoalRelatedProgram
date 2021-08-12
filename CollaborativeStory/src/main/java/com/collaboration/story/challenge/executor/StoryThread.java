package com.collaboration.story.challenge.executor;

import com.collaboration.story.challenge.model.Request;
import com.collaboration.story.challenge.service.CommanService;

public class StoryThread implements Runnable {

	
	private Request  request;
	private CommanService commanService;

	public StoryThread(Request request, CommanService commanService) {
		this.request = request;
		this.commanService = commanService;
	}

	static Object lock= new Object();
	
	@Override
	public void run() {
		
		synchronized (lock) {
			commanService.createAndStory(request);
		}
	}

}
