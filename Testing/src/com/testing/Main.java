package com.testing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.package1.Employee;

public class Main {

	public static void main(String[] args) {
		
		
		Tweet t= new Tweet();
		t.setFlag(false);
		
		Set<Tweet> s= new HashSet<>();
		
		s.add(t);
		
		List<Tweet> l= new ArrayList<>();
		Tweet t1=t;
		t1.setFlag(true);
		l.add(t1);
	
		System.out.println(s);
		System.out.println(l);
		
		

		Map<String, Integer> map = new HashMap<>();
		map.put("shubham", 1);
		map.put("Ajay", 2);
		map.put("Nitin", 3);
		map.put("aman", 4);

		System.out.println(map);

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue().compareTo(o2.getValue()));
			}
		});
		Map<String, Integer> map2 = new LinkedHashMap<>();
		for (Entry<String, Integer> emap : list) {
			map2.put(emap.getKey(), emap.getValue());
		}

		System.out.println(map2);
	}

}
