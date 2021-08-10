package com.backtracking.program;
import java.util.Arrays;
import java.util.Scanner;

public class FindShortestSafeRouteInAPathWithLandmines {
	
	//direction
	static int row[]= {-1,1,0,0};
	static int col[]= {0,0,-1,1};
	static int minDist=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int m= sc.nextInt();
		int landminesMat[][]= new int [n][m];
		for(int i=0;i<n;i++) {
			for(int j=0; j<m; j++) {
				landminesMat[i][j]=sc.nextInt();		
			}
		}
	    solution(landminesMat,n,m);
	    System.out.println(minDist);
		sc.close();		
	}

	private static void solution(int[][] landminesMat, int n, int m) {
		modifiedMat(landminesMat,n,m);
		boolean visited[][]=new boolean[n][m];
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(landminesMat[i]));
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			if (landminesMat[i][0] == 1) {
				backTrackRecSolution(landminesMat, visited, i, 0, 0, n, m);
				if (minDist == m - 1)
					break;
			}
		}
		 
		
	}

	private static void backTrackRecSolution(int[][] landminesMat, boolean[][] visited, int i, int j, int dis,int n,int m) {
		if(j==m-1) {
			minDist=Math.min(minDist, dis);
			return;
		}
		
		visited[i][j]=true;
		for(int k=0; k<4; k++) {
			if(isValid(landminesMat,i+row[k],j+col[k],n,m) && isSafe(landminesMat,visited,i+row[k],j+col[k])) {
				backTrackRecSolution(landminesMat,visited,i+row[k],j+col[k],dis+1,n,m);
			}
		}
		visited[i][j]=false;
	}

	private static boolean isSafe(int[][] landminesMat, boolean[][] visited, int i, int j) {
	     if(landminesMat[i][j]==0 || visited[i][j]) {
	    	 return false;
	     }
		return true;
	}

	private static void modifiedMat(int[][] landminesMat, int n, int m) {
		for(int i=0;i<n;i++) {
			for(int j=0; j<m; j++) {
				if(landminesMat[i][j]==0) {
					//mark around cell..(4) are unsafe;
					for(int k=0; k<4; k++) {
						if(isValid(landminesMat,i+row[k],j+col[k],n,m)) {
							landminesMat[i+row[k]][j+col[k]]=-1;
						}
					}
				}
			}
		}
		//change -1 to 0
		for(int i=0;i<n;i++) {
			for(int j=0; j<m; j++) {
				if(landminesMat[i][j]==-1) {
					landminesMat[i][j]=0;
				}
			}
		}
	}

	private static boolean isValid(int[][] landminesMat, int i, int j, int n, int m) {
		if(i<n && j <m && i>=0 && j>=0) {
			return true;
		}
		return false;
	}

}
