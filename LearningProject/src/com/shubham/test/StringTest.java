package com.shubham.test;

import java.util.HashMap;
import java.util.WeakHashMap;

public class StringTest {
	
		public static void main(String... args) {
		    for (int i = 0; i < 1000; i++) {
		        int len = (Integer.MAX_VALUE/2) - i;
		   
		        try {
		            char[] ch = new char[len];
		            System.out.println("len: " + len + " OK");
		        } catch (Error e) {
		            System.out.println("len: " + len + " " + e);
		        }
		    }
	}
	


}
