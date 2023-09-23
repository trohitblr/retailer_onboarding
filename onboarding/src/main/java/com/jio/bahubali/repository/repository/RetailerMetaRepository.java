package com.jio.bahubali.repository.repository;

import com.jio.bahubali.entity.personal.RetailerMetaEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RetailerMetaRepository extends R2dbcRepository<RetailerMetaEntity, UUID> {
  Mono<RetailerMetaEntity> findByRetailerId(String retailerId);
}
