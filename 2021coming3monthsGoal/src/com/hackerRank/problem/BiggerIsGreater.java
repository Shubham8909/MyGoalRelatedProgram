package com.hackerRank.problem;

import java.util.Arrays;

public class BiggerIsGreater {

	public static void main(String[] args) {
		String s="dkhc";
		String str=biggerIsGreater(s);
		System.out.println("Str ++>"+str);
	}

	private static String biggerIsGreater(String s) {
		char ch[]=s.toCharArray();
		int findIndex=0;
		//checking which charactor is less the previous one from end.
		for(int i=ch.length-1; i>0 ;i--) {
			if(ch[i]>ch[i-1] ) {
				findIndex =i;
				break;
			}
		}
      if(findIndex==0) {
    	  return "no ansewer";
      }else {
    	  System.out.println("  "+ch[findIndex]);
    	  Arrays.sort(ch,findIndex,ch.length);
    	  int replance=0;
    	  for(int i=findIndex; i<ch.length;i++) {
    		  if(ch[findIndex-1]<ch[i]) {
    			  replance=i;
    			  break;
    		  }
    	  }
    	  char smallCharactor=ch[findIndex-1];
    		 ch[findIndex-1]= ch[replance];
    		 ch[replance]=smallCharactor;
    		return new String(ch);
    	  
      }
	}

}
