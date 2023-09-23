package com.jio.bahubali.entity.jpa;

import com.jio.bahubali.enums.ProductStatus;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("product_returns")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ProductReturns {

  @Id private UUID id;

  @Column("return_seq_id")
  private int returnSeqId;

  @Column("order_id")
  private String orderId;

  @Column("product_id")
  private String productId;

  @Column("quantity")
  private Integer quantity;

  @Column("org_unit_mrp")
  private BigDecimal orgUnitMrp;

  @Column("processed_unit_price")
  private BigDecimal processedUnitPrice;

  @Column("dis_processed_unit_price")
  private BigDecimal disProcessedUnitPrice;

  @Column("dis_price_diff")
  private BigDecimal disPriceDiff;

  @Column("status")
  private ProductStatus status;

  @Column("created_at")
  private LocalDateTime createdAt;
}
