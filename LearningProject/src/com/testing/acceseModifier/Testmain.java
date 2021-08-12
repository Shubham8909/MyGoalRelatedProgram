package com.testing.acceseModifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Testmain {
	
	 static  int a=10;
	   int b=10;
	
	public static  void Testmain1(Object t) {
		System.out.println("In object");
	}
	
	public static void Testmain1(String t) {
		System.out.println("In String");
	}
	
	public static void Testmain2(Object t) {
		System.out.println("In object");
	}
	public static void Testmain2(Number t) {
		System.out.println("In Number");
	}

	public static void Testmain2(Integer t) {
		System.out.println("In Integer");
	}
	
	public static void Testmain2(int t) {
		System.out.println("In int");
	}
	

	public static int  m1(Object b,String s) throws Exception {
		
		try {
			return 10;
		}finally {
			return 20;
		}
		
	}

	
	public static void main(String[] args) {
		
		Testmain.Testmain1(null);
		Testmain.Testmain2(2);
		try {
			System.out.println(Testmain.m1("shubham", "Shubham"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Shubham extends Testmain{
	
}

@FunctionalInterface
interface ssshjsjsjs{
	void m1();
}

