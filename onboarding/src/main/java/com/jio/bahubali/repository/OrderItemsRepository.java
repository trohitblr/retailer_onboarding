package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.OrderItems;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderItemsRepository extends R2dbcRepository<OrderItems, UUID> {

  Flux<OrderItems> findByOrderId(String orderId);
}
