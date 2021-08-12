package com.inventory.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Invoice {
    private String productName;
    private int quantity;
    private double price;
}