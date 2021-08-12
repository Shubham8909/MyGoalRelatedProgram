package com.leaderco.challenge.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Bank {
	private String bankName;
	private List<String> listOfBorrower;
	
	public Bank(String bankName) {
		super();
		this.bankName = bankName;
		this.listOfBorrower = new ArrayList<>();
	}

}
