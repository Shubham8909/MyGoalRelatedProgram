package com.goalOf3Month;

public class SpiralMatrix {

	public static void main(String[] args) {
		int matrix[][] = {{1, 2, 3, 4},
		                  {5, 6, 7, 8},
		                  {9, 10, 11, 12},
		                  {13, 14, 15,16}};
		
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0;j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
 