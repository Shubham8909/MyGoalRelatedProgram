package com.backtracking.program;

import java.util.Arrays;
import java.util.Scanner;

/*
1 0 1 0 1
1 1 1 1 1
0 1 0 1 0
1 0 0 1 1
1 1 1 0 0
*/


public class RatNMage {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int mat[][]= new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				mat[i][j]=sc.nextInt();
			}
		}
		int sol[][]= new int[n][n];
		boolean reached=ratNMaze(mat,0,0,n,sol);
		if(reached) {
			System.out.println("Reached to destination ");
			for(int i=0; i<n;i++) {
				System.out.println(Arrays.toString(sol[i]));
			}
		}else {
			System.out.println("Not Reached to destination ");
			for(int i=0; i<n;i++) {
				System.out.println(Arrays.toString(sol[i]));
			}
		}
		sc.close();
	}

	private static boolean ratNMaze(int[][] mat, int i, int j, int n, int[][] sol) {
		
		if(i==n-1 && j==n-1 && mat[i][j]==1) {
			sol[i][j]=1;
			return true;
		}	
			if(isSafe(mat,i,j,n)) {
			sol[i][j]=1;
			if(ratNMaze(mat,i+1,j,n,sol)) {
				return true;
			}
			if(ratNMaze(mat,i,j+1,n,sol)) {
				return true;
			}
			sol[i][j]=0;  //backtracking
			return false;
		}
		return false;
	}

	private static boolean isSafe(int[][] mat, int i, int j, int n) {
		if(i<n && j<n && mat[i][j]==1) {
			return true;
		}
		return false;
	}

}
