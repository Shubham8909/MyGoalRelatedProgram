package com.hackerRank.problem;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EqualStackProblem {
	
	public static void main(String[] args) {
		
		int s=equalStacks(Arrays.asList(3, 2, 1, 1, 1),Arrays.asList(4, 3, 2),Arrays.asList( 1, 1, 4,1));
		System.out.println("s "+s);
	}
	
	
	 public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
	       
	        Stack<Integer> s1=new Stack<>();
	        Stack<Integer> s2=new Stack<>();
	        Stack<Integer> s3=new Stack<>();
	          
	       int sumOfUnitFromh1=0;
	       int sumOfUnitFromh2=0;
	       int sumOfUnitFromh3=0;
	       
	     
	     for(int i=h1.size()-1;i>=0;i--){
	         int x=h1.get(i);
	         s1.push(x);
	         sumOfUnitFromh1+=x;
	     }
	      for(int i=h2.size()-1;i>=0;i--){
	         int x=h2.get(i);
	         s2.push(x);
	         sumOfUnitFromh2+=x;
	     }
	      for(int i=h3.size()-1;i>=0;i--){
	         int x=h3.get(i);
	         s3.push(x);
	         sumOfUnitFromh3+=x;
	     }
	       
	       while((sumOfUnitFromh1!= sumOfUnitFromh2) || (sumOfUnitFromh2!=sumOfUnitFromh3) || (sumOfUnitFromh3!=sumOfUnitFromh1)){	   
	    	  
	    	   if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() ) {
	    		   return 0;
	    	   }
	    	   
	    	   if(sumOfUnitFromh1>=sumOfUnitFromh2 && sumOfUnitFromh1>=sumOfUnitFromh3){
	               int peekValue=s1.peek();
	               sumOfUnitFromh1-=peekValue;
	               s1.pop();
	           }else if(sumOfUnitFromh2>=sumOfUnitFromh1 && sumOfUnitFromh2>=sumOfUnitFromh3){
	               int peekValue=s2.peek();
	               sumOfUnitFromh2-=peekValue;
	               s2.pop();
	           }else{
	               int peekValue=s3.peek();
	               sumOfUnitFromh3-=peekValue;
	               s3.pop();
	           }
	       }
	       return sumOfUnitFromh3;

	    }

}
