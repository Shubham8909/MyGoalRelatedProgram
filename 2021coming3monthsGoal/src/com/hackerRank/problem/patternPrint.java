package com.hackerRank.problem;

public class patternPrint {
	
	public static void main(String[] args) {
		int n=8;
		printPattern(n);
	}

	private static void printPattern(int n) {
		
		for(int i=n-1; i>=0;i--) {
			for(int j=0;j<n;j++) {
				if(j>=i) {
					System.out.print("#");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		String str="#";
		for(int j=1;j<=n;j++) {
			System.out.printf("%"+n+"s\n", str);
			str+="#";
		}
		
		
	}

}
