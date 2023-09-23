package com.jio.bahubali.service;

import com.jio.bahubali.entity.jpa.Product;
import com.jio.bahubali.enums.ChannelType;

public interface CreateShipmentService {
  String createShipment(String orderId, ChannelType channelType, Product product);
}
