package com.MachineCoding.program;

public class CustInfo {
	
	private String name;
	private double rating;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
	public CustInfo(String name, double rating) {
		super();
		this.name = name;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "CustInfo [name=" + name + ", rating=" + rating + "]";
	}
	
}
