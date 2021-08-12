package com.testing.acceseModifier;

public class Test1 {
	
	String name="Shubham";
    
	public void m1() {
		System.out.println(" Test1 :: m1 ");
	}
	
	public void m3() {
		System.out.println(" Test1 :: m3 ");
	}
	
	protected static int m1(int y) {
		System.out.println(" Test1 ");
		return 9;
	}
	
}

class Test2 extends Test1{
    int id=10;
	public void m3(String s) {
		System.out.println(" Test2 :: m3 ");
	}
	/*
	 * protected static int m1(int y1) { System.out.println(" Test2 "); return 9; }
	 */

	

}
class Main1{
	
public static void main(String[] args) {

}
}