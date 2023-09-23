/*
package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jio.bahubali.enums.ModifyAction;
import com.jio.bahubali.enums.OrderApprovalStatus;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DMSEditOrderRequest {

  @NotNull private String orderId;

  @NotNull private Float grossTotal;

  @NotNull private String status;

  private String actionReason;

  private OrderApprovalStatus approvalStatus;

  private ModifyAction action = ModifyAction.MODIFIED;

  private String approvesId;

  private String fosId;

  private String beatId;

  private Float totalOrderDiscount;

  private String buyerStoreId;

  @NotNull private Float finalOrderAmount;

  private String createdAt;

  @Valid @NotNull private List<DmsEditOrderItemInfo> orderItems;
}
*/
