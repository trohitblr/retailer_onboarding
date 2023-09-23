package com.jio.bahubali.entity.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("payment_method")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod extends BaseEntity {
  @Id private UUID id;

  @Column("order_id")
  private String orderId;

  @Column("payment_id")
  private String paymentId;

  @Column("payment_desc")
  private String paymentDesc;

  @Column("payment_amt")
  private BigDecimal paymentAmt;

  @Column("payment_card")
  private String paymentCard;

  @Column("order_inv_num")
  private String orderInvNum;

  @Column("order_app_code")
  private String orderAppCode;

  @Column("bd_customer_id")
  private String bdcustomerId;

  @Column("transaction_ref_number")
  private String transactionRefNumber;

  @Column("txn_date")
  private LocalDateTime txnDate;
}
