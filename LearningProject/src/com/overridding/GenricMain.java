package com.overridding;

public class GenricMain {

	public static void main(String[] args) {
	 GenricTest<Integer> intValue= new GenricTest<>();
	 GenricTest<String> stringValue= new GenricTest<>();
	 //un comment the below code and check we are getting type cast error
		 //intValue=stringValue; 
	}

}
