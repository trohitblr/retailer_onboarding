package com.jio.bahubali.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetailerAccountInfo {

  private String prmId;

  private String accountNumber;

  private String virtualAccount;

  private String vertical;

  private String creditLimit;

  private String currAccountBalance;

  private String creditBalance;

  private String totalBalance;
}
