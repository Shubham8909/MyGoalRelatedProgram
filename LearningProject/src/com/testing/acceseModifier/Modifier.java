package com.testing.acceseModifier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

public class Modifier {
	
	public int i;
	 int j;
	 
	 public Modifier(int i) {
		 this.i=i;
	 }
	 public Modifier(int i,int j) {
		 this.i=i;
	 }
	 public Modifier() {
	 }
  public  void m1() {
		
	}
  
  public  int m1(int i) {
		return 0;
	}
	public static void main(String[] args) {
		String arr[]= {"1","2"};
		main(arr);
		
	}

}

class Shubham1 extends Modifier{
	public Shubham1(int i) {
	
		this.i=i*2;
	}
	
	public Shubham1(int i,int j) {
		this.i=j;
	}
	public void m1() throws ArrayIndexOutOfBoundsException  {
		
	}
	
}
