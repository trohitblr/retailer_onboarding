package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.entity.jpa.Product;
import com.jio.bahubali.model.request.DmsEditOrderItemInfo;
import java.util.List;
import reactor.core.publisher.Mono;

public interface ProductReturnService {

  Mono<Order> createProductReturn(
      List<DmsEditOrderItemInfo> dmsEditOrderItemInfoList,
      Order order,
      Mono<List<Product>> productsListBeforeEdit);
}
