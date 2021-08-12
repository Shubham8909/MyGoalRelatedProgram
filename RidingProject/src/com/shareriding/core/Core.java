package com.shareriding.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.shareriding.abstraction.StrategyAbstraction;
import com.shareriding.exception.InvalidUserException;
import com.shareriding.exception.NotDefinedStrategyException;
import com.shareriding.exception.UserNotFoundException;
import com.shareriding.modle.OfferRide;
import com.shareriding.modle.TakeRide;
import com.shareriding.modle.User;
import com.shareriding.modle.Vehicle;
import com.shareriding.util.RideStatus;
import com.shareriding.util.UtilInterface;

public class Core {
	
	public static HashSet<User> userSet = new HashSet<>();
	public static Map<String,List<Vehicle>> userVehicalmap = new HashMap<>();
	public static Map<String,Integer> offerRiderMap = new HashMap<>();
	public static Map<String,Integer> takerRiderMap = new HashMap<>();
	public static HashSet<OfferRide> OfferRideList = new HashSet<>();
	private  StrategyAbstraction sAbatraction;
	public Core() {
		this.sAbatraction=new StrategyAbstraction();
	}

	public void addUser(User user) throws InvalidUserException {
		if (UtilInterface.validateUser(user) && !userSet.contains(user)) {
			userSet.add(user);
			System.out.println("User Added");
		} else
			System.out.println("User Already Added..");
	}
	
	public  void addVehicle(Vehicle vehicle) {
	   if(!UtilInterface.isUserPresent(userSet,vehicle.getUserName())){
		   System.out.println("Given user Not Present.Kindly add User then add vehicle");
		   return;
	   }
	   if(userVehicalmap.containsKey(vehicle.getUserName())) {
		   List<Vehicle> vlist =userVehicalmap.get(vehicle.getUserName());
		   vlist.add(vehicle);
		   userVehicalmap.put(vehicle.getUserName(), vlist);
	   }else {
		   List<Vehicle> vlist=new ArrayList<Vehicle>();
		   vlist.add(vehicle);
		   userVehicalmap.put(vehicle.getUserName(),vlist);
	   }
	   System.out.println("Vehicle Added for user "+vehicle.getUserName());
	}
	
	public void offerRide(OfferRide offerRide) {
		 if(!UtilInterface.isUserVehiclePresent(offerRide,userVehicalmap)) {
			 System.out.println("Given user/vehicle is not present kinldy add user and vehicle first.");
			   return;
		 }
		 if(OfferRideList.contains(offerRide)) {
			 System.out.println(offerRide.getVehicle().getUserName()+" :: Given user's vehicle is already added in OfferRide.");
			 return;
		 }
		 OfferRideList.add(offerRide);
		 offerRiderMap.put(offerRide.getVehicle().getUserName(), offerRiderMap.getOrDefault(offerRide.getVehicle().getUserName(), 0)+1);
	}
	
	public List<OfferRide> searchRide(TakeRide takeRide) throws UserNotFoundException, NotDefinedStrategyException {
		  if(!UtilInterface.isUserPresent(userSet,takeRide.getUserName())){
			   System.out.println("Given user Not Present.Kindly add User then search for Ride.");
			   throw new UserNotFoundException("User are not register.");
		   }
		  List<OfferRide> strategyList=	 sAbatraction.getStretagey(takeRide.getStrategy()).Strategy(takeRide, OfferRideList);
		  List<OfferRide> finalList = UtilInterface.commonStrategy(strategyList, takeRide); 
		  if(!finalList.isEmpty())
			  takerRiderMap.put(takeRide.getUserName(), takerRiderMap.getOrDefault(takeRide.getUserName(), 0)+1);
		  
		  return finalList;
	}
	
	public void end_ride(OfferRide endRide) {
		for(OfferRide ride:OfferRideList) {
			if(ride.equals(endRide)) {
				ride.changeStatus(RideStatus.FINISH);
			}
		}
	}
	
	public  void print_ride_stats() {
		userSet.stream().map(s->s.getName()).forEach(s->System.out.println(s+" : "+takerRiderMap.get(s)+" Taken : "+offerRiderMap.get(s)+" Offered "));
	}
	

}
