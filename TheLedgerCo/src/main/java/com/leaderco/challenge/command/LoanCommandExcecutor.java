package com.leaderco.challenge.command;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.leaderco.challenge.emi.stratgy.EMIStrategy;
import com.leaderco.challenge.model.Bank;
import com.leaderco.challenge.model.Borrower;
import com.leaderco.challenge.model.Command;
import com.leaderco.challenge.model.EMI;
import com.leaderco.challenge.model.Loan;
import com.leaderco.challenge.service.CommanService;

@Component("loanCommand")
public class LoanCommandExcecutor extends CommandExecutors {

	public static final String LOAN_COMMAND = "LOAN";
	
	private EMIStrategy eMIStrategy;
	private CommanService commanService;
	
	public LoanCommandExcecutor(EMIStrategy eMIStrategy, CommanService commanService) {
		super();
		this.eMIStrategy = eMIStrategy;
		this.commanService = commanService;
	}

	@Override
	public boolean isAcceptable(Command command) {
		if (command.getCommadName().equalsIgnoreCase(LOAN_COMMAND))
			return true;
		
		return false;
	}
	
	@Override
	public boolean isValid(Command command) {
		if(command.getParams().size()==5) return true;
		return false;
	}
	@Override
	public String executeValidCommand(Command command) {
			String bankName=command.getParams().get(0);
			Bank bank=new Bank(bankName);
			String borrowerName= command.getParams().get(1);
			String P= command.getParams().get(2);
			String Y= command.getParams().get(3);
			String R= command.getParams().get(4);
			String  loadId= UUID.randomUUID().toString();
			Loan loan= new Loan(loadId, borrowerName, Long.parseLong(P), Integer.parseInt(Y),Integer.parseInt(R));
			EMI emi=eMIStrategy.calaculateEMI(loan);
			Borrower borwr=new Borrower(borrowerName, loan, emi);
			commanService.addBorrowerToBankWithLoanDetails(bank, borwr);
			return "";
	}

}
