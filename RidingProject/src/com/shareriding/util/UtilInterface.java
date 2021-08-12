package com.shareriding.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.shareriding.exception.InvalidUserException;
import com.shareriding.modle.OfferRide;
import com.shareriding.modle.TakeRide;
import com.shareriding.modle.User;
import com.shareriding.modle.Vehicle;

public interface UtilInterface {
	
	static boolean validateUser(User user) throws InvalidUserException {
		if(user!=null && user.getAge()!=0 && user.getGender()!=null && user.getName()!=null)
			return true;
		else
			throw new InvalidUserException("User Should be not empty.");
	}
	static boolean isUserPresent(HashSet<User> userSet, String username) {
		Optional<User> u= userSet.stream().filter(s->s.getName().equalsIgnoreCase(username)).findAny();
		return u.isPresent();
	}
	static boolean isUserVehiclePresent(OfferRide offerRide, Map<String, List<Vehicle>> userVehicalmap) {
		Optional<Map.Entry<String, List<Vehicle>>> entry=userVehicalmap.entrySet().stream().filter(e ->e.getKey().equalsIgnoreCase(offerRide.getVehicle().getUserName())).findAny();
		if(entry.isPresent()) {
			List<Vehicle> vList=entry.get().getValue();
			Optional<Vehicle> vehicle=vList.stream().filter(v->v.getVehicleName().equalsIgnoreCase(offerRide.getVehicle().getVehicleName())).findAny();
			return vehicle.isPresent();
		}
		return false;
	}
	
	public static List<OfferRide> commonStrategy(List<OfferRide> givenList, TakeRide takeRide) {

		List<OfferRide> commonFilter = givenList.stream().filter(r -> {
			if (r.getOrigin().equalsIgnoreCase(takeRide.getOrigin())
					&& r.getDestination().equalsIgnoreCase(takeRide.getDestination()))
				return true;
			else
				return false;

		}).collect(Collectors.toList());

		if (commonFilter.isEmpty()) {
			List<OfferRide> rideList = new ArrayList<OfferRide>();
			List<OfferRide> originFilter = givenList.stream()
					.filter(r -> r.getOrigin().equalsIgnoreCase(takeRide.getOrigin())).collect(Collectors.toList());
			List<OfferRide> destinationFilter = givenList.stream()
					.filter(r -> r.getDestination().equalsIgnoreCase(takeRide.getDestination()))
					.collect(Collectors.toList());
			int n = originFilter.size() < destinationFilter.size() ? originFilter.size() : destinationFilter.size();
			for (int i = 0; i < n; i++) {
				if (destinationFilter.get(i).getOrigin().equalsIgnoreCase(originFilter.get(i).getDestination())) {
					rideList.add(originFilter.get(i));
					rideList.add(destinationFilter.get(i));
				}
			}
			return rideList;
		}
		return commonFilter;
	}
}
