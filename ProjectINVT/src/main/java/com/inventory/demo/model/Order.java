package com.inventory.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Order {
	
	private int id;
	private List<OrderDetails> listOfOrderDetails;
	public Order(int id) {
		this.id = id;
		this.listOfOrderDetails=new ArrayList<>();
	}
	
    
}
