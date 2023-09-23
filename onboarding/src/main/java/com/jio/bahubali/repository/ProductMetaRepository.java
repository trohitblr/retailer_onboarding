package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.ProductMeta;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductMetaRepository extends R2dbcRepository<ProductMeta, UUID> {

  Flux<ProductMeta> findByOrderId(String orderId);
}
