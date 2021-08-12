package com.collaboration.story.challenge.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.story.challenge.model.Order;
import com.collaboration.story.challenge.model.QueryResponse;
import com.collaboration.story.challenge.model.Request;
import com.collaboration.story.challenge.model.Response;
import com.collaboration.story.challenge.model.ResponseStatus;
import com.collaboration.story.challenge.model.Sort;
import com.collaboration.story.challenge.model.Title;
import com.collaboration.story.challenge.service.StoryService;

@RestController
public class StoryController {

	@Autowired
	private StoryService storyService;

	private final Logger logger = LoggerFactory.getLogger(StoryController.class);

	@PostMapping("/add")
	public ResponseEntity<Response> createStory(@Valid @RequestBody Request request) {
		long startTime = System.currentTimeMillis();
		ResponseStatus respStataus = new ResponseStatus();
		Response resp = storyService.createAndStory(request, respStataus);
		long endTime = System.currentTimeMillis();
		logger.info("Request ended :: <====> :: " + request.getWord() + " Time taken " + (endTime - startTime));
		return new ResponseEntity<>(resp, respStataus.getRespHttpStatus());
	}

	@GetMapping("/stories/{id}")
	public ResponseEntity<Title> getStories(@PathVariable("id") int id) {
		Title title = storyService.getStoryByid(id);
		return new ResponseEntity<>(title, HttpStatus.OK);
	}

	@GetMapping("/stories")
	public ResponseEntity<QueryResponse> getLimitStories(@RequestParam Optional<Integer> offset,Optional<Integer> limit,
			@RequestParam Optional<Order> order,
			@RequestParam Optional<Sort> sortby) {
		QueryResponse queryResponse = storyService.getQueryResposeOfStory(offset,limit,order,sortby);
		return new ResponseEntity<>(queryResponse, HttpStatus.OK);
	}

}
