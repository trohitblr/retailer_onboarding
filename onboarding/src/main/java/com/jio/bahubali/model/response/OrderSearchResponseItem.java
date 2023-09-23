package com.jio.bahubali.model.response;

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
public class OrderSearchResponseItem {

  OrderInfo order;

  CustomerInfo customer;

  List<ShipmentInfo> shipments;
}
