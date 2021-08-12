package com.vermas.code.learning;

import java.util.Stack;

public class TowerOfHanoi {
	
	public static void main(String[] args) {
		
		Stack<Integer> s1= new Stack<Integer>();
		s1.push(3);
		s1.push(2);
		s1.push(1);
		Stack<Integer> s2= new Stack<Integer>();
		Stack<Integer> s3= new Stack<Integer>();
		System.out.println("s1 = "+s1+" s3 = "+s3+" s2 = "+s2);
		towerOfHanoi(s1.size(), s1, s3, s2);
		System.out.println("s1 = "+s1+" s3 = "+s3+" s2 = "+s2);
	}
	
	
	 ///logic :: n-1 disc move from s1 to s2 and s3 behavior like supporting stack,
	
	static void towerOfHanoi(int n, Stack<Integer>  s1, Stack<Integer>  s3, Stack<Integer>  s2) {
		if (n == 1) {
			System.out.println("Move disk 1 from rod "+   s1+" to rod "+s3);
			s3.push(s1.pop());
			return;
		}
		towerOfHanoi(n - 1, s1, s2, s3);
		System.out.println(" :: Move disk " + n + " from rod " + s1 + " to rod " + s3);
		s3.push(s1.pop());
		towerOfHanoi(n - 1, s2, s3, s1);
	}

}
