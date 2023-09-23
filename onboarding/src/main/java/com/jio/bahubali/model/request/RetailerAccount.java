package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jio.bahubali.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetailerAccount {
  private String accountNumber;
  private String bankName;
  private String branchName;
  private String ifsc;
  private String virtual_account;
  private String vertical;
  private String creditLimit;
  private String prmId;
  private AccountStatus accountStatus;
}
