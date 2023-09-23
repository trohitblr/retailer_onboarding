package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.entity.jpa.OrderItems;
import com.jio.bahubali.entity.jpa.ProductMeta;
import com.jio.bahubali.model.request.OrderRequest;
import java.util.List;
import reactor.core.publisher.Mono;

public interface OrderItemService {

  void saveAll(List<OrderItems> orderItemsList);

  Mono<List<ProductMeta>> saveProductItems(Mono<Order> orderMono, OrderRequest orderCreateRequest);

  Mono<List<ProductMeta>> saveOrderItems(Mono<Order> orderMono, OrderRequest orderCreateRequest);
}
