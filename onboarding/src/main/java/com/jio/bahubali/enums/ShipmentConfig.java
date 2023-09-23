package com.jio.bahubali.enums;

/*
 * Each shipment config should have Shipment Decorator Factory entry.
 * */
public enum ShipmentConfig {
  MODE_OF_TRANSPORT("MT"),
  CARRIER_CODE("CC"),
  DELIVERY_DATE("DD"),
  NO_OF_PRODUCTS_LIMIT("NP"),
  PRODUCT_TYPE("PT"),
  SIOC_FLAG("SIOC");

  String uniqueID;

  ShipmentConfig(String uniqueID) {
    this.uniqueID = uniqueID;
  }

  public static ShipmentConfig fromString(String enumName) {
    for (ShipmentConfig enumValue : ShipmentConfig.values()) {
      if (enumValue.name().equalsIgnoreCase(enumName)) {
        return enumValue;
      }
    }
    throw new IllegalArgumentException(
        "No enum constant " + enumName + " found in ShipmentConfigEnums");
  }

  public String getUniqueID() {
    return uniqueID;
  }
}
