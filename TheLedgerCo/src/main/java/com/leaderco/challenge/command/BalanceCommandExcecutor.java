package com.leaderco.challenge.command;
import org.springframework.stereotype.Component;

import com.leaderco.challenge.exceptions.BankNameNotPresentException;
import com.leaderco.challenge.exceptions.BorrowerIsNotFoundException;
import com.leaderco.challenge.model.Command;
import com.leaderco.challenge.service.CommanService;

@Component("balCommand")
public class BalanceCommandExcecutor extends CommandExecutors {

	public static final String BAL_COMMAND = "BALANCE";

	private CommanService commanService;
	public BalanceCommandExcecutor(CommanService commanService) {
		super();
		this.commanService = commanService;
	}

	@Override
	public boolean isAcceptable(Command command) {
		if (command.getCommadName().equalsIgnoreCase(BAL_COMMAND))
			return true;
		
		return false;
	}
	
	@Override
	public boolean isValid(Command command) {
		if(command.getParams().size()==3) return true;
		return false;
	}
	
	@Override
	public String executeValidCommand(Command command) {
		String bankName= command.getParams().get(0);
		String borrowerName= command.getParams().get(1);
		String EMINo= command.getParams().get(2);
		String balanceInfo=null;
		try {
			balanceInfo = commanService.getBalanceDetails(bankName,borrowerName,EMINo);
		} catch (BankNameNotPresentException e) {
			balanceInfo=e.getMessage();
		} catch (BorrowerIsNotFoundException e) {
			balanceInfo=e.getMessage();
		}
		return balanceInfo;
	}

}
