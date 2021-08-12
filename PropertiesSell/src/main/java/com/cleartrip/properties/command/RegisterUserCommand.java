package com.cleartrip.properties.command;

import com.cleartrip.properties.model.Command;
import com.cleartrip.properties.service.UserRegisterService;

public class RegisterUserCommand extends CommandExecutors{

	
	public static final String USER_REGISTER = "USER_REGISTER";
	
	private UserRegisterService userRegisterService;
	
	public RegisterUserCommand(UserRegisterService userRegisterService) {
		super();
		this.userRegisterService = userRegisterService;
	}

	@Override
	public boolean isAcceptable(Command command) {
		if (command.getCommadName().equalsIgnoreCase(USER_REGISTER))
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
		return userRegisterService.userregister(userName);
				
	}

}
