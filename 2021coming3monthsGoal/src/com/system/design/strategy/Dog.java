package com.system.design.strategy;

public class Dog extends Animal {
	
	public Dog(String name, double height, double weight, long speed, String sound) {
		super(name, height, weight, speed, sound);
		flytype=new CantFly();
	}
	
	//Some dog feature..
	public void digHole() {
		System.out.println("dig hole...");
	}
        
}
