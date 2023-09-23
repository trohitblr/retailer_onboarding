package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Address;
import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.enums.AddressDetailsType;
import com.jio.bahubali.model.request.OrderRequest;
import java.util.List;
import reactor.core.publisher.Mono;

public interface AddressService {

  void addAddress(Address address);

  void saveAllAddress(List<Address> addressList);

  Mono<Address> saveOrderAddressDetails(
      Mono<Order> order, OrderRequest orderRequest, AddressDetailsType addressDetailsType);
}
