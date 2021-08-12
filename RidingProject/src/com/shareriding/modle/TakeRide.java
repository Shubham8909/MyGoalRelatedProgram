package com.shareriding.modle;


public class TakeRide {
	
	private String userName;
	private String origin;
	private String destination;
	private int availSeat;
	private String strategy;
	
	public String getUserName() {
		return userName;
	}
	public String getOrigin() {
		return origin;
	}
	public String getDestination() {
		return destination;
	}
	public int getAvailSeat() {
		return availSeat;
	}
	public String getStrategy() {
		return strategy;
	}
	
	public TakeRide(String userName, String origin, String destination, int availSeat, String strategy) {
		super();
		this.userName = userName;
		this.origin = origin;
		this.destination = destination;
		this.availSeat = availSeat;
		this.strategy = strategy;
	}
  
	
	
	
}
