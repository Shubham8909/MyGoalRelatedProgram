package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Dish;
import com.example.demo.model.Restaurants;

@Service
public class RestService {
	
	static Map<String , List<Restaurants>> restmap = new HashMap<String, List<Restaurants>>();


	public List<Dish> getAllDishes(String cuisine, String rid) throws Exception {
		
		
		if(!restmap.containsKey(rid)) {
			throw new Exception(" RID not present");
		}
		List<Restaurants> listR=  restmap.get(rid);
		Optional<Restaurants> rs=	listR.stream().filter(r -> r.getRid() ==Integer.parseInt(rid) ).findAny();

		return null;
	}

	
	
	

}
