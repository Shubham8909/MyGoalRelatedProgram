package com.inventory.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.inventory.demo.exception.InvalidProductException;
import com.inventory.demo.model.Product;
import com.inventory.demo.util.ProductUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product product) {
	   if(!ProductUtil.isValid(product)) {
		   throw new InvalidProductException("Product is invalid");
	   }
       ProductUtil.productMap.put(product.getName(), product);
	}

	@Override
	public Product editProduct(Product product) {
		 if(!ProductUtil.isValid(product)) {
			   throw new InvalidProductException("Product is invalid");
		   }
		 Product currProduct= ProductUtil.productMap.get(product.getName());
		 currProduct=product;
		return currProduct;
	}

	@Override
	public void deleteProduct(String productName) {
		  if(!ProductUtil.productMap.containsKey(productName)) {
			  throw new InvalidProductException("Product is not avialable");
		  }
		  ProductUtil.productMap.remove(productName);
	}

	@Override
	public List<Product> showAllProdut() {
		return	ProductUtil.productMap.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList());
	}

}
