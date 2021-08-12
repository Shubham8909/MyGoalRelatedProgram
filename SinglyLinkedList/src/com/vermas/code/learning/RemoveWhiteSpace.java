package com.vermas.code.learning;

import java.util.HashMap;

public class RemoveWhiteSpace {
   
	
	public static void main(String[] args) {
		
	
	String str="      Shubham      verma    is good       boy.     ";
	System.out.println(str.replaceAll("\\s", ""));
	String s=str.replaceAll("\\s", "");
	
	
	
	HashMap<Character,Integer> map= new HashMap<Character, Integer>();
	char ch[] = s.toCharArray();
	
		/*
		 * for(int i=0;i<ch.length;i++) { if(map.containsKey(ch[i])) { int count=
		 * map.get(ch[i]); map.put(ch[i], count+1); }else { map.put(ch[i], 1); } }
		 */
	
for (char c:ch) {
	
	int length=s.length()-s.replace(String.valueOf(c), "").length();
	if(length==1) {
		System.out.println("frist Not repeated value is = "+c);
		break;
	}
			/*
			 * 
			 * if(map.get(c)==1) { System.out.println("Not repeated value is = "+c); }
			 */
}
	
	
	}

}
