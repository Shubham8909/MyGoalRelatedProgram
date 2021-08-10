package com.array.program;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shubhamverma
 * 
 *         Maximum profit by buying and selling a share at most twice
 *
 */
public class MaxShareProfit {

	public static void main(String[] args) {
		int price[] = { 10, 22, 5, 75, 65, 80 };
		int profit = findMaxProfit(price);
		int profit2 = findMaxProfit2(price);
		System.out.println("Profit "+profit);
		System.out.println("Profit2---"+profit2);
		
		TreeMap<Integer, Integer> map= new TreeMap<>();
         for(int i: price){
             map.put(i,map.getOrDefault(i,0)+1);
         }
	}
			
	

	private static int findMaxProfit2(int[] price) {
	    int n=price.length;
		int max=price[n-1];
		int min=price[0];
		int dp[]=new int[n];
		for(int i=n-2;i>=0;i--) {
			if(price[i]>max) max=price[i];
			dp[i]=Math.max(dp[i+1],max-price[i]);
		}
		System.out.println("Array -"+Arrays.toString(dp));
		
		for(int i=1;i<n;i++) {
			if(price[i]<min) min=price[i];
			dp[i]=Math.max(dp[i-1],dp[i]+price[i]-min);
		}
		
		System.out.println("Array -"+Arrays.toString(dp));
		
		return dp[n-1];
	}



	private static int findMaxProfit(int[] price) {
		int buy1, profit1, buy2, profit2;
		 
	    // Set initial buying values to
	    // Integer.MAX_VALUE as we want to
	    // minimize it
	    buy1 = buy2 = Integer.MAX_VALUE;
	 
	    // Set initial selling values to
	    // zero as we want to maximize it
	    profit1 = profit2 = 0;
	 
	    for(int i = 0; i < price.length; i++)
	    {
	 
	        // Money lent to buy the stock
	        // should be minimum as possible.
	        // buy1 tracks the minimum possible
	        // stock to buy from 0 to i-1.
	        buy1 = Math.min(buy1, price[i]);
	 
	        // Profit after selling a stock
	        // should be maximum as possible.
	        // profit1 tracks maximum possible
	        // profit we can make from 0 to i-1.
	        profit1 = Math.max(profit1, price[i] - buy1);
	 
	        // Now for buying the 2nd stock,
	        // we will integrate profit made
	        // from selling the 1st stock
	        buy2 = Math.min(buy2, price[i] - profit1);
	 
	        // Profit after selling a 2 stocks
	        // should be maximum as possible.
	        // profit2 tracks maximum possible
	        // profit we can make from 0 to i-1.
	        profit2 = Math.max(profit2, price[i] - buy2);
	        
	        
	        System.out.println("i : "+i+" "+buy1+" "+profit1+" "+buy2+"  "+profit2);
	    }
	    return profit2;
	}

}
