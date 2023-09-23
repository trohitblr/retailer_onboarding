package com.jio.bahubali.model.request.shipment;

import com.jio.bahubali.enums.ShipmentConfig;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
  private Map<ShipmentConfig, Boolean> configurations;
  private Map<ShipmentConfig, ShipmentConfigurationData> shipmentConfigurations;
}
