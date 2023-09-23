package com.jio.bahubali.service;

import com.jio.bahubali.enums.OrderRequestState;
import com.jio.bahubali.model.request.OrderRequest;
import reactor.core.publisher.Mono;

public interface OrderRequestService {
  Mono<String> pushOrderToCreateQueue(OrderRequest orderRequest);

  Mono<Boolean> updateOrderCacheEntity(String orderId, OrderRequestState status);

  public String testKafka(String testMessage);
}
