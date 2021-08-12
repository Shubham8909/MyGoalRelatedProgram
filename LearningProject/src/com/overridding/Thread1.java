package com.overridding;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Thread1 implements Runnable {

	public static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

	@Override
	public void run() {
		System.out.println("In the thread..");
		
		  try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		   e.printStackTrace(); }
		 
		/*
		 * Iterator<Map.Entry<String, Integer>> itr= Thread1.map.entrySet().iterator();
		 * 
		 * while(itr.hasNext()) { Map.Entry<String, Integer> entry=itr.next();
		 * System.out.println(entry.getKey()+"-----"+entry.getValue());
		 * 
		 * if(entry.getKey().equalsIgnoreCase("Nitin")) {
		 * Thread1.map.remove(entry.getKey()); }
		 * 
		 * }
		 */
		  Thread1.map.put("TARRA1", 3);
		
		  System.out.println("map size "+ Thread1.map.size());
	}

}
