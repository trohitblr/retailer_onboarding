package com.jio.bahubali.model.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailResponseDTO {
  private String orderId;
  private RetailerDetailDTO sellersInfo;

  private RetailerDetailDTO buyersInfo;
}
