package com.vermas.code.learning;

public class FindPrime {
	
	public static void main(String[] args) {
		
		
		checkPrime(72);
	
	}
	private static void checkPrime(int a) {
		
		if(a==1 ||a==2 || a==3) {
			System.out.println("Its a prime number");
		}
		
		for(int i=2 ;i<(a/2); i++) {
			if(a%i==0) {
				System.out.println("Its not a prime number");
				return;
			}
		}
		System.out.println("Its  a prime number");
	}

}
