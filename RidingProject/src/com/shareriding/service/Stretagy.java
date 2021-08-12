package com.shareriding.service;

import java.util.HashSet;
import java.util.List;

import com.shareriding.modle.OfferRide;
import com.shareriding.modle.TakeRide;

public interface Stretagy {
	
	public List<OfferRide> Strategy(TakeRide takeRide, HashSet<OfferRide> offRideList);
}
