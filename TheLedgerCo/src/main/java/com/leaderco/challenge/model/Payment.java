package com.leaderco.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Payment {
	
	private String borrowerName;
	private String paymentId;
	private long paidAmount;
	private int emiNo;

}
