package com.bit.program;

public class Divide {
	
	public static void main(String[] args) {
	
	  int i=-10;
	  int j=-5;
	  int count=0;
	  int x=i,y=j;
	  String s=String.valueOf(j);
	  if(s.contains("-")) {
		  s=(String) (s.substring(1));
		  j=Integer.parseInt(s);
	  }
	  if(String.valueOf(i).contains("-") ) {
		  i=Integer.parseInt((String) String.valueOf(i).substring(1));
	  }
	  
	  System.out.println("i "+i+"j "+j);
	  while(i>0) {
		  if(i>=j)
			   count++;
		  i=i-j;
	  }
	  
	  System.out.println(x+" divided by "+ y+" is "+ count);
	}

}
