package com.backtracking.program;

import java.util.Arrays;
import java.util.Scanner;

public class KnightTourProblem {

	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int mat[][]= new int[n][n];
        int row=0;
        int col=0;
        mat[0][0]=1;
        int move=1;
        boolean flag=solution(mat,move,row,col,n);
        if(flag) {
        	for(int i=0; i<n;i++) {
				System.out.println(Arrays.toString(mat[i]));
			}
        }
        sc.close();
        
	}

	private static boolean solution(int[][] mat, int move, int row, int col,int n) {
		if(move==64) {
			return true;
		}
		/*
		 * int rowP[]= {-2,-2,-1,-1,1,1,2,2}; int colP[]= {1,-1,-2,2,2,-2,-1,1};
		 */
		int rowP[]= {2,1,-1,-2,-2,-1,1,2};
		int colP[]= {1,2,2,1,-1,-2,-2,-1};
		for(int i=0; i<8; i++) {
			if(isSafe(mat,row+rowP[i],col+colP[i],n)) {
				move++;
				mat[row+rowP[i]][col+colP[i]]=move;
				if(solution(mat,move,row+rowP[i],col+colP[i],n)) {
					return true;
				}
				move--;
				mat[row+rowP[i]][col+colP[i]]=0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] mat, int currR, int currC, int n) {
		if(currR<n && currC<n && currR>=0 && currC>=0 && mat[currR][currC]==0)
			return true;
		
		return false;
	}
}
