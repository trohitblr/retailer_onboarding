package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.OrderApproval;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OrderApprovalRepository extends R2dbcRepository<OrderApproval, UUID> {

  @Query("SELECT * FROM order_approval WHERE channel_order_id=$1 order by approval_level ASC")
  Flux<OrderApproval> findAllOrderApprovalByOrderId(String orderId);

  Mono<OrderApproval> findOrderApprovalByOrderIdAndApprovesId(String orderId, String approvesId);
}
