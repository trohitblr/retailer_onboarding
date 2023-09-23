package com.jio.bahubali.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jio.bahubali.enums.AccountStatus;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
public class RetailerAccount extends BaseEntity {

  @Id private UUID id;

  @Column("prm_id")
  private String prmId;

  @Column("account_number")
  private String accountNumber;

  @Column("bank_name")
  private String bankName;

  @Column("ifsc")
  private String ifsc;

  @Column("virtual_account")
  private String virtual_account;

  @Column("vertical")
  private String vertical;

  @Column("credit_limit")
  private String creditLimit;

  @Column("branch_name")
  private String branchName;

  @Column("account_status")
  private AccountStatus accountStatus;
}
