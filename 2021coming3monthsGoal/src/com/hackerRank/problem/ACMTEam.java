package com.hackerRank.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

public class ACMTEam {

	public static void main(String[] args) {
		String[] acm = { "10101", "11100", "11010", "00101" };
		List<String> topic = Arrays.asList(acm);

		List<Integer> result = acmTeam(topic);
		System.out.println("Result :"+result);
	}

	public static List<Integer> acmTeam(List<String> topic) {
		
       int maxNumberOftopic=0;
       int totalTeam=0;
       List<Integer> result=new ArrayList<>();
	
		for (int i=0; i<topic.size()-1;i++) {
		     String start=topic.get(i);
		     for(int j=i+1;j<topic.size();j++) {
		    	 String next=topic.get(j);
		    	 int numberTopicCount=0;
		    	 for(int k=0;k<start.length();k++) {
		    		 if(start.charAt(k)=='1' && next.charAt(k)=='1' ) {
		    			 numberTopicCount++;
		    		 }else if((start.charAt(k)=='1' && next.charAt(k)=='0') || (start.charAt(k)=='0' && next.charAt(k)=='1')){
		    			 numberTopicCount++;
		    		 }
		    	 }
		    	if(numberTopicCount>maxNumberOftopic) {
		    		maxNumberOftopic=numberTopicCount;
		    		totalTeam=1;
		    	}else if(numberTopicCount==maxNumberOftopic) {
		    		totalTeam++;
		    	}
		    	 
		     }
		}
		result.add(maxNumberOftopic);
		result.add(totalTeam);
       return result;
	}

}
