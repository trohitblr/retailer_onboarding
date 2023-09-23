package com.jio.bahubali.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jio.bahubali.enums.ProductDistributionType;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductMetaRequest {
  @JsonProperty("is_hazmat")
  private boolean isHazmat;

  @JsonProperty("is_liquid")
  private boolean isLiquid;

  @JsonProperty("is_fragile")
  private boolean isFragile;

  @JsonProperty("delivery_type")
  private String deliveryType;

  @JsonProperty("transport_mode")
  private String transportMode;

  @JsonProperty("assign_container")
  private boolean assignContainer;

  @JsonProperty("lookup_inventory")
  private boolean lookupInventory;

  @JsonProperty("procurement_date")
  private String procurementDate;

  @JsonProperty("assign_dp_from_sb")
  private boolean assignDpFromSb;

  @JsonProperty("available_at_3p_kirana")
  private boolean availableAt3pKirana;

  @JsonProperty("item_size")
  private String itemSize;

  @JsonProperty("item_id")
  private String itemId;

  @JsonProperty("cgst")
  private BigDecimal cgst;

  @JsonProperty("sgst")
  private BigDecimal sgst;

  @JsonProperty("ladder_price_tag")
  private String ladderPriceTag;

  @JsonProperty("price_tag")
  private String priceTag;

  @JsonProperty("cess")
  private BigDecimal cess;

  @JsonProperty("hsn")
  private String hsn;

  @JsonProperty("product_distribution_type")
  private ProductDistributionType productDistributionType = ProductDistributionType.DEFAULT;

  @JsonProperty("igst")
  private BigDecimal igst;

  @JsonProperty("scheme_discount")
  private BigDecimal schemeDiscount;

  @JsonProperty("margin")
  private BigDecimal margin;
}
