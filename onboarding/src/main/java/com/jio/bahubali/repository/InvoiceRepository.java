package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.Invoice;
import com.jio.bahubali.entity.jpa.InvoiceData;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface InvoiceRepository extends R2dbcRepository<Invoice, UUID> {

  Mono<Invoice> findByChannelOrderId(String channelOrderId);

  @Query(
      " select "
          + " i.invoice_number,"
          + " i.channel_order_id,"
          + "TO_CHAR(i.invoice_date, 'YYYY-MM-DD HH24:MI:SS') AS invoice_date,"
          + " i.final_order_amount,"
          + " i.total_order_discount,"
          + " i.ship_to,"
          + " i.bill_to ,"
          + " icd.buyer_name,"
          + " icd.buyer_detail,"
          + " icd.seller_name,"
          + " icd.seller_detail,"
          + " icd.seller_place,"
          + " icd.seller_mob,"
          + " icd.seller_gstin,"
          + " icd.seller_store, "
          + " icd.buyer_store_name, "
          + "icd.buyer_prm_id, "
          + "icd.buyer_gstin, "
          + "icd.buyer_mob, "
          + "icd.buyer_place, "
          + "icd.seller_prm_id,  "
          + " TO_CHAR(o.created_at, 'YYYY-MM-DD HH24:MI:SS')  as order_created_at "
          + " from invoice i "
          + " inner join invoice_cust_details icd on i.channel_order_id = icd.channel_order_id "
          + " LEFT JOIN orders o ON o.channel_order_id = i.channel_order_id "
          + " where i.channel_order_id = (:orderId) ")
  Mono<InvoiceData> getInvoiceData(@Param("orderId") String orderId);

  @Query(
      " select "
          + "i.id, i.order_id ,i.channel_type ,i.buyer_store_id ,i.order_status, "
          + " i.invoice_number,"
          + " i.channel_order_id,"
          + "i.invoice_date ,"
          + " i.final_order_amount,"
          + " i.total_order_discount,"
          + " i.ship_to,"
          + " i.bill_to, "
          + " i.pick_list_content, "
          + "i.content, "
          + "i.seller_prm_id "
          + " from invoice i "
          + " where i.channel_order_id = :orderId ")
  Mono<Invoice> getInvoiceDataByOrderId(@Param("orderId") String orderId);

  @Query(
      "SELECT i.id, i.order_id, i.channel_type, i.buyer_store_id, i.order_status, "
          + "       i.invoice_number, i.channel_order_id, i.invoice_date, i.final_order_amount, "
          + "       i.total_order_discount, i.ship_to, i.bill_to, i.pick_list_content, i.content "
          + "FROM invoice i "
          + "WHERE i.seller_prm_id = CAST(:prmId AS VARCHAR) "
          + "AND (:fromDate IS NULL OR :toDate IS NULL OR (i.invoice_date BETWEEN :fromDate::timestamp AND :toDate::timestamp)) ")
  Flux<Invoice> getBulkInvoice(
      @Param("fromDate") LocalDateTime fromDate,
      @Param("toDate") LocalDateTime toDate,
      @Param("prmId") String prmId);
}
