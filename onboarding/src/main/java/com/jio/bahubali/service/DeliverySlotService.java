package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.DeliverySlot;
import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.entity.jpa.Product;
import com.jio.bahubali.model.request.DeliverySlotRequest;
import reactor.core.publisher.Mono;

public interface DeliverySlotService {

  void addDeliverySlot(DeliverySlot deliverySlot);

  Mono<DeliverySlot> saveDeliverySlotOrderDetails(
      Mono<Order> order, Mono<Product> product, DeliverySlotRequest deliverySlotRequest);
}
