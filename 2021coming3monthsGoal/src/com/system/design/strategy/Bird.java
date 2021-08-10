package com.system.design.strategy;

public class Bird extends Animal {

	public Bird(String name, double height, double weight, long speed, String sound) {
		super(name, height, weight, speed, sound);
		flytype=new CanFly();
	}
	public void jump() {
		System.out.println(" High jump !");
	}

}
