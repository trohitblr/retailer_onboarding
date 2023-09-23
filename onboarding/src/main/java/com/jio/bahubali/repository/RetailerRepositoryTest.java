package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.Retailer;
import com.jio.bahubali.entity.jpa.RetailerAccountInfo;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RetailerRepositoryTest extends R2dbcRepository<Retailer, UUID> {

  @Query(
      "SELECT r.prm_id,"
          + " ra.account_number, "
          + "ra.virtual_account, "
          + "ra.vertical, "
          + "ra.credit_limit, "
          + "rc.curr_account_balance, "
          + "rc.credit_balance, "
          + "rc.total_balance "
          + "FROM retailer r "
          + "INNER JOIN retailer_account ra ON ra.prm_id = r.prm_id "
          + "INNER JOIN retailer_credit rc ON rc.account_number = ra.account_number "
          + "WHERE r.prm_id = :prmId")
  Mono<RetailerAccountInfo> findRetailerInfoByPrmId(@Param("prmId") String prmId);

  @Query(
      "SELECT  ra.prm_id, "
          + " ra.credit_limit, "
          + " rc.curr_account_balance, "
          + " rc.credit_balance, "
          + " rc.total_balance "
          + " FROM retailer_account ra "
          + " INNER JOIN retailer_credit rc on ra.account_number = rc.account_number "
          + " WHERE ra.prm_id = :prm_id")
  Mono<RetailerAccountInfo> findRetailerCreditInfoByPrmId(@Param("prmId") String prmId);
}
