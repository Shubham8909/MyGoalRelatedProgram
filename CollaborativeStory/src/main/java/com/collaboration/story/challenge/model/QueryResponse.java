package com.collaboration.story.challenge.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class QueryResponse {
	 private int limit;
	 private int  offset;
	 private int  count;
	 private List<Title> results;

}
