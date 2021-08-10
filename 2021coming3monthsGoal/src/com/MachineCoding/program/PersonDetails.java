package com.MachineCoding.program;

public class PersonDetails implements Comparable<PersonDetails> {

	private String name;
	private double avgRating;
	private int count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "PersonDetails [name=" + name + ", avgRating=" + avgRating + ", count=" + count + "]";
	}
	public PersonDetails(String name, double avgRating, int count) {
		super();
		this.name = name;
		this.avgRating = avgRating;
		this.count = count;
	}

	@Override
	public int compareTo(PersonDetails o) {
		if(o.getAvgRating()>this.avgRating) return 1;
		else if(o.getAvgRating()<this.avgRating) return -1;
		else return 0;
	}

}
