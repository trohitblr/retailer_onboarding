package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodRequest implements Serializable {

  @JsonProperty("payment_id")
  private String paymentId;

  @JsonProperty("payment_desc")
  private String paymentDesc;

  @JsonProperty("payment_amt")
  private BigDecimal paymentAmt;

  @JsonProperty("payment_card")
  private String paymentCard;

  @JsonProperty("order_inv_num")
  private String orderInvNum;

  @JsonProperty("order_app_code")
  private String orderAppCode;

  @JsonProperty("bdcustomer_id")
  private String bdcustomerId;

  @JsonProperty("transaction_ref_number")
  private String transactionRefNumber;

  @JsonProperty("txn_date")
  private String txnDate;
}
