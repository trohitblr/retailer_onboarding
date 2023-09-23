package com.jio.bahubali.model.response;

import com.jio.bahubali.enums.ProductDistributionType;
import com.jio.bahubali.enums.ProductStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class DmsOrderItemInfo {
  private String orderItemId;

  private String sku;

  private String description;

  private String unitMrp;

  private String discountedPrice;

  private String imageUrl;

  private String quantity;

  private String processedUnitPrice;

  private String itemId;

  private String itemSize;

  private String ladderPriceTag;

  private String priceTag;

  private ProductDistributionType productDistributionType;

  private ProductStatus productStatus;
}
