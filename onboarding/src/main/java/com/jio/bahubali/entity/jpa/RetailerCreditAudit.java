package com.jio.bahubali.entity.jpa;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "retailer_credit_audit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RetailerCreditAudit extends BaseEntity {

  @Id private UUID id;

  @Column("prm_id")
  private String prmId;

  @Column("curr_account_balance")
  private Float currAccountBalance;

  @Column("credit_balance")
  private Float creditBalance;

  @Column("total_balance")
  private Float totalBalance;

  @Column("vertical")
  private String vertical;

  @Column("account_number")
  private String accountNumber;
}
