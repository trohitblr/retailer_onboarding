package com.jio.bahubali.model.request;

import com.jio.bahubali.enums.OrderApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DmsInvoiceResponse {

  private String orderId;

  private String sellerPrmId;

  private String buyerPrmId;

  private OrderApprovalStatus orderApprovalStatus;
}
