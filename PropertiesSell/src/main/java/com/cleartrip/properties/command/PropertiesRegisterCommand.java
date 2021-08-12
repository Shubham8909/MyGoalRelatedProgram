package com.cleartrip.properties.command;

import com.cleartrip.properties.model.Command;
import com.cleartrip.properties.model.Property;
import com.cleartrip.properties.service.PropertiesRegisterService;

public class PropertiesRegisterCommand extends CommandExecutors {
	
	public static final String PROP_REGISTER = "PROP_REGISTER";
	
    static int propId=1;
	
	private PropertiesRegisterService propertiesRegisterService;
	
    
	public PropertiesRegisterCommand(PropertiesRegisterService propertiesRegisterService) {
		super();
		this.propertiesRegisterService = propertiesRegisterService;
	}

	@Override
	public boolean isAcceptable(Command command) {
		if (command.getCommadName().equalsIgnoreCase(PROP_REGISTER))
			return true;
		return false;
	}

	@Override
	public boolean isValid(Command command) {
		if(command.getParams().size()==7) return true;
		return false;
	}

	@Override
	public String executeValidCommand(Command command) {
		
		String userName= command.getParams().get(0);
		String propertyName= command.getParams().get(1);
		String location= command.getParams().get(2);
		int price= Integer.parseInt(command.getParams().get(3));
		String type= command.getParams().get(4);
		String size= command.getParams().get(5);
		int numberOfRooms= Integer.parseInt(command.getParams().get(6));
		Property prp= new Property(propId,userName, propertyName, location, price, type, size, numberOfRooms);
		propId++;
		return propertiesRegisterService.RegisterProperties(prp);
	}

}
