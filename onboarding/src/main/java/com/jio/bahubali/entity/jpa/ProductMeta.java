package com.jio.bahubali.entity.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("product_meta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMeta extends BaseEntity {
  @Id private UUID id;

  @Column("order_id")
  private String orderId;

  @Column("product_id")
  private String productId;

  @Column("is_home_delivery")
  private Boolean isHomeDelivery;

  @Column("gift_article")
  private Integer giftArticle;

  @Column("merchant_id")
  private String merchantId;

  @Column("margin")
  private BigDecimal margin;

  @Column("margin_percentage")
  private Float marginPercentage;

  @Column("merchant_gstin")
  private String merchantGSTIN;

  @Column("dc_id")
  private String dcId;

  @Column("imei_validation")
  private Boolean imeiValidation;

  @Column("coupon_code")
  private String couponCode;

  @Column("promo_group")
  private String promoGroup;

  @Column("expiry_date")
  private LocalDateTime expiryDate;

  @Column("country_of_origin")
  private String countryOfOrigin;

  @Column("coupon_discount")
  private String couponDiscount;

  @Column("line_no")
  private String lineNo;

  @Column("line_val")
  private String lineVal;

  @Column("item_no")
  private String itemNo;

  @Column("item_val")
  private String itemVal;

  @Column("item_details")
  private String itemDetails;

  @Column("ref_no")
  private String refNo;

  @Column("ref_val")
  private String refVal;

  @Column("is_hazmat")
  private boolean isHazmat;

  @Column("is_liquid")
  private boolean isLiquid;

  @Column("is_fragile")
  private boolean isFragile;

  @Column("delivery_type")
  private String deliveryType;

  @Column("transport_mode")
  private String transportMode;

  @Column("assign_container")
  private boolean assignContainer;

  @Column("lookup_inventory")
  private boolean lookupInventory;

  @Column("procurement_date")
  private String procurementDate;

  @Column("assign_dp_from_sb")
  private boolean assignDpFromSb;

  @Column("available_at_3p_kirana")
  private boolean availableAt3pKirana;

  @Column("item_size")
  private String itemSize;

  @Column("item_id")
  private String itemId;

  @Column("ladder_price_tag")
  private String ladderPriceTag;

  @Column("price_tag")
  private String priceTag;

  @Column("igst")
  private BigDecimal igst;

  @Column("scheme_discount")
  private BigDecimal schemeDiscount;
}
