package com.jio.bahubali.cache.entity;

import com.jio.bahubali.enums.OrderRequestState;
import com.jio.bahubali.model.request.OrderRequest;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "order-request")
public class OrderRequestCache implements Serializable {

  private String orderId;

  private OrderRequest orderRequest;

  private OrderRequestState requestState;
}
