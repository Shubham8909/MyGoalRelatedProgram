package com.leaderco.challenge.emi.stratgy;

import org.springframework.stereotype.Component;

import com.leaderco.challenge.model.EMI;
import com.leaderco.challenge.model.Loan;
import com.leaderco.challenge.utils.EMIUtils;


@Component
public class EMIStrategyDefaultImpl implements EMIStrategy {
 
	public static final int EMI_PERIOD=1; //taking 1 months wise 
	
	@Override
	public EMI calaculateEMI(Loan loan) {
		
		long totalEMIAmount= EMIUtils.calculateTotalAmount(loan.getLoanAmount(),loan.getLoanRateIntrest(),loan.getLoanYear());
		int totalNoOfEMI= EMIUtils.totalNumberOfEMI(EMI_PERIOD,loan.getLoanYear());
		long singleEMIAmount= EMIUtils.singleEMIAmountCal(totalNoOfEMI,totalEMIAmount);
		return new EMI(totalEMIAmount, totalEMIAmount, 0, totalNoOfEMI,singleEMIAmount,totalNoOfEMI, 0,0);
	}

}
