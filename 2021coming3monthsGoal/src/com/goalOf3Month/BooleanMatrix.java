package com.goalOf3Month;

public class BooleanMatrix {
	
	public static void main(String[] args) {
	    int mat[][] =  {{1, 0, 0, 1}, 
                        {0, 0, 1, 0}, 
                        {0, 0, 0, 0}}; 
            
      System.out.println("Matrix Intially"); 
      printMatrix(mat, 3, 4); 
      //Modified matrixs ...
      ModifiedMatrix(mat, 3, 4);
      System.out.println("Matrix After modified");
      printMatrix(mat, 3, 4);
	}
	
	private static void ModifiedMatrix(int[][] mat, int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (mat[i][j] == 1) {
				}
			}
		}
	}

	private static void printMatrix(int[][] mat, int x, int y) {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
