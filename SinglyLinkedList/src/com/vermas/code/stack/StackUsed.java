package com.vermas.code.stack;

public class StackUsed {
	
  private Integer[] stack;
  private int size;
  private int top;
  
  //Default 
  public StackUsed() {
	  this.top=-1;
	  this.size=10;
	  this.stack= new Integer[10];
  }
  
  public StackUsed(int i) {
	  this.top=-1;
	  this.size=i;
	  this.stack= new Integer[i];
  }
  
  public boolean isEmpty() {
	  return top==-1;
  }
  
  public boolean isStackFull() {
	  return top-1==size;
  }
  
  public boolean push(int q) {
	  if(!isStackFull()) {
		  top++;
		  stack[top]=q;
		  return true;
	  }else {
		  return false;
	  }
  }
  
  public int  pop() {
    if(!isEmpty()) {
    	return stack[top-- ];
    }else {
    	return -1;
    }
  }
  
  public int  peek() {
	    if(!isEmpty()) {
	    	return stack[top];
	    }else {
	    	return -1;
	    }
	  }
  
  public int search(int value) {
	  int temp = top;
	  for(int i=top; i>=0;i--) {
		  if(stack[i]==value) {
			  return temp;
		  }
		  temp--;
	  }
	  return -1;
  }
  
  public void display() {
	  for(int i=top; i>=0;i--) {
		  System.out.println(stack[i]);
	  }
  }
  
}
