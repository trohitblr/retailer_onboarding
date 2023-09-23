package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetailerOnboard {
  private String prmId;
  private String name;
  private String storeName;
  private String mobile;
  private String addressFirstLine;
  private String addressSecondLine;
  private String addressCity;
  private String addressState;
  private String addressPinCode;
  private String channelType;
  private String gstin;
  private String type;
  private String loyaltyTier;
}
