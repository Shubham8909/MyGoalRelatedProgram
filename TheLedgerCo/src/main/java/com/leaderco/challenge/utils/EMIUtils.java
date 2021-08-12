package com.leaderco.challenge.utils;

import com.leaderco.challenge.model.EMI;

public interface EMIUtils {

	static long calculateTotalAmount(long p, int r, int y) {
		long I = (p * r * y) / 100;
		long A = I + p;
		return (long) Math.ceil(A);
	}

	static int totalNumberOfEMI(int emiPeriod, int Y) {
		int toalMonths = emiPeriod * Y * 12;
		return toalMonths;
	}

	static long singleEMIAmountCal(int totalNoOfEMI, long totalEMIAmount) {
		double amount = (double) totalEMIAmount / totalNoOfEMI;
		return (long) Math.ceil(amount);
	}

	static long getAmountByEMINo(String eMINo, long singleEMIAmount) {
		long amount = singleEMIAmount * Integer.parseInt(eMINo);
		return amount;
	}

	static EMI updateEMIDeatils(EMI emi, String paidAmount) {
		long paidCeilAmount = (long) Math.ceil(Double.parseDouble(paidAmount));
		long remainingAmount = emi.getRemainingEMIAmount();
		// long singleEmIAmount= emi.getSingleEMIAmount();
		if (paidCeilAmount >= remainingAmount) {
			emi.setReturnToBorrower(paidCeilAmount - remainingAmount);
			emi.setRemainingEMIAmount(0);
			emi.setPaidEMIAmount(emi.getTotalEMIAmount());
			emi.setPaidNoOfEMI(emi.getTotalNoOfEMI());
			emi.setRemainingNoOfEMI(0);
			return emi;
		}
		emi.setRemainingEMIAmount(emi.getRemainingEMIAmount() - paidCeilAmount);
		emi.setPaidEMIAmount(emi.getPaidEMIAmount() + paidCeilAmount);
		int noOfEMICompleted = (int) Math.floor(paidCeilAmount / emi.getSingleEMIAmount());
		emi.setPaidNoOfEMI(emi.getPaidNoOfEMI() + noOfEMICompleted);
		emi.setRemainingNoOfEMI(emi.getRemainingNoOfEMI() - noOfEMICompleted);
		validateAndUpdatePaidAmountWithPaidEMINo(emi);
		return emi;
	}

	static void validateAndUpdatePaidAmountWithPaidEMINo(EMI emi) {
		long singleEMIAmount = emi.getSingleEMIAmount();
		long totalPaidAmount = emi.getPaidEMIAmount();
		int noOfEMIViaTotalPaidAmount = (int) Math.floor(totalPaidAmount / singleEMIAmount);
		if (noOfEMIViaTotalPaidAmount > emi.getPaidNoOfEMI()) {
			emi.setPaidNoOfEMI(noOfEMIViaTotalPaidAmount);
			emi.setRemainingNoOfEMI(emi.getTotalNoOfEMI() - noOfEMIViaTotalPaidAmount);
		}
	}

	static int calculateEMINoOnTheBasisOfPreviousPayment(double emiAmountForGivenEMINo, double totalEMIAmount,
			double singleEMIAmount) {
		double remainingAmount = totalEMIAmount - emiAmountForGivenEMINo;
		double ceilValueOfEemainingEMINo = Math.ceil(remainingAmount / singleEMIAmount);
		return (int) ceilValueOfEemainingEMINo;
	}

}
