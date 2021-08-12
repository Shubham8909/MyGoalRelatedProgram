package com.vermas.code.learning;

public class HighestProfit {
	
	public static void main(String[] args) {
		
		int []  arg= {800,20,3,80,100};
		
	     System.out.println(HigestProfit(arg));
	     
	     
	}

	private static int HigestProfit(int[] arg) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arg.length; i++) {
			if (arg[i] < min) {
				min = arg[i];
			}
			if (arg[i] - min > max) {
				max = arg[i] - min;
			}
		}
		return max;
	}

}
