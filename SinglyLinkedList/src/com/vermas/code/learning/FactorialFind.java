package com.vermas.code.learning;

public class FactorialFind {

	public static void main(String[] args) {
		factorial(49); // 2,2,5
	}
	
	private static void factorial(int x) {
		if(x==1) {
			System.out.print(x + " ");
		}
		int num = 2;
		while (x > 1) {
			if (x % num == 0) {
				x = x / num;
				System.out.print(num + " ");
				continue;
			}
			num++;
		}
	}
}
