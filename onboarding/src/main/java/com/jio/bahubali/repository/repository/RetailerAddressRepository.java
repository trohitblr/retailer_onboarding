package com.jio.bahubali.repository.repository;

import com.jio.bahubali.entity.personal.RetailerAddressEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface RetailerAddressRepository extends R2dbcRepository<RetailerAddressEntity, UUID> {
  Mono<RetailerAddressEntity> findByRetailerId(String retailerId);
}
