package com.vermas.code.learning;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GFG { 
  
    // Function to print all the permutations of str 
    static void printPermutn(String str, String ans) 
    { 
  
        // If string is empty 
        if (str.length() == 0) { 
            System.out.print(ans + " "); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
        	System.out.println("---------"+i+"------str-----"+str+"--------ans----"+ans);
            // ith character of str 
            char ch = str.charAt(i); //a ,//b ,//b
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); //b, //b ,//""
  
            // Recurvise call 
            printPermutn(ros, ans + ch); 
        } 
    } 
    
    
  
    
    public static void main (String[] args) {
    	
    	
    	
    	TreeSet<Integer> s= new TreeSet<Integer>();
    	
    	s.add(0);
    	s.add(-1);
    	s.add(3);
    	s.add(2);
    	s.add(-5);
    	
    	System.out.println(s);
    	
 		int arr[]= {1,2,3,4};
		
	     int first=0;
	     int last=arr.length-1;
	     
	     while(first<last){
	         int x=arr[first];
	         arr[first]=arr[last];
	         arr[last]=x;
	         first++;
	         last --; 
	     }
		
		for(int a: arr){
		    System.out.print(a+" ");
		}
	}
    // Driver code 
	/*
	 * public static void main(String[] args) { String s = "abb"; printPermutn(s,
	 * "");
	 * 
	 * }
	 */
} 