package com.grab;


//[p(1,1),p(2,2),p(3,3), p(2,4),p(18,2),p(18,4),g(2),r(2)]
public class MyhashMap {
	
	static int maxSize=1000000;
	static Node bukuts [] =null; 

	public MyhashMap() {
		bukuts = new Node[16];
	}
	

	
     public void put(int key, int value) {
    	 int hash= key % 16;
    	 if(bukuts[hash]==null) {
    		 Node n= new Node(key, value);
    		 bukuts[hash]=n;
    	 }else {
    		 Node previous= bukuts[hash];
    		// 2,4,
    		 while(previous.next!=null &&  previous.getKey()!=key) {   
    			 previous= previous.next;
    		 }
    		 if(previous.getKey()==key) {
    			 previous.setValue(value);
    		 }else {
    			 previous.next=new Node(key,value); 
    		 } 
    	 }
    	 
     }
     
     public int get(int key) {
    	 int hash= key % 16;
    	 if(bukuts[hash]==null) {
    		 return -1;
    	 }else {
    		 Node previous= bukuts[hash];
    		 while(previous!=null &&  previous.getKey()!=key) {
    			 previous= previous.next;
    		 }
    		 if(previous.getKey()==key) {
    			 return previous.getValue();
    		 }else {
    			return -1;
    		 } 
    	 }
     }
     
     public void remove(int key) {
    	 int hash= key % maxSize;
    	 if(bukuts[hash]==null) {
    		 return;
    	 }else {
    		 Node previous= bukuts[hash];
    		 while(previous.next!=null &&  previous.next.getKey()!=key) {
    			 previous= previous.next;
    		 }
    		 previous.next= previous.getNext().getNext();
    	 }
    	 
     }
     

}
