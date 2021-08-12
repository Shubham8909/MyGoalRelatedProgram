package com.leaderco.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Loan {
	
	private String loadId;
	private String borrowerName;
	private long loanAmount;
	private int loanYear;
	private int loanRateIntrest;
	

}
