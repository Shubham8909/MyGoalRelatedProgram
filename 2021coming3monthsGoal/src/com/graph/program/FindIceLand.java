package com.graph.program;

public class FindIceLand {
	
	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                  { 0, 1, 0, 0, 1 },
                                  { 1, 0, 0, 1, 1 },
                                  { 0, 0, 0, 0, 0 },
                                  { 1, 0, 1, 0, 1 } };
            System.out.println(findIceLand(M));   
	}
	
	public static int  findIceLand(int [][] m) {
		Integer count=new Integer(0);
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				if(m[i][j]==1) {
					dfs(m,i,j);
					count++;
				}
			}
		}
		return count;
	}

	private static void dfs(int[][] m, int i, int j) {
		int row[]= {-1,-1,1,1,0,0,-1,1};
		int col[]= {-1,0,1,0,1,-1,1,-1};
		m[i][j]='#';
		for(int k=0;k<8;k++) {
			if(isSafe(m,i+row[k],j+col[k])) {
				dfs(m,i+row[k],j+col[k]);
			}
		}
	}

	private static boolean isSafe(int[][] m, int i, int j) {
		return (i<m.length && i>=0 && j>=0 && j<m[0].length && m[i][j]==1);
	}

}
