package com.MachineCoding.program;

public class RideInfo {
	
	private CustInfo rider;
	private CustInfo driver;
	
	public RideInfo(CustInfo rider, CustInfo driver) {
		super();
		this.rider = rider;
		this.driver = driver;
	}
	public CustInfo getRider() {
		return rider;
	}
	public void setRider(CustInfo rider) {
		this.rider = rider;
	}
	public CustInfo getDriver() {
		return driver;
	}
	public void setDriver(CustInfo driver) {
		this.driver = driver;
	}
	@Override
	public String toString() {
		return "RideInfo [rider=" + rider + ", driver=" + driver + "]";
	}

	
}
