package com.dp.problems;
public class AdjacentBit {

	public static void main(String[] args) {
		
		int n=5,k=2,x=0;
		int  [][][] dp= new int [n+1][k+1][2];
		
		  for (int i = 0; i < dp.length; i++) {
	            for(int j = 0; j < dp[i].length; j++) {
	            	for(int z = 0; z < dp[i][j].length; z++) {
	                dp[i][j][z]=-1;
	            }
	        }
		  }     
	        x=AdjBitCount(n,k,1,dp);
	        x+=AdjBitCount(n,k,0,dp);
	          
	    System.out.println("Adjacent Bit count "+ x);
	}

	
	private static int AdjBitCount(int n, int k, int i, int[][][] dp) {
	    
		if(n==0 || k<0) return 0;
	
		if(n==1) {
			if(k==0) return 1;
			else if(k<0) return 0;
			else return 0;
		}
		if(dp[n][k][i]!=-1) {
			return dp[n][k][i];
		}
		int returnValue=-1;
		if(i==1) {
			returnValue=AdjBitCount(n-1,k-1,1,dp)+AdjBitCount(n-1,k,0,dp);
		}else {
			returnValue=AdjBitCount(n-1,k,0,dp) +AdjBitCount(n-1,k,1,dp);

		}
		
		return dp[n][k][i]=returnValue;
	}
	
}
