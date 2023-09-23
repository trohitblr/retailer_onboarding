package com.jio.bahubali.model.request;

import com.jio.bahubali.enums.OrderApprovalStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderApproveRequest {

  @NotNull(message = "Invalid orderId ")
  String orderId;

  @NotNull(message = "Invalid approvesId")
  String approvesId;

  @NotNull(message = "Invalid status")
  OrderApprovalStatus orderApprovalStatus;

  String comment;
}
