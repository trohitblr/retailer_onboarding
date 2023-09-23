package com.jio.bahubali.entity.jpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.jio.bahubali.enums.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(callSuper = true)
@Table("orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order extends BaseEntity {
  @Id private UUID id;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @Column("created_at")
  private LocalDateTime createdAt;

  @Column("order_id")
  private String orderId;

  @Column("channel_type")
  private ChannelType channelType;

  @Column("oms_id")
  private String omsId;

  @Column("channel_order_id")
  private String channelOrderId;

  @Column("order_type")
  private OrderType orderType;

  @Column("fulfillment_center_id")
  private String fulfillmentCenterId;

  @Column("fulfillment_type")
  private FulfillmentType fulfillmentType;

  @Column("gross_total")
  private BigDecimal grossTotal;

  @Column("total_product_discount")
  private BigDecimal totalProductDiscount;

  @Column("total_order_discount")
  private BigDecimal totalOrderDiscount;

  @Column("total_savings")
  private BigDecimal totalSavings;

  @Column("delivery_charges")
  private BigDecimal deliveryCharges;

  @Column("final_order_amount")
  private BigDecimal finalOrderAmount;

  @Column("coupon")
  private String coupon;

  @Column("source")
  private SourceType source;

  @Column("created_by")
  private String createdBy;

  @Column("mixed_cart")
  private Boolean mixedCart;

  @Column("whatsapp_notification")
  private Boolean whatsappNotification;

  @Column("created_on")
  private LocalDateTime createdOn;

  @Column("status")
  private Status status;

  @Column("pick_type")
  private Boolean pickType;

  @Column("ship_type")
  private String shipType;

  @Column("slot_ref_no")
  private String slotRefNo;

  @Column("order_reference")
  private String orderReference;

  @Column("typevalue")
  private String typevalue;

  @Column("payment_method_type")
  private PaymentMethodType paymentMethodType;

  @Column("req_curr_status")
  private String reqCurrStatus;

  @Column("order_status")
  private OrderStatus orderStatus;

  @Column("fos_id")
  private String fosId;

  @Column("beat_id")
  private String beatId;

  @Column("prm_id")
  private String prmId;

  @Column("seller_prm_id")
  private String sellerPrmId;

  @Column("buyer_prm_id")
  private String buyerPrmId;

  @JsonProperty("buyer_store_id")
  private String buyerStoreId;

  @Column("approval_status")
  private OrderApprovalStatus approvalStatus;

  @Column("approves_id")
  private String approvesId;

  @Column("latitude")
  private String latitude;;

  @Column("longitude")
  private String longitude;

  @Column("parent_order_id")
  private String parentOrderId;

  @Column("invoice_status")
  private String invoiceStatus = InvoiceStatus.PENDING.toString();

  @Column("order_return_seq_id")
  private Integer orderReturnSeqId = 0;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @Column("return_expire")
  private LocalDateTime returnExpire;
}
