package com.overridding;

import java.util.Iterator;
import java.util.Map;

public class HashMapCMECheck {
	public static void main(String[] args) {
		
		Thread1.map.put("Nitin", 2);
		Thread1.map.put("kiran", 3);
		Thread1.map.put("ramu", 5);
		
		Thread1 r= new Thread1();
		Thread t= new Thread(r);
		t.start();
		
		
		
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { }
		 */
		
		  Iterator<Map.Entry<String, Integer>> itr= Thread1.map.entrySet().iterator();
		  while(itr.hasNext()) { Map.Entry<String, Integer> entry=itr.next();
		  System.out.println(entry.getKey()+"-----"+entry.getValue()); }
		
		  Thread1.map.put("TARRA", 3);
		  Thread1.map.put("JITU", 5);
		  System.out.println("map size "+ Thread1.map.size());
	}

}
