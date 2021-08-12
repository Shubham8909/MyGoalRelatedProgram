package com.shubham.enums;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = -2587221750982479927L;
     String name;
	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
     
}
