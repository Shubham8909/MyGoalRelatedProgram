package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Restaurants {
	private int rid;
	private String name;
	private String description;
	private String brand;
	private String image;
	private String location;
	private Cuisine  cuisines;
	private List<Dish> listOfDish;
	
	public Restaurants(int rid, String name, String description, String brand, String image, String location,
			Cuisine cuisines) {
		super();
		this.rid = rid;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.image = image;
		this.location = location;
		this.cuisines = cuisines;
		this.listOfDish= new ArrayList<Dish>();
	}
	
	
}
