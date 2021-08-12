package com.leaderco.challenge.emi.stratgy;

import com.leaderco.challenge.model.EMI;
import com.leaderco.challenge.model.Loan;

public interface EMIStrategy {
	
	public abstract EMI calaculateEMI(Loan loan);

}
