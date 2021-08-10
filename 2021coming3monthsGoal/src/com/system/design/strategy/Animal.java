package com.system.design.strategy;

public class Animal {
	
	 private String name;
	 private double height;
	 private double weight;
	 private long speed;
	 private String  sound;
	 //Composite 
	 protected Fly flytype;
	 
	public Fly getFlytype() {
		return flytype;
	}
	public void setFlytype(Fly flytype) {
		this.flytype = flytype;
	}
	public Animal(String name, double height, double weight, long speed, String sound) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.speed = speed;
		this.sound = sound;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		if(weight<0) {
			System.out.println(" Weight can not be null ");
			return;
		}
		this.weight = weight;
	}
	public long getSpeed() {
		return speed;
	}
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	public void tryToFly(){
		flytype.fly();
	}

}
