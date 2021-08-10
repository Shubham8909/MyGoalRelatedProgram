package com.hackerRank.problem;

import java.util.List;

public class SaprateTheNumber {
	
	public static void main(String[] args) {
		String saprateString="88888888888888888888888888888888";
		String result=findSaprateString(saprateString);
		System.out.println("REsult :"+result);
	}

	private static String findSaprateString(String saprateString) {
		int lenght=saprateString.length();
		String beautifulString="";
		for(int i=1;i<=lenght/2;i++) {
			String firstString=saprateString.substring(0, i);
			beautifulString=firstString;
			Long firstValue=Long.parseLong(firstString);
			while(saprateString.length()>firstString.length()) {
				firstString=firstString+(++firstValue);
			}
			if(firstString.equalsIgnoreCase(saprateString)) {
				return "YES "+beautifulString;
			}
		}
		return "NO";
	}
	
	public static void minimumBribes(List<Integer> q) {
	    // Write your code here
	    //[2, 5, 1, 3, 4]
	     int sum=0;
	    for(int i=0;i<q.size(); i++){
	        int chaos=0;
	        while(q.get(i)!=i+1){
	            int x= q.get(i);
	            q.set(i, q.get(x-1));
	            q.set(x-1, x);
	            chaos++;
	        }
	        if(chaos>2){
	            System.out.println("Too chaotic");
	            return;
	        }
	        sum+=chaos;
	    }
	     System.out.println(sum);
	    }

}
