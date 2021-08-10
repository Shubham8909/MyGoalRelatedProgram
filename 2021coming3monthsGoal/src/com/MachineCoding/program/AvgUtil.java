package com.MachineCoding.program;

import java.util.Map;

public class AvgUtil {
	private int count;
	private double avg;
	private String name;
	private Map<String, Double> minMap;
	
	
	public Map<String, Double> getMinMap() {
		return minMap;
	}
	public void setMinMap(Map<String, Double> minMap) {
		this.minMap = minMap;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AvgUtil(int count, double avg, String name, Map<String, Double> minMap) {
		super();
		this.count = count;
		this.avg = avg;
		this.name = name;
		this.minMap = minMap;
	}
	@Override
	public String toString() {
		return "AvgUtil [count=" + count + ", avg=" + avg + ", name=" + name + ", minMap=" + minMap + "]";
	}
	
}
