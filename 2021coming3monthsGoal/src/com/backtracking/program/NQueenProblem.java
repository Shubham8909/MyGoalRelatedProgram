package com.backtracking.program;

import java.util.Arrays;
import java.util.Scanner;

public class NQueenProblem {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int mat[][]= new int[n][n];
		boolean qPlaced=NqueenPlanced(mat,0,n);
		if(qPlaced) {
			System.out.println("All Placed");
			for(int i=0; i<n;i++) {
				System.out.println(Arrays.toString(mat[i]));
			}
		}
		sc.close();
	}

	private static boolean NqueenPlanced(int[][] mat, int i, int n) {
		
		if(i==n) {
			return true;
		}
		for (int col = 0; col < n; col++) {
			if (isSafe(mat, i, col, n)) {
				mat[i][col]=1;
				if(NqueenPlanced(mat,i+1,n)) {
					return true;
				}	
				mat[i][col]=0;
			}
		}
		
		return false;
	}

	private static boolean isSafe(int[][] mat, int row, int col, int n) {
		//1.Case check all row..
		for (int curr = 0; curr < row; curr++) {
			if (mat[curr][col] == 1) {
				return false;
			}
		}
	   //2.Case Left Digonal...
		int digR=row;
		int  digC=col;
		while(digR>=0 && digC>=0) {
			if (mat[digR][digC] == 1) {
				return false;
 			}
			digR--;
			digC--;
		}
		//3.Case right Digonal...
		digR=row;
		digC=col;
		while(digR>=0 && digC<n) {
			if (mat[digR][digC] == 1) {
				return false;
			}
			digR--;
			digC++;
		}
		return true;
	}

}
