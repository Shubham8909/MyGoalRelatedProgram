package com.shareriding.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.shareriding.modle.OfferRide;
import com.shareriding.modle.TakeRide;
import com.shareriding.util.RideStatus;

public class PreferredVehicleStategy implements Stretagy {

	@Override
	public List<OfferRide> Strategy(TakeRide takeRide, HashSet<OfferRide> offRideList) {
		List<OfferRide> pVehifRideList= offRideList.stream().filter(r -> (r.getStatus().equals(RideStatus.FREE))
		).filter(r->r.getVehicle().getVehicleName().equalsIgnoreCase(takeRide.getStrategy())).collect(Collectors.toList());
		return pVehifRideList;
	}

}
