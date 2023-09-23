package com.jio.bahubali.service;

import com.jio.bahubali.model.request.OrderItemProductDTO;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Mono;

public interface ShipmentService {
  Mono<Map<String, List<OrderItemProductDTO>>> createShipment(String orderId)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException,
          NoSuchMethodException, InvocationTargetException;
}
