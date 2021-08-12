package com.cleartrip.properties.command;

import java.util.List;
import java.util.Map;

import com.cleartrip.properties.model.Command;
import com.cleartrip.properties.model.Property;

public class ViewShortListedCommand extends CommandExecutors{

	
	public static final String VIEW_SHORTLIST = "VIEW_SHORTLIST";
	
	private ShortListPropertyCommand shortListPropertyCommand;
	
	public ViewShortListedCommand(ShortListPropertyCommand shortListPropertyCommand) {
		super();
		this.shortListPropertyCommand = shortListPropertyCommand;
	}

	@Override
	public boolean isAcceptable(Command command) {
		if (command.getCommadName().equalsIgnoreCase(VIEW_SHORTLIST))
			return true;
		
		return false;
	}

	@Override
	public boolean isValid(Command command) {
		if(command.getParams().size()==1) return true;
		return false;
	}

	@Override
	public String executeValidCommand(Command command) {
		String userName= command.getParams().get(0);
		Map<String, List<Property>> map=shortListPropertyCommand.shortMap;
		List<Property> viewProperties=null;
		for(Map.Entry<String, List<Property>> usersProperties :map.entrySet()) {
			if(usersProperties.getKey().equalsIgnoreCase(userName)) {
				viewProperties =usersProperties.getValue();
				 break;
			}
		}
		StringBuilder sb = new StringBuilder();
		if(viewProperties!=null) {
			for(Property por:viewProperties) {
			sb.append("id ").append("Title ").append("Location ").append("Price ").append("Size ").append(" Rooms ").append(" AvailableFor ").append(" status ")
			.append("\n").append(por.getId()+" ").append(por.getPropertyName()+" ").append(por.getLocation()+" ").
			  append(por.getPrice()+" ").append(por.getSize()+" ").append(por.getNumberOfRoom()+"BHK ").append(por.getType()+" ").append(por.getStatus().toString()+" ");
			}
		}
		return sb.toString();
				
	}


}
