package com.leaderco.challenge.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Command {
	
	private String commadName;
	private List<String> params;
	

}
