package com.jio.bahubali.model.response;

import com.jio.bahubali.enums.OrderApprovalStatus;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DmsOrderInfoResponse {

  private String orderId;

  private BigDecimal grossTotal;

  private BigDecimal totalProductSavings;

  private String status;

  private OrderApprovalStatus approvalStatus;

  private String approvesId;

  private String fosId;

  private String beatId;

  private BigDecimal totalOrderDiscount;

  private BigDecimal finalOrderAmount;

  private String buyerStoreId;

  private String buyerPrmId;

  private String sellerPrmId;

  private String createdAt;

  private String parentOrderId;

  private String returnExpire;

  private List<DmsOrderItemInfo> orderItems;
}
