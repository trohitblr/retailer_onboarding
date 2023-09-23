package com.jio.bahubali.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RetailerAccountInfo {

  @Id
  @Column("prmId")
  private String prmId;

  @Column("account_number")
  private String accountNumber;

  @Column("virtual_account")
  private String virtualAccount;

  @Column("vertical")
  private String vertical;

  @Column("credit_limit")
  private String creditLimit;

  @Column("curr_account_balance")
  private String currAccountBalance;

  @Column("credit_balance")
  private String creditBalance;

  @Column("total_balance")
  private String totalBalance;
}
