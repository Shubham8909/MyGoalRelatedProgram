package com.leaderco.challenge.command;

import com.leaderco.challenge.exceptions.BankNameNotPresentException;
import com.leaderco.challenge.exceptions.BorrowerIsNotFoundException;
import com.leaderco.challenge.exceptions.EMICompletedException;
import com.leaderco.challenge.exceptions.ExceedEMINumberException;
import com.leaderco.challenge.model.Command;
import com.leaderco.challenge.service.CommanService;

public class PaymentCommandExecutor extends CommandExecutors {
 
	
	public static final String PAYMENT_COMMAND = "PAYMENT";
	
	private CommanService commanService;
	public PaymentCommandExecutor(CommanService commanService) {
		super();
		this.commanService = commanService;
	}

	@Override
	public boolean isAcceptable(Command command) {
		if (command.getCommadName().equalsIgnoreCase(PAYMENT_COMMAND))
			return true;
		
		return false;
	}
	
	@Override
	public boolean isValid(Command command) {
		if(command.getParams().size()==4) return true;
		return false;
	}
    
	//PAYMENT IDIDI Dale 1000 5
	@Override
	public String executeValidCommand(Command command) {
		String bankName= command.getParams().get(0);
		String borrowerName= command.getParams().get(1);
		String paidAmount= command.getParams().get(2);
		String EMIno=command.getParams().get(3);
		try {
			commanService.receivedpayment(bankName,borrowerName,paidAmount,Integer.parseInt(EMIno));
		} catch (NumberFormatException | BankNameNotPresentException | BorrowerIsNotFoundException
				| EMICompletedException | ExceedEMINumberException e) {
			return e.getMessage();
		}
		return "";
	}
}
