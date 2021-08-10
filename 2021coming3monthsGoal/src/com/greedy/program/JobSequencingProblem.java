package com.greedy.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class JobSequencingProblem {
	
	
	public static void main(String[] args) {
		
	
	Scanner sc= new Scanner(System.in);
	int n=sc.nextInt();
	int deadLine[]= new int[n];
	int profit[]= new int[n];
	
	for(int i=0; i<n;i++) {
		deadLine[i]=sc.nextInt();
	}
	for(int i=0; i<n;i++) {
		profit[i]=sc.nextInt();
	}
	
	int maxProfit= getMaxProfit(deadLine,profit,n);
	
	System.out.println( "Ans--> "+maxProfit);
	
	
	}

	private static int getMaxProfit(int[] deadLine, int[] profit, int n) {
		List<Job> jList= new ArrayList<>();
		int maxDL=0;
		for(int i=0; i<n;i++) {
          Job j= new Job(deadLine[i], profit[i]);
			jList.add(j);
			maxDL= Math.max(maxDL, deadLine[i]);
		}
		Collections.sort(jList,(a,b)->b.p.compareTo(a.p));
		System.out.println(jList +" Max "+maxDL);
		
		boolean result[]= new boolean[n];
		
		int maxProfit=0;
		for(int i=0; i< n; i++) {
			Job j= jList.get(i);
			for(int k=Math.min(maxDL-1,j.d-1); k>=0;k--) {
				if(result[k]==false) {
				   result[k]=true;
				   maxProfit+=j.p;
				   break;
				}
			}
			
		}
		return maxProfit;
	}

}
class Job{
	Integer d;
	Integer p;
	public Job(int deadLine, int profit ) {
		this.d=deadLine;
		this.p=profit;
	}
	@Override
	public String toString() {
		return "Job [d=" + d + ", p=" + p + "]";
	}
	
	
}
