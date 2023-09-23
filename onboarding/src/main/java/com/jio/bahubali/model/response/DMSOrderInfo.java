package com.jio.bahubali.model.response;

import com.jio.bahubali.enums.OrderApprovalStatus;
import com.jio.bahubali.enums.ProductDistributionType;
import com.jio.bahubali.enums.ProductStatus;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.relational.core.mapping.Column;

@Data
@EqualsAndHashCode
public class DMSOrderInfo {

  @Column("channel_order_id")
  private String orderId;

  @Column("order_id")
  private String falconOrderId;

  @Column("gross_total")
  private BigDecimal grossTotal;

  @Column("total_product_discount")
  private BigDecimal totalProductSavings;

  @Column("order_status")
  private String orderStatus;

  @Column("buyer_prm_id")
  private String buyerPrmId;

  @Column("seller_prm_id")
  private String sellerPrmId;

  @Column("status")
  private String status;

  @Column("approval_status")
  private OrderApprovalStatus approvalStatus;

  @Column("approves_id")
  private String approvesId;

  @Column("total_order_discount")
  private BigDecimal totalOrderDiscount;

  @Column("final_order_amount")
  private BigDecimal finalOrderAmount;

  @Column("buyer_store_id")
  private String buyerStoreId;

  @Column("created_at")
  private String createdAt;

  @Column("quantity")
  private String quantity;

  @Column("order_item_id")
  private String orderItemId;

  @Column("sku")
  private String sku;

  @Column("fos_id")
  private String fosId;

  @Column("beat_id")
  private String beatId;

  @Column("sale_type")
  private String description;

  @Column("org_unit_mrp")
  private String unitMrp;

  @Column("order_unit_price")
  private String productUnitPrice;

  @Column("processed_unit_price")
  private String processedUnitPrice;

  @Column("dis_processed_unit_price")
  private String discountedPrice;

  @Column("images")
  private String images;

  @Column("item_size")
  private String itemSize;

  @Column("item_id")
  private String itemId;

  @Column("ladder_price_tag")
  private String ladderPriceTag;

  @Column("price_tag")
  private String priceTag;

  @Column("parent_order_id")
  private String parentOrderId;

  @Column("product_distribution_type")
  private ProductDistributionType productDistributionType;

  @Column("product_status")
  private ProductStatus productStatus;

  @Column("return_expire")
  private String returnExpire;
}
