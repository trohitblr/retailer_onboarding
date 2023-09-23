package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.RetailerAccount;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RetailerAccountRepository extends R2dbcRepository<RetailerAccount, UUID> {

  @Query(
      "SELECT ra.prm_id,"
          + "ra.account_number "
          + "FROM retailer_account ra "
          + "WHERE ra.account_number = :accountNumber")
  Mono<RetailerAccount> findByAccountNumber(@Param("accountNumber") String accountNumber);
}
