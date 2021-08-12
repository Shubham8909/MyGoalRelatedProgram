package com.shubham.learning;

public class MainLRUClass {
	
	public static void main(String[] args) {
		
		LRUCache lru=new LRUCache(5);
		lru.set(1, 5);
		lru.set(2, 7);
		lru.set(3, 6);
		lru.set(4, 10);
		lru.set(5, 12);
		
		System.out.println(lru.get(1));
		System.out.println(lru.get(5));
		lru.set(6, 13);
		lru.set(7, 12);
		System.out.println(lru.map);
		System.out.println(lru.get(2));
		
	}

}
