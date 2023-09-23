package com.jio.bahubali.repository.repository;

import com.jio.bahubali.entity.personal.RetailerEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface RetailerRepository extends R2dbcRepository<RetailerEntity, UUID> {
  Mono<RetailerEntity> findByRetailerId(String retailerId);

  // Flux<Retailer> getFosOnboaredRetailers(String fosId);

  // Flux<Retailer> getRetailerByLocation(String city);

  // M findByRetailerInfo(String retailerId);
}
