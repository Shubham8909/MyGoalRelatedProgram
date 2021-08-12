package com.testing.acceseModifier;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test{

	
	public void method2() throws RuntimeException{
		// TODO Auto-generated method stub
		
	}

	public void method1(String str) {
		// TODO Auto-generated method stub
		
	}
	public void log(String str) {
		// TODO Auto-generated method stub
		
	}


}


class SSSSSS extends Test{
	
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	
	public void method1(String str) {
		// TODO Auto-generated method stub
		
	}
	
}


 interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	//trying to override Object method gives compile-time error as
	//"A default method cannot override a method from java.lang.Object"
	
//	default String toString(){
//		return "i1";
//	}
	
}




 interface Interface2 extends Interface1 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}

}





