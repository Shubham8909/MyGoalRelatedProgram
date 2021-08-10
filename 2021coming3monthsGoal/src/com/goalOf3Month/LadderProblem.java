package com.goalOf3Month;

import java.util.HashMap;
import java.util.Map;

public class LadderProblem {
	static int k=3;
	public static void main(String[] args) {
		int n=4;
		Map<Integer,Integer> map=new HashMap<>();
		int step =totalWaysVaiDPTopDown(n,map,k);
		System.out.println("Via top Down apporch "+step);
		System.out.println("Via Bottom up apporch "+WayBP(4,3));
	}

	private static int totalWaysVaiDPTopDown(int n, Map<Integer,Integer> map,int k) {
		if(n==0) {
			map.put(n, 1);
			return 1;
		}
		if(n<0) {
			return 0;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}else {
			int sum=0;
			for(int j=1; j<=k;j++) {
				sum+=totalWaysVaiDPTopDown(n-j,map,k);
			}
			map.put(n, sum);
		}
		return  map.get(n);
	}
	
	
	private static int WayBP(int n,int k) {
	   int[] dp =new int[n+1];
	   dp[0]=1;
	   for(int step=1; step<=n;step++) {
		   dp[step]=0;
		   if(step<=k) {
		   for(int j=1;j<=k;j++) {
			   if(step-j>=0)
			   dp[step]+=dp[step-j];
		   }
		   }else
		      dp[step]=2*dp[step-1]-dp[step-1-k];
	   }
	   return dp[n];
	
	}

}
