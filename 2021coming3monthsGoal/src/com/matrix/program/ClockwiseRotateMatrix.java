package com.matrix.program;

public class ClockwiseRotateMatrix {

	public static void main(String[] args) {
		 //Test Case 1
		/* 
		 * int a[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		 */
		 

		    // Test Case 2
		     int a[][] = {{1, 2, 3},
		                  {4, 5, 6},
		                  {7, 8, 9}};
		 
		 System.out.println("Before  :: ");
		 printArray(a);
		 int m=a.length,n=a[0].length;
		 RotateMatrix(a,n,m);
		 System.out.println("After  :: ");
		 printArray(a);

	}

	private static void printArray(int[][] a) {
	     for (int i = 0; i < a.length; i++)
         {
             for (int j = 0; j <a[i].length; j++)
             System.out.print( a[i][j] + " ");
             System.out.print("\n");
         }
	}

	private static void RotateMatrix(int[][] a, int n, int m) {
		int row=0, col=0;
		int prev=0,curr=0;
		
		while(row<m && col<n) {
			
			if(row+1==m && col+1==n) break;
			
			// prev records of next row
			prev=a[row+1][col];	
			
			//replace with prev value in row
			for(int i=col; i<n; i++) {
				curr=a[row][i];
				a[row][i]=prev;
				prev=curr;
			}
			row++;
			
			// replace last column value
			for(int i=row; i<m; i++) {
				curr=a[i][n-1];
				a[i][n-1]=prev;
				prev=curr;
			}
			n--;
			
			if(row<m) {
				for(int i=n-1; i>=col; i--) {
					curr=a[m-1][i];
					a[m-1][i]=prev;
					prev=curr;
				}
				m--;
			}
			
			if(col<n) {
				for(int i=m-1; i>=row; i--) {
					curr=a[i][col];
					a[i][col]=prev;
					prev=curr;
				}
				col++;
			}
			
		}
		
		
	}

}
