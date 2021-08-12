package com.cleartrip.properties.command;

import com.cleartrip.properties.model.Command;

public abstract class CommandExecutors {
	
	public String execute(Command command) {
		if(!isValid(command)) {
			return "Its Invalid Command";
		}
		return executeValidCommand(command);
	}
	public  abstract  boolean isAcceptable(Command command);
	public  abstract  boolean isValid(Command command);
	public  abstract  String executeValidCommand(Command command);

}
