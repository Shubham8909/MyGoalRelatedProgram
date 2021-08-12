package com.cleartrip.properties.command;

import java.util.List;

import com.cleartrip.properties.model.Command;
import com.cleartrip.properties.model.Property;
import com.cleartrip.properties.service.SearchPropertiesService;

public class SearchPropertiesCommand extends CommandExecutors {
	
	public static final String SERCH_PROP = "SEARCH_PROP";
	
	private SearchPropertiesService  searchPropertiesService;
	
	public SearchPropertiesCommand(SearchPropertiesService searchPropertiesService) {
		super();
		this.searchPropertiesService = searchPropertiesService;
	}

	@Override
	public boolean isAcceptable(Command command) {
		if (command.getCommadName().equalsIgnoreCase(SERCH_PROP))
			return true;
		return false;
	}

	@Override
	public boolean isValid(Command command) {
		if(command.getParams().size()==6) return true;
		return false;
	}

	@Override
	public String executeValidCommand(Command command) {
		
		String location= command.getParams().get(0);
		String priceRange= command.getParams().get(1);
		String type= command.getParams().get(2);
		String size= command.getParams().get(3);
		int numberOfRooms= Integer.parseInt(command.getParams().get(4));
		String sortOn=  command.getParams().get(5);
		List<Property> totallistOfProp=searchPropertiesService.searchProperties(location,priceRange,type,size,numberOfRooms,sortOn);
		StringBuilder sb = new StringBuilder();
		if(totallistOfProp!=null) {
			for(Property por:totallistOfProp) {
			sb.append("id ").append("Title ").append("Location ").append("Price ").append("Size ").append(" Rooms ").append(" AvailableFor ")
			.append("\n").append(por.getId()+" ").append(por.getPropertyName()+" ").append(por.getLocation()+" ").
			  append(por.getPrice()+" ").append(por.getSize()+" ").append(por.getNumberOfRoom()+"BHK ").append(por.getType()+" ");
			}
		}
		return sb.toString();
	}

}
