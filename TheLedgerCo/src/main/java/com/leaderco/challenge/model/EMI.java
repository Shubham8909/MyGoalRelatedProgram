package com.leaderco.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class EMI {
  private long totalEMIAmount;
  @Setter private long remainingEMIAmount;
  @Setter private long paidEMIAmount;
  private int totalNoOfEMI;
  private long singleEMIAmount;
  @Setter private long remainingNoOfEMI;
  @Setter private long paidNoOfEMI;
  @Setter private long returnToBorrower;

}
