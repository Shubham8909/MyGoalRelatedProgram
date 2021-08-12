package com.leaderco.challenge.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Borrower {
	
	private String borrowerName;
	private List<Payment> listOfPayment;
	private Loan loadDeatils;
	@Setter private EMI eMIDetails;
	public Borrower(String borrowerName, Loan loadDeatils, EMI eMIDetails) {
		super();
		this.borrowerName = borrowerName;
		this.loadDeatils = loadDeatils;
		this.eMIDetails = eMIDetails;
		this.listOfPayment=new ArrayList<>();
	}

	
	
	
	

}
