package com.dp.problems;

import java.util.Scanner;

public class ArrangingBuldingDp {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		sc.close();
		
		int ocOfSpace=1;
		int ocOfBulding=1;
		
		for(int i=2; i<=n; i++) {
			int ncofSpace=ocOfBulding;
			int ncOfBulding=ocOfSpace+ocOfBulding;
			ocOfSpace=ncofSpace;
			ocOfBulding=ncOfBulding;	
		}
		
		int ans=ocOfSpace+ocOfBulding;
		System.out.println(ans*ans);

	}

}
