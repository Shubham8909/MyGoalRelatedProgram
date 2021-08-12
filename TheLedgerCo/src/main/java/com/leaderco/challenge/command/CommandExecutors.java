package com.leaderco.challenge.command;

import com.leaderco.challenge.model.Command;

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
