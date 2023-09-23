package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.entity.jpa.Product;
import com.jio.bahubali.model.request.ProductRequest;
import reactor.core.publisher.Mono;

public interface ProductService {

  Mono<Product> saveOrderProducts(Mono<Order> order, ProductRequest productRequest);
}
