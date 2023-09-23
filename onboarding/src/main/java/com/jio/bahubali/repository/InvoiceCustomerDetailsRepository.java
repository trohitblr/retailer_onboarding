package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.InvoiceCustomerDetails;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface InvoiceCustomerDetailsRepository
    extends R2dbcRepository<InvoiceCustomerDetails, UUID> {

  @Query(
      "SELECT icd.id, "
          + "icd.channel_order_id, "
          + "icd.invoice_number,"
          + " icd.buyer_name,"
          + " icd.seller_name , "
          + "icd.seller_place ,"
          + "icd.seller_mob ,"
          + "icd.seller_gstin ,"
          + "icd.buyer_detail, "
          + "icd.seller_detail, "
          + "icd.seller_store, "
          + "icd.buyer_store_name, "
          + "icd.buyer_prm_id, "
          + "icd.buyer_gstin, "
          + "icd.buyer_mob, "
          + "icd.buyer_place, "
          + "icd.seller_prm_id  "
          + "FROM invoice_cust_details icd "
          + "WHERE icd.channel_order_id  = :orderId  ")
  Mono<InvoiceCustomerDetails> findByOrderId(@Param("orderId") String orderId);
}
