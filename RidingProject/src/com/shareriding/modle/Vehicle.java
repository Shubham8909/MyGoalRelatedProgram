package com.shareriding.modle;


public class Vehicle {
	
	private String userName;
	private String vehicleName;
	private String vehicleNumber;
	
	public String getUserName() {
		return userName;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public Vehicle(String userName, String vehicleName, String vehicleNumber) {
		super();
		this.userName = userName;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
	}
	@Override
	public String toString() {
		return "Vehicle [userName=" + userName + ", vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber
				+ "]";
	}
	
	
	
}
