package com.jio.bahubali.repository;

import com.jio.bahubali.entity.jpa.InvoiceProduct;
import com.jio.bahubali.entity.jpa.Product;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, UUID> {

  @Query(
      "SELECT p.sku, "
          + " p.quantity, "
          + " p.org_unit_mrp, "
          + " p.order_unit_price, "
          + " p.dis_processed_unit_price "
          +
          // " p.gst_slave "+
          " from products p "
          + " WHERE p.order_id = :orderId ")
  Flux<Product> findByOrderId(@Param("orderId") String orderId);

  Flux<Product> findProductByOrderId(String orderId);

  @Query(
      "SELECT p.sku, "
          + " p.processed_quantity, "
          + "  p.org_unit_mrp, "
          + " p.order_unit_price, "
          + " p.processed_unit_price,  "
          + "  p.cgst, "
          + "  p.sgst, "
          + " p.cess, "
          + " p.sale_type, "
          + " p.hsn, "
          + " pm.margin, "
          + "  pm.scheme_discount, "
          + "  p.product_distribution_type "
          + "  FROM products p "
          + " INNER JOIN product_meta pm ON p.id = pm.product_id::uuid  "
          + "  WHERE p.order_id = :orderId AND p.product_status <> 'DELETED' ")
  Flux<InvoiceProduct> findProductsByOrderId(@Param("orderId") String orderId);
}
