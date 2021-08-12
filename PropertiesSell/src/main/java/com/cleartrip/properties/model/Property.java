package com.cleartrip.properties.model;


import lombok.Getter;

@Getter
public class Property {
	private int id;
	private String username;
	private String propertyName;
	private String location;
	private int price;
	private String type;
	private String size;
	private int numberOfRoom;
	private Status status;

	public void ChangeStatusToSold() {
		this.status = Status.SOLD;
	}

	public Property(int id,String username, String propertyName, String location, int price, String type, String size,
			int numberOfRoom) {
		super();
		this.id=id;
		this.username = username;
		this.propertyName = propertyName;
		this.location = location;
		this.price = price;
		this.type = type;
		this.size = size;
		this.numberOfRoom = numberOfRoom;
		this.status = Status.AVAILABLE;
	}
}
