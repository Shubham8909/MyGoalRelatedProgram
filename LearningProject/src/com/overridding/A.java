package com.overridding;

public interface A {
	void x();
	public static void main(String[] args) {
		A a=new B();
		a.x();
	}
}

class B implements A{
	public void x() {
		System.out.println(" Bx");
	}
	public void y() {
		System.out.println(" By");
	}
}

class C extends B{
	public void x() {
		System.out.println(" Cx");
	}
}
