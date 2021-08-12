package com.vermas.code.stack;

public class MainStack {
	
	public static void main(String[] args) {
		
		StackUsed s= new StackUsed();
		System.out.println("--POP method without PUSH");
		System.out.println(s.pop());
		System.out.println();
		
		s.push(3);
		s.push(6);
		s.push(9);
		s.push(10);
		
		System.out.println("--POP method After PUSH");
		System.out.println(s.pop());
		System.out.println();
		
		System.out.println(s.pop());
		
	}


}
