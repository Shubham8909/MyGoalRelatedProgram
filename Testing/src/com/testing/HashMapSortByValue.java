package com.testing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapSortByValue {

	public static void main(String[] args) {
		
		Map<Integer, Integer> map= new HashMap<Integer, Integer>();
		map.put(1, 2);
		map.put(5, 7);
		map.put(9, 1);
		map.put(3, 20);
		map.put(6, 11);
		
		Map<Integer, Integer> map2=	map.entrySet().stream().sorted((e1,e2)->e1.getValue()-e2.getValue()).
		collect(Collectors.toMap(Map.Entry :: getKey,Map.Entry:: getValue,(e1, e2) -> e1 ,LinkedHashMap::new));

		System.out.println(map);
		System.out.println(map2);
	}

}
