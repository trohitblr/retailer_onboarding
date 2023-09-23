package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.RetailerCreditAudit;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerCreditAuditRepository extends R2dbcRepository<RetailerCreditAudit, UUID> {}
