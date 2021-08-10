package com.dp.problems;



/**
 * @author shubhamverma
 * 
 * n
 *   p
 *     r
 *
 */
public class PermutationCoefficientProblem {

	public static void main(String[] args) {
      
		System.out.println("Permutation : "+nPr(5,2));
		System.out.println("Permutation2 : "+nPr2(5,2));
	}
	
	// O(n) time complexity and O(n)=1 Space 
	private static int nPr(int n, int r) {
		int p=1;
		for(int i=0; i<r;i++) {
			p*=(n-i);	
		}
		return p;
	}
	
	
	// O(n) time complexity and O(n)=n Space 
	private static int nPr2(int n, int r) {
		int fCT[]= new int[n+1];
		fCT[0]=1;
		for(int i=1; i<=n;i++) {
			fCT[i]=	i*fCT[i-1];
		}
		return (fCT[n]/fCT[n-r]);
	}
	

}
