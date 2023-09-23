package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Customer;
import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.model.request.OrderRequest;
import reactor.core.publisher.Mono;

public interface CustomerService {

  void addCustomer(Customer customer);

  Mono<Customer> saveCustomerOrderDetails(Mono<Order> order, OrderRequest orderRequest);
}
