package com.collaboration.story.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Response {
	private int id;
	private String title;
	private String current_sentence;
}
