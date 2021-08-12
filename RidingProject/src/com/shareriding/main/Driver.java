package com.shareriding.main;

import java.util.List;
import com.shareriding.core.Core;
import com.shareriding.exception.InvalidUserException;
import com.shareriding.exception.NotDefinedStrategyException;
import com.shareriding.exception.UserNotFoundException;
import com.shareriding.modle.OfferRide;
import com.shareriding.modle.TakeRide;
import com.shareriding.modle.User;
import com.shareriding.modle.Vehicle;
import com.shareriding.util.Gender;
import com.shareriding.util.RideStatus;

public class Driver {

	public static void main(String[] args)
			throws UserNotFoundException, NotDefinedStrategyException, InvalidUserException {
		Core c = new Core();
		User u = new User("Rohan", Gender.M, 36);
		User u1 = new User("Shashank", Gender.M, 29);
		User u2 = new User("Nandini", Gender.F, 29);
		User u3 = new User("Shipra", Gender.M, 27);
		User u4 = new User("Gaurav", Gender.M, 29);
		User u5 = new User("Rahul", Gender.M, 35);
		
		c.addUser(u);
		c.addUser(u1);
		c.addUser(u2);
		c.addUser(u3);
		c.addUser(u4);
		c.addUser(u5);

		Vehicle vic = new Vehicle("Rohan", "Swift", "KA-01-12345");
		Vehicle vic1 = new Vehicle("Shashank", "Baleno", "TS-05-62395");
		Vehicle vic2 = new Vehicle("Shipra", "Polo", "KA-05-41491");
		Vehicle vic3 = new Vehicle("Shipra", "Activa", "KA-12-12332");
		Vehicle vic4 = new Vehicle("Rahul", "XUV", "KA-05-1234");

		c.addVehicle(vic);
		c.addVehicle(vic1);
		c.addVehicle(vic2);
		c.addVehicle(vic3);
		c.addVehicle(vic4);
		
		System.out.println(Core.userSet);
		System.out.println(Core.userVehicalmap);

		OfferRide off = new OfferRide(vic, "Hyderabad", "Bangalore", 1, RideStatus.FREE);
		OfferRide off1 = new OfferRide(vic2, "Bangalore", "Mysore", 2, RideStatus.FREE);
		OfferRide off2 = new OfferRide(vic3, "Bangalore", "Mysore", 1, RideStatus.FREE);
		OfferRide off3 = new OfferRide(vic1, "Hyderabad", "Bangalore", 2, RideStatus.FREE);
		OfferRide off4 = new OfferRide(vic4, "Hyderabad", "Bangalore", 5, RideStatus.FREE);
		OfferRide off5 = new OfferRide(vic, "Hyderabad", "Bangalore", 1, RideStatus.FREE);

		c.offerRide(off);
		c.offerRide(off1);
		c.offerRide(off2);
		c.offerRide(off3);
		c.offerRide(off4);
		c.offerRide(off5);

		TakeRide take = new TakeRide("Nandini", "Bangalore", "Mysore", 1, "Most Vacant");
		List<OfferRide> list1 = c.searchRide(take);
		System.out.println(list1);

		TakeRide take1 = new TakeRide("Gaurav", "Bangalore", "Mysore", 1, "Activa");
		List<OfferRide> list2 = c.searchRide(take1);
		System.out.println(list2);

		TakeRide take2 = new TakeRide("Shashank", "Mumbai", "Bangalore", 1, "Most Vacant");
		List<OfferRide> list3 = c.searchRide(take2);
		System.out.println(list3);

		TakeRide take3 = new TakeRide("Rohan", "Hyderabad", "Bangalore", 1, "Baleno");
		List<OfferRide> list4 = c.searchRide(take3);
		System.out.println(list4);

		TakeRide take4 = new TakeRide("Shashank", "Hyderabad", "Bangalore", 1, "Polo");
		List<OfferRide> list5 = c.searchRide(take4);
		System.out.println(list5);
		
		c.end_ride(list1.get(0));
		c.end_ride(list2.get(0));
		c.end_ride(list4.get(0));
		
		System.out.println(Core.OfferRideList);
		
		c.print_ride_stats();
		
		System.out.println(Core.userSet);
		System.out.println(Core.userVehicalmap);

	}

}
