package com.shubham.learning;

import java.util.ArrayList;
import java.util.List;

public class BooleanClass {
	
	public static void main(String[] args) {
		String s="true";
		System.out.println("--->"+Boolean.getBoolean(s));
		
	  Object[] a= new Object[5];
	  
	  String[] s1= new String[5];
	  
	  a=s1;
		
		ArrayList<Object> list= new ArrayList<>();
		
		ArrayList<String> list1= new ArrayList<>();
		list1.add("pung");
		list.add("Shubham");
		list.add(1);
		list.addAll(list1);
		
		for(Object o:list) {
			System.out.println(o);
		}
		
	}

}
