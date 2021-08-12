package com.shareriding.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.shareriding.modle.OfferRide;
import com.shareriding.modle.TakeRide;
import com.shareriding.util.RideStatus;

public class MoreVaccantSatrategy implements Stretagy {

	@Override
	public List<OfferRide> Strategy(TakeRide takeRide, HashSet<OfferRide> offRideList) {
		List<OfferRide> mVacOffRideList = offRideList.stream().filter(r ->  r.getStatus().equals(RideStatus.FREE)
				).filter(r -> r.getAvailSeat() > takeRide.getAvailSeat()).collect(Collectors.toList());
		return mVacOffRideList;
	}
}
