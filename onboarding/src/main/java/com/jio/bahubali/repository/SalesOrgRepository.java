package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.SalesOrgInfo;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SalesOrgRepository extends R2dbcRepository<SalesOrgInfo, UUID> {
  Mono<SalesOrgInfo> findBySalesDocumentType(String salesDocumentType);
}
