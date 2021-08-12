package com.leaderco.challenge.utils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.ArrayUtils;

import com.leaderco.challenge.model.Command;
import com.leaderco.challenge.model.Payment;

public interface CommanUtils {

	static String commanRespnseOfEMI(String bankName, String borrowerName, long emiAmountForGivenEMINo,
			int outputEMINoCount) {
		StringBuilder sb = new StringBuilder();
		sb.append(bankName).append(" ").append(borrowerName).
		append(" ").append(emiAmountForGivenEMINo).append(" ").append(outputEMINoCount);
		return sb.toString();
	}

	static Command createCommand(String commad) {
		String values[]=commad.split(" ");
		String commandNmae= values[0];
		values=ArrayUtils.remove(values, 0);
		List<String> params=Arrays.asList(values);
		return new Command(commandNmae, params);
	}

	static Payment getPaymentDetails(String paidAmount, int eMIno, String borrowerName) {
		String paymentId=UUID.randomUUID().toString();
		long amountCeil=(long)Math.ceil(Double.parseDouble(paidAmount));
		return new Payment(borrowerName, paymentId, amountCeil, eMIno);
	}

}
