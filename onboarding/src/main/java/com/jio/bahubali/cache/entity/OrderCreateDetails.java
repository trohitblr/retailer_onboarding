package com.jio.bahubali.cache.entity;

import com.jio.bahubali.enums.OrderRequestState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "order-create-detail")
public class OrderCreateDetails {

  private String channelOrderId;

  private OrderRequestState requestState;
}
