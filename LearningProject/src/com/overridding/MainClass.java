package com.overridding;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		
		List<A> list= new ArrayList<A>();
		list.add(new B());
		for(A a:list) {
			a.x();
		//	B b=(B)a; //type cast to call B class method..
	
		}
		
	}

}
