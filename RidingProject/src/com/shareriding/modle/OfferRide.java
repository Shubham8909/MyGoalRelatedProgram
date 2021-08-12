package com.shareriding.modle;

import com.shareriding.util.RideStatus;

public class OfferRide {
  
	private Vehicle vehicle;
	private String origin;
	private String destination;
	private int availSeat;
	private RideStatus status=RideStatus.FREE;

	public Vehicle getVehicle() {
		return vehicle;
	}
	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}
	public int getAvailSeat() {
		return availSeat;
	}

	public RideStatus getStatus() {
		return status;
	}
	public void changeStatus(RideStatus status) {
		this.status=status;
	}
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availSeat;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.getVehicleName().hashCode()+vehicle.getVehicleNumber().hashCode()+vehicle.getUserName().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferRide other = (OfferRide) obj;
		if (availSeat != other.availSeat)
			return false;
		if (status != other.status)
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.getUserName().equals(other.vehicle.getUserName()) && !vehicle.getVehicleName().equals(other.vehicle.getVehicleName()) && !vehicle.getVehicleNumber().equals(other.vehicle.getVehicleNumber()))
			return false;
		return true;
	}
	public OfferRide(Vehicle vehicle, String origin, String destination, int availSeat, RideStatus status) {
		super();
		this.vehicle = vehicle;
		this.origin = origin;
		this.destination = destination;
		this.availSeat = availSeat;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "OfferRide [vehicle=" + vehicle + ", origin=" + origin + ", destination=" + destination + ", availSeat="
				+ availSeat + ", status=" + status + "]";
	}
	
	
	
	
	
}
