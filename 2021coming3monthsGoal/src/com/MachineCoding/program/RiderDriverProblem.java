package com.MachineCoding.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RiderDriverProblem {

	public static void main(String[] args) {
		List<RideInfo> rideInfo = new ArrayList<RideInfo>();
		RideInfo r= new RideInfo(new CustInfo("Ram", 3), new CustInfo("Bheem", 5));
		RideInfo r1= new RideInfo(new CustInfo("Laxman", 5), new CustInfo("Nakul", 2));
		RideInfo r2= new RideInfo(new CustInfo("Ram", 4), new CustInfo("Sahadev", 2));
		RideInfo r3= new RideInfo(new CustInfo("Bharat", 3), new CustInfo("Bheem", 5));
		RideInfo r4= new RideInfo(new CustInfo("Ram", 3), new CustInfo("Bheem", 1));
		RideInfo r5= new RideInfo(new CustInfo("Laxman", 5), new CustInfo("Sahadev", 3));
		RideInfo r6= new RideInfo(new CustInfo("Bharat", 5), new CustInfo("Nakul", 5));
		
		rideInfo.add(r);
		rideInfo.add(r1);
		rideInfo.add(r2);
		rideInfo.add(r3);
		rideInfo.add(r4);
		rideInfo.add(r5);
		rideInfo.add(r6);
		
		String rider = "Ramu";
		List<AvgUtil> findedDriver = solutions(rideInfo, rider);
		System.out.println(findedDriver);

		// List<PersonDetails> findDriver =Solution(rideInfo,rider);

	}

	private static List<AvgUtil> solutions(List<RideInfo> rideInfo, String rider) {

		// Case 3;

		// Driver Info with AVG rating
		Map<String, AvgUtil> driverMap = new HashMap<>();
		// Rider Info with AVG rating
		Map<String, AvgUtil> riderMap = new HashMap<>();

		// case : 1
		for (RideInfo info : rideInfo) {
			// Driver
			String driverName = info.getDriver().getName();
			if (driverMap.containsKey(driverName)) {
				AvgUtil temp = driverMap.get(driverName);
				AvgUtil newTemp = changeValue(temp, info.getDriver().getRating(), info.getDriver().getName(),info.getRider().getName());
				driverMap.remove(driverName);
				driverMap.put(driverName, newTemp);
			} else {
				Map<String,Double> map=new HashMap<>();
				if(info.getDriver().getRating()<=1) 
				  map.put(info.getRider().getName(), info.getDriver().getRating());
				driverMap.put(driverName, new AvgUtil(1, info.getDriver().getRating(), info.getDriver().getName(),map));
			}
			// Rider
			String riderName = info.getRider().getName();
			if (riderMap.containsKey(riderName)) {
				AvgUtil temp = riderMap.get(riderName);
				AvgUtil newTemp = changeValue(temp, info.getRider().getRating(), info.getRider().getName(),info.getDriver().getName());
				riderMap.remove(riderName);
				riderMap.put(riderName, newTemp);
			} else {
				Map<String,Double> map=new HashMap<>();
				if(info.getRider().getRating()<=1) 
				  map.put(info.getDriver().getName(), info.getRider().getRating());
				riderMap.put(riderName, new AvgUtil(1, info.getRider().getRating(), info.getRider().getName(),map));
			}
		}
		
		System.out.println("riderMap -"+riderMap);
		System.out.println("Driver -"+driverMap);
		AvgUtil riderAvg = riderMap.get(rider);
		Iterator<Map.Entry<String, AvgUtil>> itr = driverMap.entrySet().iterator();
		List<AvgUtil> driverList = new ArrayList<>();
		while (itr.hasNext()) {
			Map.Entry<String, AvgUtil> entry = itr.next();
			double driverAvg = entry.getValue().getAvg();
			if (riderAvg!=null && !riderAvg.getMinMap().containsKey(entry.getValue().getName()) && !entry.getValue().getMinMap().containsKey(rider)  && driverAvg > riderAvg.getAvg()) {
				driverList.add(entry.getValue());
			}
		}
		if (driverList.isEmpty()) {
		
			Map<String, AvgUtil> sortedMap = driverMap.entrySet().stream().sorted((a, b) -> {
				if (b.getValue().getAvg() > a.getValue().getAvg())
					return 1;
				else if (b.getValue().getAvg() < a.getValue().getAvg())
					return -1;
				else
					return 0;
			}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

			Iterator<Map.Entry<String, AvgUtil>> itr1 = sortedMap.entrySet().iterator();
			if (itr1.hasNext()) {
				Map.Entry<String, AvgUtil> entry = itr1.next();
				AvgUtil avg = entry.getValue();
				driverList.add(avg);
			}
		}
		// RiderRating Info with AVG rating
		return driverList;
	}

	private static AvgUtil changeValue(AvgUtil temp, double rating, String name, String personGiveMinRating) {
		int count = temp.getCount();
		double avg = temp.getAvg();
		double newAvg = (avg * count + rating) / (count + 1);
		if(rating<=1) {
			temp.getMinMap().put(personGiveMinRating, rating);
		}
		return new AvgUtil(count + 1, newAvg, name,temp.getMinMap());
	}
}
