package com.inventory.demo.util;

import java.util.HashMap;
import java.util.Map;

import com.inventory.demo.model.Product;

public class ProductUtil {
	
	public static Map<String, Product> productMap= new HashMap<>();

	public static boolean isValid(Product product) {
        if(product==null) return false;
        else if (product.getId()==0 || product.getName()==null || Double.compare(product.getPrice(), 0.0)==0 || product.getQuantity()==0) return false;
		return true;
	}

}
