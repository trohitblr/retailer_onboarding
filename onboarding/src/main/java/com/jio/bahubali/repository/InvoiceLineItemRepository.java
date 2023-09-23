package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.InvoiceLineItem;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface InvoiceLineItemRepository extends R2dbcRepository<InvoiceLineItem, UUID> {
  @Query(
      "SELECT il.id,"
          + "il.sku, "
          + "il.processed_quantity, "
          + "il.org_unit_mrp, "
          + "il.order_unit_price, "
          + "il.processed_unit_price, "
          + "il.invoice_number,"
          + "il.cgst , "
          + "il.sgst , "
          + "il.cgst_amount , "
          + "il.sgst_amount , "
          + "il.sale_type , "
          + "il.cess , "
          + "il.cess_amount, "
          + "il.hsn, "
          + "il.product_discount, "
          + "il.margin, "
          + "il.scheme_discount, "
          + "il.igst, "
          + "il.igst_amount , "
          + "il.product_distribution_type "
          + "FROM invoice_lines il "
          + "LEFT JOIN invoice i on i.invoice_number = il.invoice_number "
          + "LEFT JOIN orders o ON o.channel_order_id = i.channel_order_id "
          + "WHERE il.invoice_number = :invoiceId  AND (o.approval_status = 'FULL_RETURN' OR il.processed_quantity <> 0)")
  Flux<InvoiceLineItem> findByInvoiceId(@Param("invoiceId") String invoiceId);

  @Query(
      "SELECT il.id,"
          + "il.sku, "
          + "il.processed_quantity, "
          + "il.org_unit_mrp, "
          + "il.order_unit_price, "
          + "il.processed_unit_price, "
          + "il.invoice_number,"
          + "il.cgst , "
          + "il.sgst , "
          + "il.cgst_amount , "
          + "il.sgst_amount , "
          + "il.sale_type , "
          + "il.cess , "
          + "il.cess_amount, "
          + "il.hsn, "
          + "il.product_discount, "
          + "il.igst, "
          + "il.igst_amount , "
          + "il.product_distribution_type "
          + "FROM invoice_lines il "
          + "WHERE il.invoice_number = :invoiceId AND il.sku = :sku ")
  Mono<InvoiceLineItem> findByInvoiceNumberAndSkuV2(
      @Param("invoiceId") String invoiceNumber, @Param("sku") String sku);

  Mono<InvoiceLineItem> findByInvoiceNumberAndSku(String invoiceNumber, String sku);
}
