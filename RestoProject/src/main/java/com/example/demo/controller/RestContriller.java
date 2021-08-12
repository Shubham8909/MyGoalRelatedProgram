package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dish;
import com.example.demo.service.RestService;

@RestController
public class RestContriller {
	
	@Autowired
	private RestService restService;
	
	@GetMapping("/getDish/{cuisine}/{rid}")
	public List<Dish> getAllDishes(@PathVariable String cuisine,@PathVariable String rid) throws Exception{
		return restService.getAllDishes(cuisine,rid);
		
	}

}
