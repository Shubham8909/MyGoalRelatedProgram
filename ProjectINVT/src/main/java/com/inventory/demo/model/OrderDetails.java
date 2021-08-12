package com.inventory.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDetails {
	
	private int id;
	private Product product;
	private int orderId;
    private int price;
	

}
