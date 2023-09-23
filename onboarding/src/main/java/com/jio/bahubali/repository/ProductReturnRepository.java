package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.ProductReturns;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReturnRepository extends R2dbcRepository<ProductReturns, UUID> {}
