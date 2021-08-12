package com.inventory.demo.service;

import java.util.List;

import com.inventory.demo.model.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	public Product editProduct(Product product);
	public void deleteProduct(String productName);
	public List<Product> showAllProdut();

}
