package com.jio.bahubali.model.request.shipment;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentConfigurationData {

  private String fieldToRefer;
  private String uniquekey;
  private String transportType;
  private List<String> transportModes;
  private String carrierCode;
  private List<String> supportedCarriers;
  private String deliveryDate;
  private String deliveryDateFormat;
  private Map<String, ProductTypeConfiguration> productTypeConfiguration;
  private String siocFlag;
  private List<String> supportedProductTypes;
}
