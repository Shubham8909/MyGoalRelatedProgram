package com.vermas.code.learning;

public class RemoveDuplicate {
	
public static void main(String[] args) {
	
	String s="ShubhamShubham";
	String s1="";
	for(int i=0;i<s.length();) {
		char c=s.charAt(i);
	    s=s.substring(i+1);
	    s=s.replaceAll(String.valueOf(c), "");
	    s1+=String.valueOf(c);
	}
	
	System.out.println("duplicate remove from "+s+" final String "+s1);
}
	

}
