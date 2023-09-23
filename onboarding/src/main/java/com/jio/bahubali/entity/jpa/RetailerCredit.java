package com.jio.bahubali.entity.jpa;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "retailer_credit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RetailerCredit extends BaseEntity {
  @Id private UUID id;

  @Column("account_number")
  private String accountNumber;

  @Column("virtual_account")
  private String virtualAccount;

  @Column("credit_limit")
  private Float creditLimit;

  @Column("curr_account_balance")
  private Float currAccountBalance;

  @Column("vertical")
  private String vertical;

  @Column("credit_balance")
  private Float creditBalance;

  @Column("total_balance")
  private Float totalBalance;

  public static class OrderInvoiceResponse {}
}
