package com.cleartrip.properties.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cleartrip.properties.model.Command;
import com.cleartrip.properties.model.Property;
import com.cleartrip.properties.service.SearchPropertiesService;


public class ShortListPropertyCommand extends CommandExecutors {

	public static final String SHORTLIST_PROP = "SHORTLIST_PROP";

	private SearchPropertiesService searchPropertiesService;
	
	public Map<String, List<Property>> shortMap=  new HashMap<>();

	public ShortListPropertyCommand(SearchPropertiesService searchPropertiesService) {
		super();
		this.searchPropertiesService = searchPropertiesService;
	}

	@Override
	public boolean isAcceptable(Command command) {
		if (command.getCommadName().equalsIgnoreCase(SHORTLIST_PROP))
			return true;

		return false;
	}

	@Override
	public boolean isValid(Command command) {
		if (command.getParams().size() == 1)
			return true;
		return false;
	}

	@Override
	public String executeValidCommand(Command command) {
		int id= Integer.parseInt(command.getParams().get(0));
		Map<String, List<Property>> mapList=searchPropertiesService.mapearchList;
		for(Map.Entry<String, List<Property>> usersProperties :mapList.entrySet()) {
			List<Property> propList=usersProperties.getValue();
			Optional<Property> prp=propList.stream().filter(p->p.getId()==id).findAny();
			if(prp.isPresent()) {
				if(shortMap.containsKey(usersProperties.getKey())) {
					shortMap.get(usersProperties.getKey()).add(prp.get());
				}else {
					List<Property> listP= new ArrayList<Property>();
					listP.add(prp.get());
					shortMap.put(usersProperties.getKey(), listP);
				}
				break;
			}
		}
		return "ShortListed";
	}

}
