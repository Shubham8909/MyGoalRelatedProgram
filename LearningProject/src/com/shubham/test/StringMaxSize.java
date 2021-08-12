package com.shubham.test;

import java.util.Arrays;

public class StringMaxSize {
	public static void main(String args[]) {
		for (int i = 0; i < 1000; i++) {
			try {
//Integer.MAX_VALUE is a constant that stores the maximum possible value for any integer variable  
				char[] array = new char[Integer.MAX_VALUE - (Integer.MAX_VALUE/2)];
//assign the specified data value to each element   
				Arrays.fill(array, 'a');
//creating a constructor of the String class and parses an array into it  
				String str = new String(array);
//determines and print the length of the string  
				System.out.println(str.length());
			} catch (Throwable e) {
// returns the detail message string of this throwable  
				System.out.println(e.getMessage());
//prints the maximum value  
				System.out.println("Last: " + (Integer.MAX_VALUE - i));
				System.out.println("Last: " + i);
			}
		}
	}
}