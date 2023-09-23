package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.entity.jpa.PaymentMethod;
import com.jio.bahubali.model.request.OrderRequest;
import java.util.List;
import reactor.core.publisher.Mono;

public interface PaymentMethodService {

  void addPaymentMethod(PaymentMethod paymentMethod);

  Mono<List<PaymentMethod>> saveAll(Mono<Order> order, OrderRequest orderCreateRequest);
}
