package com.leaderco.challenge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.leaderco.challenge.exceptions.BankNameNotPresentException;
import com.leaderco.challenge.exceptions.BorrowerIsNotFoundException;
import com.leaderco.challenge.exceptions.EMICompletedException;
import com.leaderco.challenge.exceptions.ExceedEMINumberException;
import com.leaderco.challenge.model.Bank;
import com.leaderco.challenge.model.Borrower;
import com.leaderco.challenge.model.EMI;
import com.leaderco.challenge.model.Payment;
import com.leaderco.challenge.utils.CommanUtils;
import com.leaderco.challenge.utils.EMIUtils;

@Service
public class CommanService {
	
	   static Map<String, List<String>> bankBorrowerMap= new HashMap<>();
	   static Map<String, Borrower>  borrowerMap= new HashMap<>();
	   
	   public void addBorrowerToBankWithLoanDetails(Bank bank,Borrower borrwer) {
		   if(bankBorrowerMap.containsKey(bank.getBankName())) {
			  List<String> list= bankBorrowerMap.get(bank.getBankName());
			  list.add(borrwer.getBorrowerName());
			  bankBorrowerMap.put(bank.getBankName(),list);
		   }else {
			   List<String> list= new ArrayList<>();
			   list.add(borrwer.getBorrowerName());
			   bankBorrowerMap.put(bank.getBankName(),list);
		   }
		   
		   if(!borrowerMap.containsKey(borrwer.getBorrowerName())) {
			   borrowerMap.put(borrwer.getBorrowerName(), borrwer);
		   }
		   
		   
	   }

	public String getBalanceDetails(String bankName, String borrowerName, String eMINo) throws BankNameNotPresentException, BorrowerIsNotFoundException {
		if(!bankBorrowerMap.containsKey(bankName)) {
			throw new BankNameNotPresentException("Bank Not Present !");
		}
		List<String> listOfBorrower=  bankBorrowerMap.get(bankName);
		if(!listOfBorrower.contains(borrowerName) || !borrowerMap.containsKey(borrowerName) ) {
			throw new BorrowerIsNotFoundException("Borrower Not Found");
		}
		Borrower borwr=borrowerMap.get(borrowerName);
		EMI emi=borwr.getEMIDetails();
		long emiAmountForGivenEMINo=EMIUtils.getAmountByEMINo(eMINo,emi.getSingleEMIAmount());
		long previousAmountSum =borwr.getListOfPayment().stream().filter(p->p.getEmiNo()<=Integer.parseInt(eMINo)).
				mapToLong(a->a.getPaidAmount()).sum();
		
		int outputEMINoCount=0;
		if(previousAmountSum!=0) {
			emiAmountForGivenEMINo=emiAmountForGivenEMINo+previousAmountSum;
			outputEMINoCount=EMIUtils.calculateEMINoOnTheBasisOfPreviousPayment(emiAmountForGivenEMINo,emi.getTotalEMIAmount(),emi.getSingleEMIAmount());
		}else
		outputEMINoCount= emi.getTotalNoOfEMI()-Integer.parseInt(eMINo);
		
	    String balDetails= CommanUtils.commanRespnseOfEMI(bankName,borrowerName,emiAmountForGivenEMINo,outputEMINoCount);
		return balDetails;
	}

	public void receivedpayment(String bankName, String borrowerName, String paidAmount, int eMIno) throws BankNameNotPresentException, BorrowerIsNotFoundException, EMICompletedException, ExceedEMINumberException {
		if(!bankBorrowerMap.containsKey(bankName)) {
			throw new BankNameNotPresentException("Bank Not Present !");
		}
		List<String> listOfBorrower=  bankBorrowerMap.get(bankName);
		if(!listOfBorrower.contains(borrowerName) || !borrowerMap.containsKey(borrowerName) ) {
			throw new BorrowerIsNotFoundException("Borrower Not Found");
		}
		Borrower borwr=borrowerMap.get(borrowerName);
		EMI emi=borwr.getEMIDetails();
		int totalEmINumber=emi.getTotalNoOfEMI();
		
		if(emi.getRemainingNoOfEMI()<=0) {
			throw new EMICompletedException("EMI Already Completed !");
		}
		if(eMIno>totalEmINumber) {
			throw new ExceedEMINumberException("Given EMINo Can not we greater then totalEmINumber.");
		}
		Payment payment=CommanUtils.getPaymentDetails(paidAmount,eMIno,borrowerName);
		borwr.getListOfPayment().add(payment);
	
		EMI updateEMIDetails =EMIUtils.updateEMIDeatils(emi,paidAmount);
		borwr.setEMIDetails(updateEMIDetails);
		borrowerMap.put(borrowerName, borwr);
	}
	
    
	
}
