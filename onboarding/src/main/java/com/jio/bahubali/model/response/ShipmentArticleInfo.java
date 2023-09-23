package com.jio.bahubali.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShipmentArticleInfo {

  String articleId;

  String description;

  Integer quantity;

  Float maximumRetailPrice;

  Float offerPrice;

  String storeId;

  String carrierName;
}
