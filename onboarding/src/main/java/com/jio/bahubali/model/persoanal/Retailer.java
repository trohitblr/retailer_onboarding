package com.jio.bahubali.model.persoanal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Retailer {
  private String retailerId;
  private String ownerName;
  private String storeName;
  private String retailerMob;
  private boolean mobVerified;
  private boolean retailerVerified;
  private boolean isParent;
  private String parent;
  private String fosId;
  private RetailerMeta retailerMeta;

  private RetailerAddress retailerAddress;
}
