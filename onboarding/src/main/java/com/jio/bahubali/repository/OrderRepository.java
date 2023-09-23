package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.Invoice;
import com.jio.bahubali.entity.jpa.Order;
import com.jio.bahubali.entity.jpa.Product;
import com.jio.bahubali.model.request.OrderItemProductDTO;
import com.jio.bahubali.model.request.OrderSearchDto;
import com.jio.bahubali.model.response.DMSOrderInfo;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OrderRepository extends R2dbcRepository<Order, UUID> {

  @Query(
      "SELECT o.order_id as order_id,"
          + "o.channel_order_id as channel_order_id,"
          + "p.sku as sku,"
          + "p.parent_sku as parent_sku,"
          + "oi.quantity as quantity,"
          + "oi.order_item_id as order_item_id,"
          + "oi.id as orderitem_id,"
          + "oi.product_id as product_id,"
          + "p.seq_id as seq_id,"
          + "p.parent_seq_id as parent_seq_id,"
          + "p.transporter_id as transporter_id,"
          + "p.sioc_flag as sioc_flag,"
          + "p.prm_id as prm_id,"
          + "p.product_type as product_type,"
          + "p.mode_of_transport as mode_of_transport,"
          + "o.channel_type as channel_type "
          + "FROM orders o "
          + "INNER JOIN order_items oi ON oi.order_id = o.order_id "
          + "INNER JOIN products p ON oi.order_item_id  = p.order_item_id "
          + "WHERE o.order_id = $1")
  Flux<OrderItemProductDTO> findByOrderIdWithOrderItemsAndProducts(String orderId);

  Mono<Order> findByChannelOrderId(String channelOrderId);

  Mono<Order> findByChannelOrderIdAndBuyerPrmId(String channelOrderId, String buyerPrmId);

  @Query(
      "SELECT o.order_id as order_id,"
          + "o.channel_order_id as channel_order_id,"
          + "o.created_at as created_at,"
          + "o.order_status as order_status,"
          + "o.channel_type as channel_type,"
          + "o.order_type as order_type,"
          + "o.final_order_amount as final_order_amount,"
          + "o.payment_method_type as payment_method_type,"
          + "c.customer_id as customer_id,"
          + "c.customer_name as customer_name,"
          + "c.email_id as email_id,"
          + "c.contact_number as contact_number,"
          + "ad.flat_no as flat_no,"
          + "ad.floor_no as floor_no,"
          + "ad.block_no as block_no,"
          + "ad.society_name as society_name,"
          + "ad.plot_no as plot_no,"
          + "ad.street as street,"
          + "ad.sector as sector,"
          + "ad.area as area,"
          + "ad.city as city,"
          + "ad.state as state,"
          + "ad.pincode as pincode,"
          + "ad.country as country,"
          + "oi.order_item_id as order_item_id,"
          + "oi.shipment_id as shipment_id,"
          + "oi.shipment_status as shipment_status,"
          + "p.sku as sku,"
          + "p.delivery_date as delivery_date,"
          + "p.org_unit_mrp as org_unit_mrp,"
          + "p.processed_unit_price as processed_unit_price,"
          + "p.processed_quantity as quantity,"
          + "p.fulfillment_center_id as fulfillment_center_id,"
          + "p.sale_type as sale_type,"
          + "p.transporter_id as transporter_id,"
          + "p.delivery_date as delivery_date "
          + "FROM orders o "
          + "INNER JOIN customer c ON c.order_id = o.order_id "
          + "INNER JOIN address_details ad ON ad.order_id = o.order_id "
          + "INNER JOIN order_items oi ON oi.order_id = o.order_id "
          + "INNER JOIN products p ON oi.order_item_id  = p.order_item_id "
          + "WHERE o.channel_order_id = $1 AND ad.address_detail_type = 'SHIPPING' ")
  Flux<OrderSearchDto> findWholeOrderInfoByChannelOrderId(String orderId, PageRequest pageRequest);

  @Query(
      "SELECT o.order_id as order_id,"
          + "o.channel_order_id as channel_order_id,"
          + "o.created_at as created_at,"
          + "o.order_status as order_status,"
          + "o.channel_type as channel_type,"
          + "o.order_type as order_type,"
          + "o.final_order_amount as final_order_amount,"
          + "o.payment_method_type as payment_method_type,"
          + "c.customer_id as customer_id,"
          + "c.customer_name as customer_name,"
          + "c.email_id as email_id,"
          + "c.contact_number as contact_number,"
          + "ad.flat_no as flat_no,"
          + "ad.floor_no as floor_no,"
          + "ad.block_no as block_no,"
          + "ad.society_name as society_name,"
          + "ad.plot_no as plot_no,"
          + "ad.street as street,"
          + "ad.sector as sector,"
          + "ad.area as area,"
          + "ad.city as city,"
          + "ad.state as state,"
          + "ad.pincode as pincode,"
          + "ad.country as country,"
          + "oi.order_item_id as order_item_id,"
          + "oi.shipment_id as shipment_id,"
          + "oi.shipment_status as shipment_status,"
          + "p.sku as sku,"
          + "p.delivery_date as delivery_date,"
          + "p.org_unit_mrp as org_unit_mrp,"
          + "p.processed_unit_price as processed_unit_price,"
          + "p.processed_quantity as quantity,"
          + "p.fulfillment_center_id as fulfillment_center_id,"
          + "p.sale_type as sale_type,"
          + "p.transporter_id as transporter_id,"
          + "p.delivery_date as delivery_date "
          + "FROM orders o "
          + "INNER JOIN customer c ON c.order_id = o.order_id "
          + "INNER JOIN address_details ad ON ad.order_id = o.order_id "
          + "INNER JOIN order_items oi ON oi.order_id = o.order_id "
          + "INNER JOIN products p ON oi.order_item_id  = p.order_item_id "
          + "WHERE o.created_at >= $1::date AND CAST(o.created_at as DATE) <= $2::date AND ad.address_detail_type = 'SHIPPING' ")
  Flux<OrderSearchDto> findWholeOrderInfoByDateRange(
      String startDate, String endDate, PageRequest pageRequest);

  @Query(
      "SELECT p.sku, "
          + "o.order_id, "
          + "p.processed_quantity AS quantity, "
          + "o.channel_order_id, "
          + "TO_CHAR(o.created_at, 'YYYY-MM-DD HH24:MI:SS') AS created_at, "
          + "TO_CHAR(o.return_expire, 'YYYY-MM-DD HH24:MI:SS') AS return_expire, "
          + "o.channel_type, "
          + "o.gross_total, "
          + "o.final_order_amount, "
          + "o.total_product_discount, "
          + "o.buyer_store_id, "
          + "o.buyer_prm_id, "
          + "o.seller_prm_id, "
          + "o.total_order_discount, "
          + "o.fos_id, "
          + "o.beat_id, "
          + "o.approves_id, "
          + "o.approval_status, "
          + "o.parent_order_id, "
          + "pm.item_size, "
          + "pm.item_id, "
          + "pm.ladder_price_tag, "
          + "pm.price_tag, "
          + "p.dis_processed_unit_price, "
          + "p.sale_type, "
          + "p.org_unit_mrp, "
          + "o.status, "
          + "p.order_unit_price, "
          + "p.processed_unit_price, "
          + "p.product_status, "
          + "o.order_status, "
          + "p.images,"
          + "p.product_distribution_type "
          + "FROM orders o "
          + "LEFT JOIN products p ON p.order_id = o.order_id "
          + "LEFT JOIN product_meta pm ON pm.product_id = p.id::text "
          + "WHERE o.channel_order_id IN (:orderIds) "
          + "AND ((o.approval_status = 'FULL_RETURN' OR p.processed_quantity <> 0) AND p.product_status <> 'DELETED') ")
  Flux<DMSOrderInfo> findByOrderIds(@Param("orderIds") List<String> orderIds);

  @Query(
      "SELECT p.sku, "
          + "p.processed_quantity AS quantity, "
          + "o.channel_order_id, "
          + "TO_CHAR(o.created_at, 'YYYY-MM-DD HH24:MI:SS') AS created_at, "
          + "TO_CHAR(o.return_expire, 'YYYY-MM-DD HH24:MI:SS') AS return_expire, "
          + "o.channel_type, "
          + "o.gross_total, "
          + "o.final_order_amount, "
          + "o.total_product_discount, "
          + "o.buyer_store_id, "
          + "o.buyer_prm_id, "
          + "o.seller_prm_id, "
          + "o.total_order_discount, "
          + "o.fos_id, "
          + "o.beat_id, "
          + "o.approves_id, "
          + "o.approval_status, "
          + "p.dis_processed_unit_price, "
          + "p.sale_type, "
          + "p.org_unit_mrp, "
          + "o.status, "
          + "o.order_status, "
          + "p.order_unit_price, "
          + "p.processed_unit_price, "
          + "p.images "
          + "FROM orders o "
          + "LEFT JOIN products p ON p.order_id = o.order_id "
          + "WHERE o.fos_id IN (:fosIds) "
          + "AND (:fromDate IS NULL OR :toDate IS NULL OR (o.created_at BETWEEN :fromDate AND :toDate)) ")
  Flux<DMSOrderInfo> findByFosIds(
      @Param("fosIds") List<String> fosIds,
      @Param("fromDate") LocalDateTime fromDate,
      @Param("toDate") LocalDateTime toDate);

  @Query(
      "SELECT p.sku, "
          + "p.processed_quantity AS quantity, "
          + "o.channel_order_id, "
          + "TO_CHAR(o.created_at, 'YYYY-MM-DD HH24:MI:SS') AS created_at, "
          + "o.channel_type, "
          + "o.gross_total, "
          + "o.total_product_discount, "
          + "o.final_order_amount, "
          + "o.buyer_store_id, "
          + "o.buyer_prm_id, "
          + "o.seller_prm_id, "
          + "o.total_order_discount, "
          + "o.fos_id, "
          + "o.beat_id, "
          + "o.approves_id, "
          + "o.approval_status, "
          + "o.order_status, "
          + "p.dis_processed_unit_price, "
          + "p.sale_type, "
          + "p.org_unit_mrp, "
          + "o.status, "
          + "p.product_status, "
          + "p.order_unit_price, "
          + "p.processed_unit_price, "
          + "p.images "
          + "FROM orders o "
          + "LEFT JOIN products p ON p.order_id = o.order_id "
          + "WHERE o.prm_id = :prmId "
          + "AND (:fromDate IS NULL OR :toDate IS NULL OR (o.created_at BETWEEN :fromDate AND :toDate)) "
          + "AND ((o.approval_status = 'FULL_RETURN' OR p.processed_quantity <> 0) AND p.product_status <> 'DELETED') ")
  Flux<DMSOrderInfo> findByPrmIds(
      @Param("prmId") String prmId,
      @Param("fromDate") LocalDateTime fromDate,
      @Param("toDate") LocalDateTime toDate);

  @Query(
      "SELECT p.sku, "
          + "p.processed_quantity AS quantity, "
          + "o.channel_order_id, "
          + "TO_CHAR(o.created_at, 'YYYY-MM-DD HH24:MI:SS') AS created_at, "
          + "TO_CHAR(o.return_expire, 'YYYY-MM-DD HH24:MI:SS') AS return_expire, "
          + "o.channel_type, "
          + "o.gross_total, "
          + "o.total_product_discount, "
          + "o.final_order_amount, "
          + "o.buyer_store_id, "
          + "o.buyer_prm_id, "
          + "o.seller_prm_id, "
          + "o.total_order_discount, "
          + "o.fos_id, "
          + "o.beat_id, "
          + "o.approves_id, "
          + "o.approval_status, "
          + "p.dis_processed_unit_price, "
          + "p.sale_type, "
          + "p.org_unit_mrp, "
          + "o.status, "
          + "o.order_status, "
          + "p.order_unit_price, "
          + "p.processed_unit_price, "
          + "p.images "
          + "FROM orders o "
          + "LEFT JOIN products p ON p.order_id = o.order_id "
          + "WHERE o.beat_id IN (:beatIds) "
          + "AND (:fromDate IS NULL OR :toDate IS NULL OR (o.created_at BETWEEN :fromDate AND :toDate)) AND "
          + "((o.approval_status = 'FULL_RETURN' OR p.processed_quantity <> 0) AND p.product_status <> 'DELETED')  ")
  Flux<DMSOrderInfo> findByBeatId(
      @Param("beatIds") List<String> beatIds,
      @Param("fromDate") LocalDateTime fromDate,
      @Param("toDate") LocalDateTime toDate);

  @Query(
      "SELECT p.sku, "
          + "p.processed_quantity AS quantity, "
          + "o.channel_order_id, "
          + "TO_CHAR(o.created_at, 'YYYY-MM-DD HH24:MI:SS') AS created_at, "
          + "TO_CHAR(o.return_expire, 'YYYY-MM-DD HH24:MI:SS') AS return_expire, "
          + "o.channel_type, "
          + "o.gross_total, "
          + "o.final_order_amount, "
          + "o.total_product_discount, "
          + "o.buyer_store_id, "
          + "o.buyer_prm_id, "
          + "o.seller_prm_id, "
          + "o.order_status, "
          + "o.parent_order_id, "
          + "pm.item_size, "
          + "pm.item_id, "
          + "pm.ladder_price_tag, "
          + "pm.price_tag, "
          + "o.total_order_discount, "
          + "o.fos_id, "
          + "o.approves_id, "
          + "o.approval_status, "
          + "p.dis_processed_unit_price, "
          + "p.sale_type, "
          + "p.org_unit_mrp, "
          + "o.status, "
          + "p.product_status, "
          + "p.order_unit_price, "
          + "p.processed_unit_price, "
          + "p.images,"
          + "p.product_distribution_type "
          + "FROM orders o "
          + "LEFT JOIN products p ON p.order_id = o.order_id "
          + "LEFT JOIN product_meta pm ON pm.product_id = p.id::text "
          + "WHERE o.channel_order_id IN ( "
          + "   SELECT channel_order_id "
          + "   FROM order_approval oa "
          + "   WHERE oa.approves_id = :approvesId "
          + "   AND oa.status IN (:approvalStatuses) "
          + "   AND (:fromDate IS NULL OR :toDate IS NULL OR (oa.created_at >= :fromDate::date AND CAST(oa.created_at as DATE) <= :toDate::date)) "
          + "   ORDER BY oa.created_at DESC "
          + "   LIMIT :limit OFFSET :offset "
          + ") "
          + "AND ((o.approval_status = 'FULL_RETURN' OR p.processed_quantity <> 0) AND p.product_status <> 'DELETED') ")
  Flux<DMSOrderInfo> findByApprovesId(
      @Param("approvesId") String approvesId,
      @Param("approvalStatuses") Collection<String> approvalStatuses,
      @Param("fromDate") String fromDate,
      @Param("toDate") String toDate,
      @Param("limit") int limit,
      @Param("offset") int offset);

  @Query(
      "SELECT p.sku, "
          + "p.processed_quantity AS quantity, "
          + "o.channel_order_id, "
          + "TO_CHAR(o.created_at, 'YYYY-MM-DD HH24:MI:SS') AS created_at, "
          + "TO_CHAR(o.return_expire, 'YYYY-MM-DD HH24:MI:SS') AS return_expire, "
          + "o.channel_type, "
          + "o.gross_total, "
          + "o.final_order_amount, "
          + "o.total_product_discount, "
          + "o.buyer_store_id, "
          + "o.buyer_prm_id, "
          + "o.seller_prm_id, "
          + "o.order_status, "
          + "o.parent_order_id, "
          + "pm.item_size, "
          + "pm.item_id, "
          + "pm.ladder_price_tag, "
          + "pm.price_tag, "
          + "o.total_order_discount, "
          + "o.fos_id, "
          + "o.approves_id, "
          + "o.approval_status, "
          + "p.dis_processed_unit_price, "
          + "p.sale_type, "
          + "p.org_unit_mrp, "
          + "o.status, "
          + "p.product_status, "
          + "p.order_unit_price, "
          + "p.processed_unit_price, "
          + "p.images,"
          + "p.product_distribution_type "
          + "FROM orders o "
          + "LEFT JOIN products p ON p.order_id = o.order_id "
          + "LEFT JOIN product_meta pm ON pm.product_id = p.id::text "
          + "WHERE o.channel_order_id IN ( "
          + "   SELECT channel_order_id "
          + "   FROM orders o "
          + "   WHERE o.buyer_prm_id = :prmId "
          + "   AND o.approval_status IN (:approvalStatuses) "
          + "   AND (:fromDate IS NULL OR :toDate IS NULL OR (o.created_at >= :fromDate::date AND CAST(o.created_at as DATE) <= :toDate::date)) "
          + "   ORDER BY o.created_at DESC "
          + "   LIMIT :limit OFFSET :offset "
          + ") "
          + "AND ((o.approval_status = 'FULL_RETURN' OR p.processed_quantity <> 0) AND p.product_status <> 'DELETED') ")
  Flux<DMSOrderInfo> findByBuyerPrmId(
      @Param("prmId") String prmId,
      @Param("approvalStatuses") Collection<String> approvalStatuses,
      @Param("fromDate") String fromDate,
      @Param("toDate") String toDate,
      @Param("limit") int limit,
      @Param("offset") int offset);

  @Query(
      "SELECT COUNT(oa.channel_order_id) "
          + "FROM order_approval oa "
          + "WHERE oa.approves_id = :approvesId "
          + "AND oa.status IN (:approvalStatuses) "
          + "AND (:fromDate IS NULL OR :toDate IS NULL OR (oa.created_at >= :fromDate::date AND CAST(oa.created_at as DATE) <= :toDate::date))")
  Mono<Integer> getTotalCountOrderForApprove(
      @Param("approvesId") String approvesId,
      @Param("approvalStatuses") Collection<String> approvalStatuses,
      @Param("fromDate") String fromDate,
      @Param("toDate") String toDate);

  @Query(
      "SELECT COUNT(o.channel_order_id) "
          + "FROM orders o "
          + "WHERE o.buyer_prm_id = :prmId "
          + "AND o.approval_status IN (:approvalStatuses) "
          + "AND (:fromDate IS NULL OR :toDate IS NULL OR (o.created_at >= :fromDate::date AND CAST(o.created_at as DATE) <= :toDate::date))")
  Mono<Integer> getTotalCountOrderForBuyer(
      @Param("prmId") String buyerPrmId,
      @Param("approvalStatuses") Collection<String> approvalStatuses,
      @Param("fromDate") String fromDate,
      @Param("toDate") String toDate);

  @Query(
      "SELECT p.sku, "
          + " p.processed_quantity, "
          + " p.org_unit_mrp, "
          + " p.order_unit_price, "
          + " p.processed_unit_price , "
          + "p.cgst , "
          + "p.sgst , "
          + "p.cess , "
          + "p.sale_type , "
          + "p.hsn , "
          + "p.product_distribution_type"
          + " from products p "
          + " WHERE p.order_id = :orderId AND p.product_status <> 'DELETED' ")
  Flux<Product> findProductByOrderId(@Param("orderId") String orderId);

  @Query(
      "SELECT o.channel_order_id, "
          + "o.order_id , "
          + "o.order_status , "
          + "o.channel_type, "
          + "o.final_order_amount, "
          + "o.buyer_store_id, "
          + "o.total_order_discount, "
          + "o.seller_prm_id ,"
          + "o.buyer_prm_id "
          + "FROM orders o "
          + "WHERE o.channel_order_id = (:orderId) ")
  Flux<Invoice> findByOrderId(@Param("orderId") String orderIds);
}
