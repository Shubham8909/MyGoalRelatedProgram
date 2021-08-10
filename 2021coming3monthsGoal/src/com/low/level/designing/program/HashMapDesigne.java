package com.low.level.designing.program;

public class HashMapDesigne {
	static int size=16;
	static Node1 [] arrNode =new Node1[size];	

	public void put(String key,int value) {
		int hashcode=key.hashCode();
		if(hashcode<0) hashcode=-1*hashcode;
		int findIndex=hashcode%size;
		Node1 node1=arrNode[findIndex];
		
		if(node1==null) {
			Node1 node2=new Node1();
			node2.key=key;
			node2.value=value;
			node2.next=null;
			arrNode[findIndex]=node2;
		}else {
			 Node1 temp=node1;
			 while(temp.next!=null) {
				   if(temp.key.equals(key)) {
					   temp.value=value;
					   return;
				   }
				   temp= temp.next;
			   }
			Node1 node2=new Node1();
			node2.key=key;
			node2.value=value;
			node2.next=null;
			temp.next=node2;
			arrNode[findIndex]=node1;
		}
		
	}

   public int get(String key) {
	   int hashcode=key.hashCode();
	   if(hashcode<0) hashcode=-1*hashcode;
		int findIndex=hashcode%size;
		System.out.println("findIndex --for key "+key +" : "+findIndex);
		Node1 node1=arrNode[findIndex];
	   if(node1==null) {
		   return -1;
	   }else {
		   Node1 temp=node1;
		   while(temp!=null) {
			   if(temp.key.equals(key)) {
				   return temp.value;
			   }
			   temp= temp.next;
		   }
		   return -1;
	   }
   }

   
   public void remove(String key) {
	   int hashcode=key.hashCode();
	   if(hashcode<0) hashcode=-1*hashcode;
		int findIndex=hashcode%size;
		System.out.println("findIndex --for key "+key +" : "+findIndex);
		Node1 node1=arrNode[findIndex];
	   if(node1==null) {
		   System.out.println("Not key present in Map");
	   }else {
		   Node1 curr=node1;
		   Node1 prev=null;
		   if(curr!=null & curr.key.equals(key)) {
			  curr=curr.next;
			  arrNode[findIndex]=curr;
			  return;
		   }
		   
		   while(curr!=null) {
			   
			   prev=curr;
			   curr=curr.next;
		   }
		   if(curr==null) {
			   return;
		   }
		   prev.next=curr.next;
	   }
   }

	public static void main(String[] args) {
	HashMapDesigne hashMap=new HashMapDesigne();
	hashMap.put("Shubham", 1);
	hashMap.put("Nitin", 2);
	hashMap.put("rishav", 2);
	hashMap.put("raghu", 2);
	hashMap.put("Shubham", 10);
	
	System.out.println(hashMap.get("raghu"));
	System.out.println(hashMap.get("Shubham"));
	hashMap.remove("Shubham");
	hashMap.remove("Nitin");
	
	hashMap.put("Nitin", 25);

	System.out.println(hashMap.get("Shubham"));
	
	System.out.println(hashMap.get("Nitin"));
	}
	
	
	

}

class Node1{
	String key;
	int value;
	Node1 next;
}

