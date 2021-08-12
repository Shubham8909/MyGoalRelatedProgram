package com.inventory.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.demo.model.Product;
import com.inventory.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService  productService;
	
	@PostMapping("/product/insert")
	public ResponseEntity<Object> insertProduct(@RequestBody Product product){
		   productService.addProduct(product);
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
	
	@PostMapping("/product/edit")
	public ResponseEntity<Object> editProduct(@RequestBody Product product){
		   productService.editProduct(product);
		return new ResponseEntity<>("OK",HttpStatus.OK);
	}
	@GetMapping("/product/delete")
	public ResponseEntity<Object> deleteProduct(String product){
		   productService.deleteProduct(product);
		return new ResponseEntity<>("OK",HttpStatus.OK);
	}
	
	@GetMapping("/product/show")
	public ResponseEntity<List<Product>> showProduct(){
		return new ResponseEntity<>(productService.showAllProdut(),HttpStatus.OK);
	}
	

}
