package com.system.design.strategy;

public class MainClass {
	
	public static void main(String[] args) {
		Animal ani= new Dog("Tiger", 3, 30, 10, "Bark Bark");
		Animal katty= new Bird("Jelly", 1, 10, 15, "chirll chrill");
		ani.tryToFly();
		katty.tryToFly();
	}
	
	
	
	//
	/*
	 * Use :-
	 * When your class has dynamic behaviour.
	 * 
	 * Advatage :-
	 * 1.reduce duplicate code. 
	 * 2.Hide complicated and secret code
	 *  3.keep class changes from forcing to class changes
	 *  
	 *  Nagetive 
	 *  Number or class/object get increase
	 */

}
