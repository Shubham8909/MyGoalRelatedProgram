package com.shareriding.abstraction;

import com.shareriding.exception.NotDefinedStrategyException;
import com.shareriding.service.MoreVaccantSatrategy;
import com.shareriding.service.PreferredVehicleStategy;
import com.shareriding.service.Stretagy;

public class StrategyAbstraction {
  
	public Stretagy getStretagey(String name) throws NotDefinedStrategyException {
		if(name.equalsIgnoreCase("Most Vacant")) {
			return new MoreVaccantSatrategy();
		}else if(name.equalsIgnoreCase("Activa") || name.equalsIgnoreCase("Baleno") || name.equalsIgnoreCase("polo") ) {
			return new PreferredVehicleStategy();
		}else {
			throw new NotDefinedStrategyException("Not defined Given Strategy.");
		}
	}
}
