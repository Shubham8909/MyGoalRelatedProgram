package com.matrix.program;

public class Rotatesquarematrixby90degrees {

	public static void main(String[] args) {
		 //Test Case 1
		 
		  int a[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		  // Test Case 2
		/*
		 * int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		 */
		 
		 System.out.println("Before  :: ");
		 printArray(a);
		 int m=a.length,n=a[0].length;
		 Degree90RotateMatrix(a,n,m);
		 System.out.println("After  :: ");
		 printArray(a);

	}

	private static void Degree90RotateMatrix(int[][] a, int n, int m) {
		
		for(int x=0;x<n/2; x++) {
			
			for(int y=x;y<n-x-1; y++) {
				int temp=a[x][y];
				a[x][y]=a[y][n-x-1];
				a[y][n-x-1]=a[n-x-1][n-y-1];
				a[n-x-1][n-y-1]=a[n-y-1][x];
				a[n-y-1][x]=temp;
			}
		}
		
	}

	private static void printArray(int[][] a) {
	     for (int i = 0; i < a.length; i++)
         {
             for (int j = 0; j <a[i].length; j++)
             System.out.print( a[i][j] + " ");
             System.out.print("\n");
         }
	}


}
