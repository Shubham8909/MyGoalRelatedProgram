package com.backtracking.program;

import java.util.Arrays;
import java.util.Scanner;

/*
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
 */

public class SudokuProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mat[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		boolean flag=solveSudoku(mat, 0, 0, n);
		if(flag) {
		for (int y = 0; y < n; y++) 
			System.out.println(Arrays.toString(mat[y]));
		}else {
			
		}
		sc.close();

	}

	private static boolean solveSudoku(int[][] mat, int i, int j, int n) {
		if (i == n) {
			return true;
		}
		int ni = 0;
		int nj = 0;

		if (j == n - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = j + 1;
		}

		if (mat[i][j] != 0) {
			if(solveSudoku(mat, ni, nj, n)) {
				return true;
			}
		} else {
			for (int k = 1; k <= 9; k++) {
				if (isSafe(mat, i, j, n, k)) {
					mat[i][j] = k;
					if(solveSudoku(mat, ni, nj, n)) {
						return true;
					}
					mat[i][j] = 0;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] mat, int ni, int nj, int n, int k) {
		// row wise
		for (int i = 0; i < n; i++) {
			if (mat[ni][i] == k) {
				return false;
			}
		}
		// col wise
		for (int i = 0; i < n; i++) {
			if (mat[i][nj] == k) {
				return false;
			}
		}
		// sub matrix.
		int subi = ni / 3 * 3;
		int subj = nj / 3 * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (mat[subi + i][subj + j] == k) {
					return false;
				}
			}
		}
		return true;
	}

}
