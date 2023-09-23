package com.jio.bahubali.utils;

import com.jio.bahubali.enums.ChannelType;
import com.jio.bahubali.enums.FulfillmentVertical;
import com.jio.bahubali.enums.ShipmentConfig;

public class CacheUtils {

  public static final String KEY_PREFIX = "_";
  public static final String SHIPMENT_CONFIG = "ORDER_CONFIG_SHIPMENT_CONFIG_";

  // Get shipment config Data
  public static String getShipmentConfigCreationCheckKey(
      FulfillmentVertical vertical, ChannelType channelType) {
    // Key = ELECTRONICS_ASP_SHIPMENT_CONFIG_ORDER_SHIPMENT_CREATION
    StringBuilder key = new StringBuilder();
    key.append(vertical.name());
    key.append(KEY_PREFIX);
    key.append(channelType.name());
    key.append(KEY_PREFIX);
    key.append(SHIPMENT_CONFIG);
    key.append("ORDER_SHIPMENT_CREATION");
    return key.toString().toUpperCase();
  }

  /* Get shipment config Data
   * Key =  ELECTRONICS_ASP_SHIPMENT_CONFIG_SHIPMENT_CONFIGURATIONS_{}
   */
  public static String getShipmentConfigurationDataKey(
      FulfillmentVertical vertical, ChannelType channelType, ShipmentConfig shipmentConfig) {
    StringBuilder key = new StringBuilder();
    if (null != vertical) {
      key.append(vertical.name());
      key.append(KEY_PREFIX);
    }
    if (null != channelType) {
      key.append(channelType.name());
      key.append(KEY_PREFIX);
    }
    key.append(SHIPMENT_CONFIG);
    key.append("SHIPMENT_CONFIGURATIONS");
    if (null != shipmentConfig) {
      key.append(KEY_PREFIX);
      key.append(shipmentConfig.name());
    }
    return key.toString().toUpperCase();
  }

  /* Key =  ELECTRONICS_ASP_SHIPMENT_CONFIG_SHIPMENT_CONFIGURATIONS_{}
   *
   */
  public static String getShipmentConfigStatusKey(
      FulfillmentVertical vertical, ChannelType channelType) {
    StringBuilder key = new StringBuilder();
    if (null != vertical) {
      key.append(vertical.name());
      key.append(KEY_PREFIX);
    }
    if (null != channelType) {
      key.append(channelType.name());
      key.append(KEY_PREFIX);
    }
    key.append(SHIPMENT_CONFIG);
    key.append("CONFIG_STATUS");
    return key.toString().toUpperCase();
  }
}
