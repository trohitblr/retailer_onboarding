package com.jio.bahubali.model.response;

import com.jio.bahubali.enums.PaymentMethodType;
import com.jio.bahubali.enums.ShipmentStatus;
import java.util.List;
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
public class ShipmentInfo {

  String shipmentId;
  String orderId;
  String creationDate;
  ShipmentStatus shipmentStatus;
  String deliveryDate;

  Float invoiceAmount;
  Float totalAmount;

  String transactionId;
  String transactionDate;
  PaymentMethodType paymentMode;

  String storeId;
  String carrierName;
  String posNo;

  List<ShipmentArticleInfo> shipmentArticles;
}
