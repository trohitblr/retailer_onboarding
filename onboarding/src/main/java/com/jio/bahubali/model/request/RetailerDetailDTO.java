package com.jio.bahubali.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetailerDetailDTO {
  private String retailerPrmId;
  private String retailerName;
  private String retailerAddress;
  private String retailerPlace;
  private String retailerMob;
  private String retailerGstin;
  private String storeName;
}
