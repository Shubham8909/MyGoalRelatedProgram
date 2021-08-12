package com.inventory.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
public class Product {
	
	private int id;
	private String name;
	private String descriptions;
	private double price;
	private int quantity;
	
}
